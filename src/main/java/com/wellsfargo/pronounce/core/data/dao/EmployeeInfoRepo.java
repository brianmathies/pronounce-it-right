package com.wellsfargo.pronounce.core.data.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.pronounce.core.model.EmployeeInfo;

@Repository
public interface EmployeeInfoRepo extends JpaRepository<EmployeeInfo, Long> {

    @Override
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH)
    Optional<EmployeeInfo> findById(Long empId);

}