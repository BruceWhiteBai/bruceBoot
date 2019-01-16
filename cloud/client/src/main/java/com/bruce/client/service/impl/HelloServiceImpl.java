package com.bruce.client.service.impl;

import com.bruce.client.service.IHelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements IHelloService {

    @Autowired
    RestTemplate restTemplate;

    //xxx  Hystrix 默认超时时间为 2000 毫秒 超时异常时触发调用回调方法
    @HystrixCommand(fallbackMethod = "helloFallBack")
    @Override
    public String helloService() {
        return restTemplate.getForEntity("http://PROVIDER/index", String.class).getBody();
    }

    public String helloFallBack(){
        return  "error";
    }

}
