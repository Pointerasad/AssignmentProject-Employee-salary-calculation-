package com.assignment.poc.repo;

import com.assignment.poc.domain.MainAccount;
import com.assignment.poc.dto.HistoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Asad on 12/14/2020.
 */

@Repository
public interface MainAccountRepository extends JpaRepository<MainAccount,Integer>{

   MainAccount findByAccountNo(Integer accountNo);

   @Query(value = "select id,account_name,current_balance from main_account",nativeQuery = true)
   MainAccount getAccountNo();

}
