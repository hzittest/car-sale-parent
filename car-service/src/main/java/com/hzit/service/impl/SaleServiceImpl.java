package com.hzit.service.impl;

import com.hzit.mapper.SaleMapper;
import com.hzit.pojo.Sale;
import com.hzit.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleMapper saleMapper;

    @Override
    public int insertSale(Sale sale) {

        // 补全数据:总金额
        sale.setSaleTotalPrice(sale.getSaleNum()*sale.getSaleCurPrice());

        return saleMapper.insertSale(sale);
    }

    @Override
    public List<Sale> findSaleListByCompanyId(Integer companyId) {
        return saleMapper.findSaleListByCompanyId(companyId);
    }
}
