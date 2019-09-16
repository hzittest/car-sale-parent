package com.hzit.service;

import com.hzit.pojo.Customer;

import java.util.List;

/**
 * 客户管理
 */
public interface CustomerService {

    /**
     * 客户管理
     * @return
     */
    public List<Customer> findCustomerList(int companyId);

}
