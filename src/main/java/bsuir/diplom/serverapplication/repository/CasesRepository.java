package bsuir.diplom.serverapplication.repository;

import bsuir.diplom.serverapplication.entities.CasesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.HashMap;
import java.util.Set;

public interface CasesRepository extends JpaRepository<CasesEntity, Integer>, JpaSpecificationExecutor<CasesEntity> {
    CasesEntity findCasesEntityById(Integer id);
    Set<CasesEntity> findCasesEntitiesById(Integer id);
    Set<CasesEntity> findCasesEntitiesByTerm(String term);
    Set<CasesEntity> findCasesEntitiesByIsActive(boolean isActive);
    Set<CasesEntity> findCasesEntitiesByIsUrgent(boolean isUrgent);
    Set<CasesEntity> findCasesEntitiesByIsSuspended(boolean isSuspended);
    Set<CasesEntity> findCasesEntitiesByIsRejected(boolean isRejected);

    void saveAll(String name, String date, String term, String article,
                             boolean isActive, boolean isCompleted, boolean isRejected,
                             boolean isUrgent, int accountId);

    void updateAll(String name, String date, String term, String article,
                            boolean isActive, boolean isCompleted, boolean isRejected,
                            boolean isUrgent, int accountId);

    void saveByCriterion(String criterion, String newValue);
    void saveByCriteria(HashMap<String, String> newValue);

    void updateByCriterion(String criterion, String newValue);
    void updateByCriteria(HashMap<String, String> newValue);
}