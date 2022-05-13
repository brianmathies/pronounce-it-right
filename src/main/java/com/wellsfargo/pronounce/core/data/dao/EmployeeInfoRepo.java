package com.wellsfargo.pronounce.core.data.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.wellsfargo.pronounce.core.data.entity.EmployeeInfo;
import com.yugabyte.data.jdbc.repository.YsqlRepository;


@Repository
public interface EmployeeInfoRepo extends YsqlRepository<EmployeeInfo, Long> {
	
	Optional<EmployeeInfo> findById(final Long empId);
	
	List<EmployeeInfo> findByEmpNameContainingIgnoreCase(final String empName);

}