package bsuir.diplom.serverapplication.repository;

import bsuir.diplom.serverapplication.entities.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;
import java.util.Set;

public interface InformationRepository extends JpaRepository<InformationEntity, Integer>, JpaSpecificationExecutor<InformationEntity> {
    List<InformationEntity> findAll();
}