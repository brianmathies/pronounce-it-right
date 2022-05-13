package com.wellsfargo.pronounce.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.pronounce.core.model.EmployeeInfoDto;
import com.wellsfargo.pronounce.core.service.IEmployeeInfoService;

@RestController
@RequestMapping("employee-info")
public class EmployeeInfoController {

    @Autowired
    private IEmployeeInfoService employeeInfoService;

    @GetMapping("/{empId}")
    public EmployeeInfoDto getEmployeeInfo(@PathVariable("empId") final Long empId) {
        return employeeInfoService.getEmployeeInfo(empId);

    }

    @GetMapping("/search-employees/{name}")
    public List<EmployeeInfoDto> searchEmployee(@PathVariable("name") final String name) {
        return employeeInfoService.searchEmployee(name);

    }

    @PutMapping
    public EmployeeInfoDto saveEmployee(@RequestBody final EmployeeInfoDto employeeInfo) {
        return employeeInfoService.saveEmployeeInfo(employeeInfo);

    }

}