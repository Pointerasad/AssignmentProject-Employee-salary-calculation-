package com.assignment.poc.controller;

import com.assignment.poc.domain.Employee;
import com.assignment.poc.repo.AccountRepository;
import com.assignment.poc.service.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {


    @Autowired
    CommonService commonService;

    @Autowired
    AccountRepository accountRepository;


    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("cmd", new Employee());
        return "/wellcome"; //index.html page
    }
    @GetMapping("/test-get-inst-ids")
    @ResponseBody
    public String getInstIds() {
        return accountRepository.findAllIds();
    }

}