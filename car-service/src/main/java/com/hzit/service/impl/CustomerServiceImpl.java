package com.hzit.service.impl;

import com.common.Assist;
import com.hzit.mapper.CustomerMapper;
import com.hzit.pojo.Customer;
import com.hzit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findCustomerList(int companyId) {

        Assist assist = new Assist();

        Assist.WhereRequire we = Assist.andEq("companyId",companyId);
        assist.setRequires(we);


        List<Customer> list = customerMapper.selectCustomer(assist);
        return list;
    }
}
