package com.hzit.controller;

import com.hzit.pojo.Customer;
import com.hzit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Customer> customerList(){
        List<Customer> customerList = customerService.findCustomerList();
        return customerList;
    }


}
