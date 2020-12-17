package com.assignment.poc.repo;

import com.assignment.poc.domain.Account;
import com.assignment.poc.dto.AccountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Asad on 12/14/2020.
 */
public interface AccountRepository extends JpaRepository<Account,Integer> {

    @Query("SELECT group_concat(e.id) FROM Account as e")
    public String findAllIds();

    @Query("select a.id as id ,a.accountType as accountType,a.accountName as accountName" +
            ",a.accountNumber as accountNumber,a.currentBalance as currentBalance from Account as a")
    List<AccountDto> getAccountList();

     Account findByAccountNumber(Integer accountNo);
}

