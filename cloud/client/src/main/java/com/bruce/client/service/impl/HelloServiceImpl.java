package com.bruce.client.service.impl;

import com.bruce.client.service.IHelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
* @file HelloServiceImpl.java
* @CopyRight (C)
* @brief   hystrix
* @author bzj
* @email
* @date 2019/1/21
*/
@Service
public class HelloServiceImpl implements IHelloService {

    @Autowired
    RestTemplate restTemplate;

    //xxx  Hystrix 默认超时时间为 2000 毫秒 超时异常时触发调用回调方法
    @HystrixCommand(fallbackMethod = "helloFallBack",ignoreExceptions = HystrixBadRequestException.class,commandKey = "getOserByid", groupKey = "OserGroup", threadPoolKey
            = "getOserByidThread")
    @Override
    public String helloService() {
        return restTemplate.getForEntity("http://PROVIDER/index", String.class).getBody();
    }

    public String helloFallBack(){
        return  "error";
    }

    //  异常处理, 可以在service方法中根据调用结果抛出异常,然后在fallBack方法中捕获,返回具体的异常提示

    //observable
    @HystrixCommand(observableExecutionMode = ObservableExecutionMode.EAGER,fallbackMethod = "helloFallBack",ignoreExceptions = HystrixBadRequestException.class,commandKey = "getOserByid", groupKey = "OserGroup", threadPoolKey
            = "getOserByidThread")
    @Override
    public String helloService1() {
        return null;
    }

    //xxx 参考地址 http://www.cnblogs.com/happyflyingpig/p/8079308.html  线程池隔离 信号量
    //toObservable 订阅
    @HystrixCommand(observableExecutionMode = ObservableExecutionMode.LAZY,fallbackMethod = "helloFallBack",ignoreExceptions = HystrixBadRequestException.class,commandKey = "getOserByid", groupKey = "OserGroup", threadPoolKey
            = "getOserByidThread")
    @Override
    public String helloService2() {
        return null;
    }


}
