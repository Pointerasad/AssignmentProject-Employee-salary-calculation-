package com.assignment.poc.controller;

import java.util.List;

import com.assignment.poc.domain.Bank;
import com.assignment.poc.domain.Branch;
import com.assignment.poc.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BankController {

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    BankRepository bankRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/branch")
    public String branchForm(Model m){
        m.addAttribute("cmd", new Branch());
        return "/branch"; //html
    }

    @GetMapping("/save-branch")
    public String branchSave(@ModelAttribute Branch branch){
        branchRepository.save(branch);
        return "redirect:/branch"; //action
    }
    @ModelAttribute("branchList")
    public List<Branch> getEnquirySourceList(){
        return branchRepository.findAll();
    }

    @RequestMapping("/branch-edit/{id}")
    public String editBranch(@PathVariable Integer id , Model model) {
        Branch cmd = branchRepository.findById(id).get();
        model.addAttribute("cmd", cmd);
        return "/branch"; //sources.html
    }

    @RequestMapping("/branch-delete/{id}")
    public String deleteBranch(@PathVariable Integer id) {
        branchRepository.deleteById(id);
        return "redirect:/branch";
    }

    @ModelAttribute("bankDropDown")
    public List<Bank> getBankList(){
        return bankRepository.findAll();
    }

}
