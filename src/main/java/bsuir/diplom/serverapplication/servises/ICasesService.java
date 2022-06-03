package bsuir.diplom.serverapplication.servises;

import bsuir.diplom.serverapplication.entities.CasesEntity;

import java.util.Set;

public interface ICasesService {
    Set<CasesEntity> findAll();
    CasesEntity findById(Integer id);
    Set<CasesEntity> findByExecutor(Integer id);
}
