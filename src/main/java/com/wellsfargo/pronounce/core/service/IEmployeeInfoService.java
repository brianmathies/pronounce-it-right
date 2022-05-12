package com.wellsfargo.pronounce.core.service;

import java.util.List;

import com.wellsfargo.pronounce.core.model.EmployeeInfo;

public interface IEmployeeInfoService {

    EmployeeInfo getEmployeeInfo(Long empId);

    List<EmployeeInfo> searchEmployee(String name);

    void saveEmployeeInfo(EmployeeInfo employeeInfo);

}