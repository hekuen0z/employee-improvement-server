package bsuir.diplom.serverapplication.repository.netty;

import bsuir.diplom.serverapplication.servises.IAccountsService;
import bsuir.diplom.serverapplication.servises.ICasesService;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Log4j2
@Component
public class UserRepository {
    private static final HashMap<String, String> userInfo = new HashMap<>();

    private final IAccountsService accountsService;

    @Autowired
    public UserRepository(IAccountsService accountsService) {
        this.accountsService = accountsService;
    }

    public void fillAuthHashMap(){
        userInfo.putAll(accountsService.getAuthData());
    }

    public String getPasswordByUsername(String username) {
        return userInfo.get(username);
    }

    public void setUserInfo(String key, String value) {
        userInfo.put(key, value);
    }

}
