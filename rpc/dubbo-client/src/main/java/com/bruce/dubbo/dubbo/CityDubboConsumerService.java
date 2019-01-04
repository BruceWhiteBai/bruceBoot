package com.bruce.dubbo.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bruce.dubbo.domain.City;
import org.springframework.stereotype.Component;


@Component
public class CityDubboConsumerService {

    @Reference(version = "1.0.2")
    CityDubboService cityDubboService;

    public City printCity() {
        String cityName="温岭";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
        return city;
    }
}
