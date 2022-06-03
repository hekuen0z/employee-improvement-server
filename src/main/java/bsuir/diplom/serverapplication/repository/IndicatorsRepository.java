package bsuir.diplom.serverapplication.repository;

import bsuir.diplom.serverapplication.entities.IndicatorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;
import java.util.Set;

public interface IndicatorsRepository extends JpaRepository<IndicatorsEntity, Integer>, JpaSpecificationExecutor<IndicatorsEntity> {
    List<IndicatorsEntity> findAll();
    Set<IndicatorsEntity> findIndicatorsEntityById(Integer id);
}