package com.hzit.controller;

import com.hzit.pojo.Company;
import com.hzit.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController  {

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Company> companyList(){
        List<Company> companyList = companyService.findCompanyList();
        return companyList;
    }

}
