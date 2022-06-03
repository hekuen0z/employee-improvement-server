package bsuir.diplom.serverapplication.servises;

import bsuir.diplom.serverapplication.entities.VictimsEntity;

import java.util.Set;

public interface IVictimsService {
    Set<VictimsEntity> findAll();
    Set<VictimsEntity> findByLastName(String lastName);
    Set<VictimsEntity> findById(Integer id);
}
