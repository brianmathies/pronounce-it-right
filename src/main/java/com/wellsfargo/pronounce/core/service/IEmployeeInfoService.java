package com.wellsfargo.pronounce.core.service;

import java.util.List;

import com.wellsfargo.pronounce.core.model.EmployeeInfoDto;

public interface IEmployeeInfoService {

    EmployeeInfoDto getEmployeeInfo(Long empId);

    List<EmployeeInfoDto> searchEmployee(String name);

    EmployeeInfoDto saveEmployeeInfo(EmployeeInfoDto employeeInfo);

}