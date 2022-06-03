package bsuir.diplom.serverapplication.servises.impl;

import bsuir.diplom.serverapplication.entities.IndicatorsEntity;
import bsuir.diplom.serverapplication.repository.IndicatorsRepository;
import bsuir.diplom.serverapplication.servises.IIndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.Set;

@Service
@Repository
@Transactional
public class IndicatorsService implements IIndicatorsService {

    @Autowired
    private IndicatorsRepository indicatorsRepository;

    @Override
    public Set<IndicatorsEntity> findAll() {
        return null;
    }

    @Override
    public Set<IndicatorsEntity> findById(Integer id) {
        return null;
    }
}
