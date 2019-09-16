package com.hzit.service;

import com.hzit.pojo.Sale;

import java.util.List;

public interface SaleService {


    public int insertSale(Sale sale);

    List<Sale> findSaleListByCompanyId(Integer companyId);

}
