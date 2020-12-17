package com.assignment.poc.domain;

import javax.persistence.*;

/**
 * Created by Asad on 12/14/2020.
 */


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "grade")
    private Integer empGrade;

    @Column(name = "address")
    private String empAddress;

    @Column(name = "mobile")
    private String empMobile;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "employee_id")
    private String employeeId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getEmpGrade() {
        return empGrade;
    }

    public void setEmpGrade(Integer empGrade) {
        this.empGrade = empGrade;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpMobile() {
        return empMobile;
    }

    public void setEmpMobile(String empMobile) {
        this.empMobile = empMobile;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
