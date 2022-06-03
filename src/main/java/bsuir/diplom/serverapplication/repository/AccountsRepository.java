package bsuir.diplom.serverapplication.repository;

import bsuir.diplom.serverapplication.entities.AccountsEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface AccountsRepository extends JpaRepository<AccountsEntity, Integer>, JpaSpecificationExecutor<AccountsEntity> {
    List<AccountsEntity> findAll();
    AccountsEntity findAccountsEntityByUsername(String username);
    AccountsEntity findAccountsEntityById(Integer id);
    Set<AccountsEntity> findAccountsEntitiesByLastName(String lastName);
    Set<AccountsEntity> findAccountsEntitiesByDepartmentName(String departmentName);
    Set<AccountsEntity> findAccountsEntitiesByIsChief(Boolean isChief);

    void saveByCriterion(String criterion, String newValue);
    void saveByCriteria(HashMap<String, String> newValue);

    void updateByCriterion(String criterion, String newValue);
    void updateByCriteria(HashMap<String, String> newValue);


    @Query("SELECT ae.username, ae.password FROM AccountsEntity ae")
    Set<String> getAuthData();

    @Modifying
    @Query(value = "insert into accounts (username, password, first_name, last_name, third_name, position, department_name, gender, work_phone)" +
            "values (:username, :password, :firstName, :lastName, :thirdName, :position, :departmentName, :gender, :workPhone)",
            nativeQuery = true)
    void insertAll(@Param("username") String username,
                      @Param("password") String password,
                      @Param("firstName") String firstName,
                      @Param("lastName") String lastName,
                      @Param("thirdName") String thirdName,
                      @Param("position") String position,
                      @Param("departmentName") String departmentName,
                      @Param("gender") String gender,
                      @Param("workPhone") Integer workPhone);

}