package com.assignment.poc.dto;

import java.util.Date;

/**
 * Created by Asad on 12/14/2020.
 */
public class HistoryDto {

//    Integer getId();
//    String getEmployeeName();
//    Integer getEmpGrade();
//    String getEmpMobile();
//    Integer getAccountId();
//    String getEmpAddress();
//    String getEmployeeId();

    Integer accountNo;
    Date pDate;
    Double availableAmt;
    Double currentBalance;
    Double transferAmt;
    Integer clientAccountNo;
    String accountName;
    Double currentBal;


    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    public Double getAvailableAmt() {
        return availableAmt;
    }

    public void setAvailableAmt(Double availableAmt) {
        this.availableAmt = availableAmt;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Double getTransferAmt() {
        return transferAmt;
    }

    public void setTransferAmt(Double transferAmt) {
        this.transferAmt = transferAmt;
    }

    public Integer getClientAccountNo() {
        return clientAccountNo;
    }

    public void setClientAccountNo(Integer clientAccountNo) {
        this.clientAccountNo = clientAccountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getCurrentBal() {
        return currentBal;
    }

    public void setCurrentBal(Double currentBal) {
        this.currentBal = currentBal;
    }
}
