package com.hzit.service.impl;

import com.common.Assist;
import com.hzit.mapper.EmployeeMapper;
import com.hzit.pojo.Company;
import com.hzit.pojo.Employee;
import com.hzit.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int isEmployeeExistByCompanyAndPosi(String empName, Integer companyId, Integer posiId) {

        Employee employee = new Employee();

        Assist assist = new Assist();
       // List<Assist.WhereRequire<?>> requireList = assist.getRequire();


        Assist.WhereRequire<?> w1 = Assist.andEq("companyId",companyId);
        Assist.WhereRequire<?> w2 = Assist.andEq("positionId",posiId);
        Assist.WhereRequire<?> w3 = Assist.andEq("empName",empName);
       // requireList.add(w1);
        //requireList.add(w2);
       // requireList.add(w3);

        assist.setRequires(w1,w2,w3);


        int count = (int)employeeMapper.getEmployeeRowCount(assist);

        return count;
    }

    @Override
    public int isPhoneExistByEmpName(String empName, String phone) {

        Employee employee = new Employee();
        employee.setEmpName(empName);
        employee.setEmpPhone(phone);

        //存在
        Employee employee1 = employeeMapper.selectEmployeeByObj(employee);
        if(employee1!=null)
        {
            return 1;
        }

        return 0;
    }

    @Override
    public Employee findEmployeeByEmpname(String empName) {

        Employee employee = new Employee();
        employee.setEmpName(empName);

        //存在
        Employee employee1 = employeeMapper.selectEmployeeByObj(employee);

        return employee1;
    }

    @Override
    public List<Employee> findEmployeeByCompanyId(Integer companyId) {

      List<Employee> list  =   employeeMapper.selectEmployeeByCompanyId(companyId);

        return list;
    }
}
