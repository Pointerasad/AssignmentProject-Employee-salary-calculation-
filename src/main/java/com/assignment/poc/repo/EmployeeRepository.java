package com.assignment.poc.repo;

import com.assignment.poc.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Asad on 12/14/2020.
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "select a.employee_id,a.employee_name,b.employee_grade,b.salary As basic_salary\n" +
            ",(b.salary * 0.20) as House_rent , (b.salary * 0.15) as Med_allowance,\n" +
            "(b.salary + (b.salary * 0.20) + (b.salary * 0.15)) as total_salary,a.account_id\n" +
            "from employee a, employee_grade_salary b\n" +
            "where a.grade=b.employee_grade",nativeQuery = true)
    List<Object[]> getInstList();

    @Query(value = "select a.account_no,a.pDate,a.avaliblabe_balance,c.current_balance,a.transfer_amt,a.client_account_no,a.account_name ,b.current_balance as current_bal\n" +
            "from transfer_salary a ,account b ,main_account c \n" +
            "where a.client_account_no=b.account_number\n" +
            "    and a.account_no=c.account_no",nativeQuery = true)
    List<Object[]> getTransactionHistoryList();

    @Query(value = "select c.current_balance,sum(a.transfer_amt)\n" +
            "   from transfer_salary a ,main_account c \n" +
            "   where a.account_no=c.account_no",nativeQuery = true)
    List<Object[]> getPaidAndRemainingList();

    @Query(value = "select a.employee_name,b.employee_grade ,(b.salary + (b.salary * 0.20) + (b.salary * 0.15)) as salary\n" +
            "from employee a inner join employee_grade_salary b\n" +
            "on a.grade=b.employee_grade",nativeQuery = true)
    List<Object[]> getSalarySheetList();

    @Query(value = "select lpad(max(employee_id)+1,4,0) from employee",nativeQuery = true)
    String getEmployeeNameId();

    @Query(value = "select lpad(max(account_number)+1,6,0) from account",nativeQuery = true)
    Integer getAccountNumber();

    @Query(value = "select account_number as id,account_number as Name from account \n" +
            "where account_number not in (select account_id from employee)",nativeQuery = true)
    List<Object[]> getList();
}
