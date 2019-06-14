package com.bruce.dubbo.controller;


import com.bruce.dubbo.dto.City;
import com.bruce.dubbo.dubbo.CityDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;


@RestController
public class DubboClientController {

    @Autowired
    private CityDubboConsumerService cityDubboConsumerService;


    @RequestMapping("/test")
    public City printMessage3() {
        return cityDubboConsumerService.printCity();
    }

    @RequestMapping("/testAsync")
    public String testAsync() {
        String s = null;
        try {
          s  = cityDubboConsumerService.futureResult();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  s;
    }

}

/**
 https://blog.csdn.net/cainiao_user/article/details/76423495
 https://juejin.im/post/5c966b14f265da60e73a074d
 https://www.cnblogs.com/aalex/p/8480112.html

 **/
