package com.assignment.poc.controller;

import java.util.Date;
import java.util.List;

import com.assignment.poc.domain.*;
import com.assignment.poc.dto.HistoryDto;
import com.assignment.poc.dto.ListDto;
import com.assignment.poc.repo.*;
import com.assignment.poc.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @Autowired
    CommonService commonService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MainAccountRepository mainAccountRepository;

    @Autowired
    EmployeeSalaryRepository employeeSalaryRepository;

    @Autowired
    BranchRepository branchRepository;


    @Autowired
    BankRepository bankRepository;

    @GetMapping("/grade-salary")
    public String emplGradeSalary(Model m) {
        m.addAttribute("cmd", new EmployeeSalary());
        return "/grade-salary"; //html
    }

    @GetMapping("/save-grade-salary")
    public String saveGradeSalary(@ModelAttribute EmployeeSalary employeeSalary) {
        commonService.saveGradeSalary(employeeSalary);
        return "redirect:/grade-salary";
    }


    @GetMapping("/transfer-salary")
    public String salaryTransfer(Model m) {
        m.addAttribute("cmd", new TransferSalary());
        return "/transfer-salary"; //html
    }

    @GetMapping("/save-transfer-salary")
    public String transferSalary(@ModelAttribute TransferSalary transferSalary) {
        commonService.transFerSalary(transferSalary);
        return "redirect:/transfer-salary";
    }


    @ModelAttribute("gradeList")
    public List<EmployeeSalary> getGradeSalaryList(){
        return employeeSalaryRepository.findAll();
    }

    @GetMapping("/main-account-form")
    public String mainAccountForm(Model m) {
        m.addAttribute("cmd", new MainAccount());
        return "/main-account"; //html
    }
    @GetMapping("/save-main-account")
    public String saveMainAccount(@ModelAttribute MainAccount account) {
        commonService.saveMainAccount(account);
        return "redirect:/main-account-form";
    }
    @RequestMapping("/main-account-delete/{id}")
    public String mainAccountDelete(@PathVariable Integer id) {
        mainAccountRepository.deleteById(id);
        return "redirect:/main-account-form";
    }

    @ModelAttribute("mainList")
    public List<MainAccount> getMainAccountList(){
        return mainAccountRepository.findAll();
    }


    @GetMapping("/employee-form")
    public String employeeForm(Model m) {
        m.addAttribute("cmd", new Employee());
        return "/employee-form"; //html
    }

    @GetMapping("/save-employee")
    public String saveEmployee(@ModelAttribute Employee emp) {
        String empId = commonService.getEmployeeNameId();
        if(empId==null){
            empId="0001";
        }
        emp.setEmployeeId(empId);
        commonService.saveEmployee(emp);
        return "redirect:/employee-form";
    }

    @RequestMapping("/employee-delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
        return "redirect:/employee-form";
    }

    @RequestMapping("/grade-edit/{id}")
    public String editGradeEmployeeSalary(@PathVariable Integer id , Model model) {
        EmployeeSalary cmd = employeeSalaryRepository.findById(id).get();
        model.addAttribute("cmd", cmd);
        return "/grade-salary"; //sources.html
    }
    @RequestMapping("/grade-delete/{id}")
    public String deleteGradeSalary(@PathVariable Integer id , Model model) {
        employeeSalaryRepository.deleteById(id);
        return "redirect:/grade-salary"; //sources.html
    }

    @RequestMapping("/bank")
    public String getBank(Model model) {
        Bank cmd = new Bank();
        model.addAttribute("cmd", cmd);
        return "/bank"; //sources.html
    }

    @RequestMapping("/save-bank")
    public String saveBank(@ModelAttribute Bank bank) {
        bankRepository.save(bank);
        return "redirect:/bank";
    }
    @ModelAttribute("bankList")
    public List<Bank> getEnquirySourceList(){
        return bankRepository.findAll();
    }

    @RequestMapping("/bank-edit/{id}")
    public String editBank(@PathVariable Integer id , Model model) {
        Bank cmd = bankRepository.findById(id).get();
        model.addAttribute("cmd", cmd);
        return "/bank"; //sources.html
    }

    @RequestMapping("/bank-delete/{id}")
    public String deleteBank(@PathVariable Integer id) {
        bankRepository.deleteById(id);
        return "redirect:/bank";
    }


    @GetMapping("/account-form")
    public String accountForm(Model m) {
        m.addAttribute("cmd", new Account());
        return "/account-form"; //html
    }

    @GetMapping("/save-account")
    public String saveAccount(@ModelAttribute Account account) {
        Integer empId = commonService.getAccountNumber();
        if(empId==null || empId==0){
            empId=101010;
        }
        account.setAccountNumber(empId);
        commonService.saveAccount(account);
        return "redirect:/account-form";
    }
    @RequestMapping("/account-edit/{id}")
    public String editAccount(@PathVariable Integer id , Model model) {
        Account cmd = accountRepository.findById(id).get();
        model.addAttribute("cmd", cmd);
        return "/account-form"; //sources.html
    }
    @RequestMapping("/account-delete/{id}")
    public String deleteAccount(@PathVariable Integer id) {
        accountRepository.deleteById(id);
        return "redirect:/account-form";
    }

    @ModelAttribute("empList")
    public List<Employee> employeeList(){
        return employeeRepository.findAll();
    }

    @ModelAttribute("accList")
    public List<Account> accountList(){
        return accountRepository.findAll();
    }
    @ModelAttribute("dropDrownList")
    public List<ListDto> acccountListForEmp(){
        return commonService.getList();
    }


    @GetMapping("/calculate-salary-list")
    public String employeeList(Model m) {
        m.addAttribute("empList", commonService.getInstList());
        return "/calculate-salary"; //html
    }

    @GetMapping("/history-list")
    public String getTransactionHistoryList(Model m) {
        m.addAttribute("historyList", commonService.getTransactionHistoryList());
        return "/transaction-history"; //html
    }
    @GetMapping("/get-list")
    @ResponseBody
    public HistoryDto getCompanyAccountList() {
        return commonService.findByAccountNo();
    }

    @GetMapping("/paid-remaining-list")
    public String getPaidRemainingList(Model m) {
        m.addAttribute("paidList", commonService.getPaidAndRemainingList());
        return "/paid-remaining"; //html
    }

    @GetMapping("/salary-sheet")
    public String salarySheet(Model m) {
        m.addAttribute("salSheet", commonService.getSalarySheetList());
        return "/salary-sheet"; //html
    }

    @GetMapping("/account-list")
    public String accountList(Model m) {
        //m.addAttribute("instList", instituteRepository.findAll());
        m.addAttribute("accList",  accountRepository.getAccountList());
        return "/account-list"; //html
    }

    @ModelAttribute("branchDropDown")
    public List<Branch> getBranchList(){
        return branchRepository.findAll();
    }

}
