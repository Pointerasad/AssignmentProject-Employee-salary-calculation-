package com.assignment.poc.dto;

/**
 * Created by Asad on 12/14/2020.
 */
public class EmployeeDto {

//    Integer getId();
//    String getEmployeeName();
//    Integer getEmpGrade();
//    String getEmpMobile();
//    Integer getAccountId();
//    String getEmpAddress();
//    String getEmployeeId();

    String empId;
    String empName;
    Integer empGrade;
    Double basicSalary;
    Double houseRent;
    Double medAllowance;
    Double totalSalary;
    Integer accountId;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpGrade() {
        return empGrade;
    }

    public void setEmpGrade(Integer empGrade) {
        this.empGrade = empGrade;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getHouseRent() {
        return houseRent;
    }

    public void setHouseRent(Double houseRent) {
        this.houseRent = houseRent;
    }

    public Double getMedAllowance() {
        return medAllowance;
    }

    public void setMedAllowance(Double medAllowance) {
        this.medAllowance = medAllowance;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
