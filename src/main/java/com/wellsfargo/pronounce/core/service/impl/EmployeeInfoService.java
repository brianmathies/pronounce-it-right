package com.wellsfargo.pronounce.core.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wellsfargo.pronounce.core.model.EmployeeInfo;
import com.wellsfargo.pronounce.core.service.IEmployeeInfoService;

@Service
public class EmployeeInfoService implements IEmployeeInfoService {

    @Override
    public EmployeeInfo getEmployeeInfo(Long empId) {
        return getEmployees().stream().filter(emp -> emp.getEmpId().equals(empId)).findAny().get();

    }

    @Override
    public void saveEmployeeInfo(EmployeeInfo employeeInfo) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<EmployeeInfo> searchEmployee(String name) {
        return getEmployees().stream().filter(emp -> emp.getEmpName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

    }

    private List<EmployeeInfo> getEmployees() {
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmpId(1453L);
        employeeInfo.setEmail("john.doe@xyz.com");
        employeeInfo.setEmpName("John Doe");
        employeeInfo.setLegalName("Jonathan Doe");
        employeeInfo.setNamePhoneme("John Doe");
        employeeInfo.setTitle("Software Engineer");

        EmployeeInfo employeeInfo2 = new EmployeeInfo();
        employeeInfo2.setEmpId(1454L);
        employeeInfo2.setEmail("charles.green@xyz.com");
        employeeInfo2.setEmpName("Charles Green");
        employeeInfo2.setLegalName("Charles Green");
        employeeInfo2.setNamePhoneme("Charles Green");
        employeeInfo2.setTitle("Senior Software Engineer");

        return Arrays.asList(employeeInfo, employeeInfo2);
    }

}	