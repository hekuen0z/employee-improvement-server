package bsuir.diplom.serverapplication.servises;

import bsuir.diplom.serverapplication.entities.CriminalsEntity;

import java.util.Set;

public interface ICriminalsService {
    Set<CriminalsEntity> findAll();
    Set<CriminalsEntity> findById(Integer id);
    Set<CriminalsEntity> findByLastName(String lastName);
}
