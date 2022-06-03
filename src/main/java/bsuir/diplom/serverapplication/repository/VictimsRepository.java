package bsuir.diplom.serverapplication.repository;

import bsuir.diplom.serverapplication.entities.VictimsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;
import java.util.Set;

public interface VictimsRepository extends JpaRepository<VictimsEntity, Integer>, JpaSpecificationExecutor<VictimsEntity> {
    List<VictimsEntity> findAll();
    Set<VictimsEntity> findVictimsEntitiesByLastName(String lastName);
    Set<VictimsEntity> findVictimsEntitiesById(Integer id);
}