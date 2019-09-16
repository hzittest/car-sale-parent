package com.hzit.controller;

import com.hzit.pojo.Customer;
import com.hzit.pojo.Employee;
import com.hzit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Customer> customerList(HttpSession httpSession){

        //获取登录公司的id
        Object emp = httpSession.getAttribute("emp");
        if(emp==null)
        {
            return null;
        }

        Employee employee = (Employee) emp;

        List<Customer> customerList = customerService.findCustomerList(employee.getCompanyId());
        return customerList;
    }


}
