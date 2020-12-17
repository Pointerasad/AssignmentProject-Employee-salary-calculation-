package com.assignment.poc.domain;

import javax.persistence.*;

/**
 * Created by Asad on 12/14/2020.
 */

@Entity
@Table(name = "employee_grade_salary")
public class EmployeeSalary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "employee_grade")
    private Integer empGradeSalary;

    @Column(name = "salary")
    private Double empSalary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpGradeSalary() {
        return empGradeSalary;
    }

    public void setEmpGradeSalary(Integer empGradeSalary) {
        this.empGradeSalary = empGradeSalary;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }
}
