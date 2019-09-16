package com.hzit.controller;

import com.hzit.pojo.Employee;
import com.hzit.service.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    private Logger logger = Logger.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/isEmpExist")
    @ResponseBody
    public int isEmpExist(String empName, Integer companyId, Integer posiId) {
        int count = employeeService.isEmployeeExistByCompanyAndPosi(empName, companyId, posiId);
        return count;
    }

    @RequestMapping("/isPhoneExist")
    @ResponseBody
    public int isPhoneExist(String empName, String phone) {
        int count = employeeService.isPhoneExistByEmpName(empName, phone);
        return count;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public int login(String empName, String pwd, HttpSession session) {

        Employee employee = employeeService.findEmployeeByEmpname(empName);
        if (employee == null) {
            logger.debug("登录用户名不存在！！！");
            return 0;
        }

        if (employee.getEmpPassword().equals(pwd)) {
            session.setAttribute("emp", employee);
            return 1; //成功
        } else {
            logger.debug("用户名密码不匹配！！！");
            return 0;
        }

    }


    @RequestMapping("/goMain")
    public String goMain(HttpSession session) {

        Object obj = session.getAttribute("emp");
        if (obj == null) //未登录
        {
            logger.debug("未登录，前先登录!");
            return "login";
        }

        //硬编码
        Employee employee = (Employee) obj;
        if (employee.getPositionId() == 1) { //经理
            logger.debug("经理登录成功!");
            return "AdminMain";
        } else if (employee.getPositionId() == 2) { //操作员
            logger.debug("操作员登录成功!");
            return "EmpMain";
        }
        return "EmpMain";
    }

}
