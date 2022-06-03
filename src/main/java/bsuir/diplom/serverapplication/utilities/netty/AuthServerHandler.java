package bsuir.diplom.serverapplication.utilities.netty;

import bsuir.diplom.serverapplication.constants.StockMessageProto;
import bsuir.diplom.serverapplication.constants.StockMessageProto.StockMessage;
import bsuir.diplom.serverapplication.repository.netty.ChannelRepository;
import bsuir.diplom.serverapplication.repository.netty.UserRepository;
import bsuir.diplom.serverapplication.servises.IAccountsService;
import bsuir.diplom.serverapplication.utilities.ProtoMessageUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.UUID;


@Component
@ChannelHandler.Sharable
@Log4j2
@RequiredArgsConstructor
public class AuthServerHandler extends SimpleChannelInboundHandler<StockMessage> {

    //@NotNull private TaskExecutor taskExecutor;
    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;
    private final IAccountsService accountsService;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StockMessage msg) throws Exception {
        if(msg.getCommandType() == StockMessageProto.CommandType.REGISTRATION){
            StockMessageProto.RegistrationRequest registrationRequest = msg.getRegistrationRequest();
            if(isNewUser(msg)) {
                UUID uuid = UUID.randomUUID();
                userRepository.setUserInfo(registrationRequest.getUsername(), registrationRequest.getPassword());
                channelRepository.put(registrationRequest.getUsername(), ctx.channel());
                accountsService.saveAll((HashMap<String, String>) msg.getRegistrationRequest().getRegDataMap());
                log.info("User {} registered successfully with password {}.", registrationRequest.getUsername(), registrationRequest.getPassword());
                ctx.writeAndFlush(ProtoMessageUtil.createRegistrationResponse(
                        true, 0, "Registration completed successfully." + registrationRequest.getUsername(),
                        registrationRequest.getUsername(), uuid.toString(), ctx.channel().id().asLongText()));
            } else {
                log.info("Attempt to re-register a user:" + registrationRequest.getUsername());
                ctx.writeAndFlush(ProtoMessageUtil.createRegistrationResponse(
                        false, 100, "Registration error! An account with this username already exists: " + registrationRequest.getUsername(),
                        null, null, null));
                ctx.close();
            }
        }
        if(msg.getCommandType() == StockMessageProto.CommandType.AUTH) {
            StockMessageProto.AuthRequest authRequest = msg.getAuthRequest();
            if(!isNewUser(msg)) {
                UUID uuid = UUID.randomUUID();
                channelRepository.put(authRequest.getUsername(), ctx.channel());
                log.info("User {} login successfully.", authRequest.getUsername());
                ctx.writeAndFlush(ProtoMessageUtil.createAuthResponse(
                        true, 0, "Authorisation completed successfully.",
                        authRequest.getUsername(), uuid.toString(), ctx.channel().id().asLongText()));
            } else {
                log.info("Username not found: " + authRequest.getUsername());
                ctx.writeAndFlush(ProtoMessageUtil.createAuthResponse(
                        false, 200, "Authorisation error! An account with this username not found or incorrect password.",
                        null, null, null));
                ctx.close();
            }
        }
        ctx.fireChannelRead(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error(cause.getMessage(), cause);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Assert.notNull(this.channelRepository, "[Assertion failed] - ChannelRepository is required; it must not be null");
        if (log.isDebugEnabled()) {
            log.debug(ctx.channel().remoteAddress() + "");
            log.debug("Bound Channel Count is {}", this.channelRepository.size());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
//        Assert.notNull(this.channelRepository, "[Assertion failed] - ChannelRepository is required; it must not be null");
//        Assert.notNull(ctx, "[Assertion failed] - ChannelHandlerContext is required; it must not be null");
//
//        //User.current(ctx.channel()).logout(this.channelRepository, ctx.channel());
//        if (log.isDebugEnabled()) {
//            log.debug("Channel Count is " + this.channelRepository.size());
//        }
    }

    private boolean isNewUser(StockMessage msg) {
        if(msg.getCommandType() == StockMessageProto.CommandType.AUTH) {
            StockMessageProto.AuthRequest authRequest = msg.getAuthRequest();
            if (userRepository.getPasswordByUsername(authRequest.getUsername()) != null) {
                return true;
            }
            return false;
        } else if (msg.getCommandType() == StockMessageProto.CommandType.REGISTRATION) {
            StockMessageProto.RegistrationRequest registrationRequest = msg.getRegistrationRequest();
            if (userRepository.getPasswordByUsername(registrationRequest.getUsername()) != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean isCorrectUser(StockMessageProto.AuthRequest msg) {
        if(userRepository.getPasswordByUsername(msg.getUsername()).equals(msg.getPassword())){
            return true;
        }
        return false;
    }
}
