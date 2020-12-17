package com.assignment.poc.repo;

import com.assignment.poc.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Asad on 12/14/2020.
 */
public interface BankRepository extends JpaRepository<Bank,Integer> {

}
