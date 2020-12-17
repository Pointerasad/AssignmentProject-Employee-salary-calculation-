package com.assignment.poc.repo;

import com.assignment.poc.domain.TransferSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 12/16/2020.
 */
@Repository
public interface TransferSalaryRepository extends JpaRepository<TransferSalary,Integer>{
}
