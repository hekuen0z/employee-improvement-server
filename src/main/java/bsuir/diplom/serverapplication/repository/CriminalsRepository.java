package bsuir.diplom.serverapplication.repository;

import bsuir.diplom.serverapplication.entities.CriminalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;
import java.util.Set;

public interface CriminalsRepository extends JpaRepository<CriminalsEntity, Long>, JpaSpecificationExecutor<CriminalsEntity> {
    List<CriminalsEntity> findAll();

}