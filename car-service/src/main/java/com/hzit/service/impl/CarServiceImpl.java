package com.hzit.service.impl;

import com.hzit.mapper.CarMapper;
import com.hzit.pojo.Car;
import com.hzit.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> findCartList() {
        List<Car> cars = carMapper.selectCar(null);
        return cars;
    }

    @Override
    public Car selectCarInfoByCarId(Integer carId) {
        Car car = carMapper.selectCarInfoByCarId(carId);
        return car;
    }
}
