package bsuir.diplom.serverapplication.servises;

import bsuir.diplom.serverapplication.entities.AccountsEntity;

import java.util.HashMap;
import java.util.Set;

public interface IAccountsService {
    Set<AccountsEntity> findAll();
    AccountsEntity findByUsername(String username);
    AccountsEntity findById(Integer id);

    HashMap<String, String> getAuthData();
    void saveAll(HashMap<String, String> hashMap);
}
