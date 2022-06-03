package bsuir.diplom.serverapplication.servises.impl;

import bsuir.diplom.serverapplication.entities.InformationEntity;
import bsuir.diplom.serverapplication.repository.InformationRepository;
import bsuir.diplom.serverapplication.servises.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.Set;

@Service
@Repository
@Transactional
public class InformationService implements IInformationService {

    @Autowired
    private InformationRepository informationRepository;

    @Override
    public Set<InformationEntity> findAll() {
        Set<InformationEntity> tempSet = new HashSet<>(informationRepository.findAll());
        return tempSet;
    }
}
