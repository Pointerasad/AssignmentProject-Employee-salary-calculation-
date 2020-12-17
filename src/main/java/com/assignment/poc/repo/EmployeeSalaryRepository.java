package com.assignment.poc.repo;

import com.assignment.poc.domain.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Asad on 12/14/2020.
 */

@Repository
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary,Integer> {

}
