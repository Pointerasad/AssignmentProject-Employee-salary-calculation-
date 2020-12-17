package com.assignment.poc.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Asad on 12/16/2020.
 */

@Entity
@Table(name = "transfer_salary")
public class TransferSalary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "account_no")
    private Integer accountNo;

    @Column(name = "currency")
    private String cCurrency;

    @Column(name = "avaliblabe_balance")
    private Double  avalBalance;

    @Column(name = "transfer_amt")
    private Double transferAmt;

    @Column(name = "pDate")
    private Date pDate;

    @Column(name = "client_account")
    private String clientAccount;

    @Column(name = "client_amt")
    private Double clientAmt;

    @Column(name = "client_currency")
    private String clientCurrency;

    @Column(name = "client_account_no")
    private Integer  clientAccountNo;

    @Column(name = "account_name")
    private String clientAccountName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public String getcCurrency() {
        return cCurrency;
    }

    public void setcCurrency(String cCurrency) {
        this.cCurrency = cCurrency;
    }

    public Double getAvalBalance() {
        return avalBalance;
    }

    public void setAvalBalance(Double avalBalance) {
        this.avalBalance = avalBalance;
    }

    public Double getTransferAmt() {
        return transferAmt;
    }

    public void setTransferAmt(Double transferAmt) {
        this.transferAmt = transferAmt;
    }

    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    public String getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(String clientAccount) {
        this.clientAccount = clientAccount;
    }

    public Double getClientAmt() {
        return clientAmt;
    }

    public void setClientAmt(Double clientAmt) {
        this.clientAmt = clientAmt;
    }

    public String getClientCurrency() {
        return clientCurrency;
    }

    public void setClientCurrency(String clientCurrency) {
        this.clientCurrency = clientCurrency;
    }

    public Integer getClientAccountNo() {
        return clientAccountNo;
    }

    public void setClientAccountNo(Integer clientAccountNo) {
        this.clientAccountNo = clientAccountNo;
    }

    public String getClientAccountName() {
        return clientAccountName;
    }

    public void setClientAccountName(String clientAccountName) {
        this.clientAccountName = clientAccountName;
    }
}
