package com.bruce.dubbo.controller;


import com.bruce.dubbo.domain.City;
import com.bruce.dubbo.dubbo.CityDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DubboClientController {

    @Autowired
    private CityDubboConsumerService cityDubboConsumerService;


    @RequestMapping("/test")
    public City printMessage3() {
        return cityDubboConsumerService.printCity();
    }

}
