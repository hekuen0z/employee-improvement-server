package bsuir.diplom.serverapplication.servises.impl;

import bsuir.diplom.serverapplication.entities.VictimsEntity;
import bsuir.diplom.serverapplication.repository.VictimsRepository;
import bsuir.diplom.serverapplication.servises.IVictimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.Set;

@Service
@Repository
@Transactional
public class VictimsService implements IVictimsService {

    @Autowired
    private VictimsRepository victimsRepository;

    @Override
    public Set<VictimsEntity> findAll() {
        return null;
    }

    @Override
    public Set<VictimsEntity> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<VictimsEntity> findById(Integer id) {
        return null;
    }
}
