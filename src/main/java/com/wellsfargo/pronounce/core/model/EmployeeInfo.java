package com.wellsfargo.pronounce.core.model;

public class EmployeeInfo {

    private Long empId;
    private String empName;
    private String title;
    private String email;
    private String legalName;
    private String namePhoneme;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getNamePhoneme() {
        return namePhoneme;
    }

    public void setNamePhoneme(String namePhoneme) {
        this.namePhoneme = namePhoneme;
    }

}