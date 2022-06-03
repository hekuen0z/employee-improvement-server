package bsuir.diplom.serverapplication.servises.impl;

import bsuir.diplom.serverapplication.entities.AccountsEntity;
import bsuir.diplom.serverapplication.entities.CasesEntity;
import bsuir.diplom.serverapplication.repository.CasesRepository;
import bsuir.diplom.serverapplication.servises.ICasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Repository
@Transactional
public class CasesService implements ICasesService {

    @Autowired
    private CasesRepository casesRepository;

    @Override
    public Set<CasesEntity> findAll() {
        Set<CasesEntity> tempSet = new HashSet<>(casesRepository.findAll());
        return tempSet;
    }

    @Override
    public CasesEntity findById(Integer id) {
        return Optional.ofNullable(casesRepository.findCasesEntityById(id))
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    @Override
    public Set<CasesEntity> findByExecutor(Integer id) {
//        return Optional.ofNullable(casesRepository.findCasesEntitiesByAccountId(id))
//                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
        return  null;
    }

}
