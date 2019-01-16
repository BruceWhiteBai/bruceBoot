package com.bruce.client.service.impl;

import com.bruce.client.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements IHelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand
    @Override
    public String helloService() {
        return null;
    }
}
