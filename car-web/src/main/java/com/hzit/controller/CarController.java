package com.hzit.controller;


import com.hzit.pojo.Car;
import com.hzit.pojo.Carseries;
import com.hzit.pojo.Customer;
import com.hzit.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Car> customerList() {
        List<Car> cartList = carService.findCartList();
        return cartList;
    }

    @RequestMapping("/{carId}")
    @ResponseBody
    public Car customerList(@PathVariable("carId") Integer carId) {
        Car car = carService.selectCarInfoByCarId(carId);
        return car;
    }


}
