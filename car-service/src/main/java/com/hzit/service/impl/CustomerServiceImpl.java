package com.hzit.service.impl;

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
    public List<Customer> findCustomerList() {
        List<Customer> list = customerMapper.selectCustomer(null);
        return list;
    }
}
