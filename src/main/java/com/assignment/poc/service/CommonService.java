/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.poc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.assignment.poc.domain.*;
import com.assignment.poc.dto.ListDto;
import com.assignment.poc.repo.*;
import com.assignment.poc.dto.EmployeeDto;
import com.assignment.poc.dto.HistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class CommonService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MainAccountRepository mainAccountRepository;

    @Autowired
    EmployeeSalaryRepository employeeSalaryRepository;


    @Autowired
    TransferSalaryRepository transferSalaryRepository;




    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    public void saveMainAccount(MainAccount account) {
        mainAccountRepository.save(account);
    }


    public void saveGradeSalary(EmployeeSalary employeeSalary) {
        employeeSalaryRepository.save(employeeSalary);
    }

    public void transFerSalary(TransferSalary transferSalary) {

        MainAccount mainAccount = mainAccountRepository.findByAccountNo(transferSalary.getAccountNo());
        mainAccount.setCurrentBalance(mainAccount.getCurrentBalance()-transferSalary.getTransferAmt());

        Account account = accountRepository.findByAccountNumber(transferSalary.getClientAccountNo());
        Double getVal= account.getCurrentBalance()==null?0d:account.getCurrentBalance();
        account.setCurrentBalance(transferSalary.getTransferAmt()+getVal );

        transferSalary.setpDate(new Date());
        transferSalaryRepository.save(transferSalary);
        accountRepository.save(account);
        mainAccountRepository.save(mainAccount);
    }
//   public void getInstList(){
//        return employeeRepository.getInstList();
//    }
//


    public String getEmployeeNameId() {

       return employeeRepository.getEmployeeNameId();
    }

    public Integer getAccountNumber() {

        return employeeRepository.getAccountNumber();
    }

    public List<EmployeeDto> getInstList() {

        List<EmployeeDto> salaryList = new ArrayList<>();

        for (Object obj[] : employeeRepository.getInstList()) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setEmpId((String) obj[0]);
            employeeDto.setEmpName((String) obj[1]);
            employeeDto.setEmpGrade(((Integer) obj[2]));
            employeeDto.setBasicSalary((Double) obj[3]);
            employeeDto.setHouseRent((Double) obj[4]);
            employeeDto.setMedAllowance((Double) obj[5]);
            employeeDto.setTotalSalary((Double) obj[6]);
            employeeDto.setAccountId((Integer) obj[7]);
            salaryList.add(employeeDto);
        }
        return salaryList;
    }
    public List<HistoryDto> getTransactionHistoryList() {

        List<HistoryDto> salaryList = new ArrayList<>();

        for (Object obj[] : employeeRepository.getTransactionHistoryList()) {
            HistoryDto historyDto = new HistoryDto();
            historyDto.setAccountNo ((Integer) obj[0]);
            historyDto.setpDate((Date) obj[1]);
            historyDto.setAvailableAmt(((Double) obj[2]));
            historyDto.setCurrentBalance((Double) obj[3]);
            historyDto.setTransferAmt((Double) obj[4]);
            historyDto.setClientAccountNo((Integer) obj[5]);
            historyDto.setAccountName((String) obj[6]);
            historyDto.setCurrentBal((Double) obj[7]);
            salaryList.add(historyDto);
        }
        return salaryList;
    }

    public List<HistoryDto> getPaidAndRemainingList() {

        List<HistoryDto> salaryList = new ArrayList<>();

        for (Object obj[] : employeeRepository.getPaidAndRemainingList()) {
            HistoryDto historyDto = new HistoryDto();

            historyDto.setCurrentBalance((Double) obj[0]);
            historyDto.setTransferAmt((Double) obj[1]);

            salaryList.add(historyDto);
        }
        return salaryList;
    }

    public List<EmployeeDto> getSalarySheetList() {

        List<EmployeeDto> sheet = new ArrayList<>();

        for (Object obj[] : employeeRepository.getSalarySheetList()) {
            EmployeeDto salarySheet = new EmployeeDto();
            salarySheet.setEmpName((String) obj[0]);
            salarySheet.setEmpGrade((Integer) obj[1]);
            salarySheet.setTotalSalary(((Double) obj[2]));
            sheet.add(salarySheet);
        }
        return sheet;
    }

    public List<ListDto> getList() {
        List<ListDto> sheet = new ArrayList<>();
        for (Object obj[] : employeeRepository.getList()) {
            ListDto listDto = new ListDto();
            listDto.setAccId((Integer) obj[0]);
            listDto.setAccName((Integer) obj[1]);
            sheet.add(listDto);
        }
        return sheet;
    }

    public HistoryDto findByAccountNo() {
        HistoryDto historyDto = new HistoryDto();
            MainAccount list  = mainAccountRepository.getAccountNo();
            historyDto.setAccountName(list.getAccountName());
            historyDto.setAvailableAmt(list.getCurrentBalance());
        return historyDto;
    }

}
