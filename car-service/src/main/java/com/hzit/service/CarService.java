package com.hzit.service;

import com.hzit.pojo.Car;

import java.util.List;

/**
 * 汽车业务
 */
public interface CarService {


    /**
     * 查询所有汽车
     * @return
     */
    public List<Car> findCartList();


    public Car selectCarInfoByCarId(Integer carId);

}
