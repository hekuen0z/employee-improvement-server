package bsuir.diplom.serverapplication.repository;

import bsuir.diplom.serverapplication.entities.CasesHasVictimsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CasesHasVictimsRepository extends JpaRepository<CasesHasVictimsEntity, Integer>, JpaSpecificationExecutor<CasesHasVictimsEntity> {

}