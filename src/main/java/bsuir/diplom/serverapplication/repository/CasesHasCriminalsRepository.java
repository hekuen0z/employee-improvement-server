package bsuir.diplom.serverapplication.repository;

import bsuir.diplom.serverapplication.entities.CasesHasCriminalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CasesHasCriminalsRepository extends JpaRepository<CasesHasCriminalsEntity, Integer>, JpaSpecificationExecutor<CasesHasCriminalsEntity> {

}