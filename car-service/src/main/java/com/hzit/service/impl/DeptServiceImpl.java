package com.hzit.service.impl;

import com.hzit.mapper.DeptMapper;
import com.hzit.pojo.Dept;
import com.hzit.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Dept findDeptById(Integer deptno) {
        Dept dept = deptMapper.findDeptById(deptno);
        return dept;
    }
}
