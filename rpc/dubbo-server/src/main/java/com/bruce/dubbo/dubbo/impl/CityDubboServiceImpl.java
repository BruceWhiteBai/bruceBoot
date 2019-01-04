package com.bruce.dubbo.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bruce.dubbo.domain.City;
import com.bruce.dubbo.dubbo.CityDubboService;


// 注册为 Dubbo 服务
@Service(version = "1.0.2")
public class CityDubboServiceImpl implements CityDubboService {

    public City findCityByName(String cityName) {
        return new City(1L,2L,"温岭","是我的故乡");
    }
}
