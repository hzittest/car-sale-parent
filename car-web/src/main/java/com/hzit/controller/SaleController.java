package com.hzit.controller;

import com.hzit.pojo.Employee;
import com.hzit.pojo.Sale;
import com.hzit.service.SaleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/sale")
public class SaleController {

    private Logger logger = Logger.getLogger(SaleController.class);

    @Autowired
    private SaleService saleService;

    @RequestMapping("/insertSale")
    public  String  add(Sale sale){
        int row = saleService.insertSale(sale);
        logger.debug("添加销售记录:"+sale+" row:"+row);
        return "redirect:/sale/list";
    }


    @RequestMapping("/list")
    public  String  list(HttpSession httpSession){
        //获取登录公司的id
        Object emp = httpSession.getAttribute("emp");
        if(emp==null)
        {
            return null;
        }
        Employee employee = (Employee) emp;
        List<Sale> list = saleService.findSaleListByCompanyId(employee.getCompanyId());
        logger.debug("查询销售记录:"+list);

        httpSession.setAttribute("saleList",list);

        return "redirect:/jsp/AdminSaleList.jsp";
    }



}

