package bsuir.diplom.serverapplication.utilities;

import bsuir.diplom.serverapplication.ServerApplication;
import bsuir.diplom.serverapplication.repository.netty.UserRepository;
import bsuir.diplom.serverapplication.servises.IAccountsService;
import bsuir.diplom.serverapplication.utilities.netty.NettyServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;
import java.util.HashMap;

@Log4j2
@RequiredArgsConstructor
@Component
public class Server {

    //private static volatile boolean isActive = true;
    //private static final ThreadGroup threadGroup = new ThreadGroup("serverGroup");
    //private static final FilePropertyReader freader = new FilePropertyReader();

    private final ServerBootstrap serverBootstrap;
    private final InetSocketAddress port;

    private final UserRepository userRepository;

    private Channel serverChannel;

    @PostConstruct
    public void start() {
        try{
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            log.info("Server is started : port {}", port.getPort());
            serverChannel = channelFuture.channel().closeFuture().sync().channel();
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    @PreDestroy
    public void stop() {
        if(serverChannel != null) {
            serverChannel.close();
            serverChannel.parent().close();
            log.info("Close Netty");
        }
    }
}
