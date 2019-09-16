package com.hzit.service.impl;

import com.hzit.mapper.CompanyMapper;
import com.hzit.pojo.Company;
import com.hzit.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    public List<Company> findCompanyList(){
        List<Company> companyList = companyMapper.selectCompany(null);
        return companyList;
    }

}
