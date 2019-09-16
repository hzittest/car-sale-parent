package com.hzit.service;

import com.hzit.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     *  根据公司ID,权限查询empname是否存在
     * @param empName
     * @param companyId
     * @param posiId
     * @return
     */
    public int isEmployeeExistByCompanyAndPosi(String empName,Integer companyId,Integer posiId);

    /**
     * 根据 员工名称判断 手机号码是否正确
     * @param empName
     * @param phone
     * @return
     */
    public int isPhoneExistByEmpName(String empName,String phone);


    /**
     *  根据用户名称  查询用户对象
     * @param empName
     * @return
     */
    public Employee findEmployeeByEmpname(String empName);


    List<Employee> findEmployeeByCompanyId(Integer companyId);
}
