package com.hzit.controller;

import com.hzit.pojo.Dept;
import com.hzit.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dept")
public class DeptController {


    @Autowired
    private IDeptService deptService;


    @RequestMapping("/{deptno}")
    public String hello(@PathVariable("deptno") Integer deptno, Model model){
        Dept dept = deptService.findDeptById(deptno);
        model.addAttribute("dept",dept);

        return "main";
    }

    @RequestMapping("/json/{deptno}")
    @ResponseBody
    public Dept hello(@PathVariable("deptno") Integer deptno){
        Dept dept = deptService.findDeptById(deptno);
        return dept;
    }

}
