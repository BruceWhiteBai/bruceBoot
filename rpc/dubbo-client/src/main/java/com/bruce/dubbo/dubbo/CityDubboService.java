package com.bruce.dubbo.dubbo;

import com.bruce.dubbo.dto.City;

import java.util.concurrent.CompletableFuture;


public interface CityDubboService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);

    /**
     * 异步调用
     * @param name
     * @return
     */
    CompletableFuture<String> sayHello(String name);


    String sayHelloAsync(String name);
}
