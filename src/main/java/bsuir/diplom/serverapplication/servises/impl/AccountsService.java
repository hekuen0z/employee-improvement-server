package bsuir.diplom.serverapplication.servises.impl;

import bsuir.diplom.serverapplication.entities.AccountsEntity;
import bsuir.diplom.serverapplication.repository.AccountsRepository;
import bsuir.diplom.serverapplication.servises.IAccountsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Log4j2
@Service
@Repository
@Transactional
public class AccountsService implements IAccountsService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Override
    public Set<AccountsEntity> findAll() {
        Set<AccountsEntity> tempSet = new HashSet<>(accountsRepository.findAll());
        return tempSet;
    }

    @Override
    public AccountsEntity findByUsername(String username) {
        return Optional.ofNullable(accountsRepository.findAccountsEntityByUsername(username))
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + username));
    }

    @Override
    public AccountsEntity findById(Integer id) {
        return Optional.ofNullable(accountsRepository.findAccountsEntityById(id))
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    @Override
    public HashMap<String, String> getAuthData() {
        Set<String> accountsEntitySet = new HashSet<>(Optional.ofNullable(accountsRepository.getAuthData())
                .orElseThrow(() -> new NoSuchElementException("Resources for auth not found")));
        HashMap<String, String> hashMap = new HashMap<>();
        for (String ae: accountsEntitySet) {
            String[] stringSplit = ae.split(",");
            hashMap.put(stringSplit[0], stringSplit[1]);
        }
        return hashMap;
    }

    @Override
    public void saveAll(HashMap<String, String> hashMap) {
        accountsRepository.insertAll(
                hashMap.get("username"),
                hashMap.get("password"),
                hashMap.get("firstName"),
                hashMap.get("lastName"),
                hashMap.get("thirdName"),
                hashMap.get("position"),
                hashMap.get("departmentName"),
                hashMap.get("gender"),
                Integer.parseInt(hashMap.get("workPhone"))
        );
    }
}
