package bsuir.diplom.serverapplication.servises.impl;

import bsuir.diplom.serverapplication.entities.CriminalsEntity;
import bsuir.diplom.serverapplication.repository.CriminalsRepository;
import bsuir.diplom.serverapplication.servises.ICriminalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Repository
@Transactional
public class CriminalsService implements ICriminalsService {

    @Autowired
    private CriminalsRepository criminalsRepository;

    @Override
    public Set<CriminalsEntity> findAll() {
        return null;
    }

    @Override
    public Set<CriminalsEntity> findById(Integer id) {
        return null;
    }

    @Override
    public Set<CriminalsEntity> findByLastName(String lastName) {
        return null;
    }
}
