package bsuir.diplom.serverapplication.servises;

import bsuir.diplom.serverapplication.entities.IndicatorsEntity;

import java.util.Set;

public interface IIndicatorsService {
    Set<IndicatorsEntity> findAll();
    Set<IndicatorsEntity> findById(Integer id);
}
