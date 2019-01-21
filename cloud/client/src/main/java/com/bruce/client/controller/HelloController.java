package com.bruce.client.controller;


import com.bruce.client.service.IHelloService;
import com.bruce.client.service.impl.HelloServiceImplExtend;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommand.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.util.List;
import java.util.concurrent.Future;

@RestController
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    IHelloService helloService;

    @Autowired
    private EurekaDiscoveryClient eurekaDiscoveryClient;


    @RequestMapping("/hello")
    public String hello() {
//        return restTemplate.getForEntity("http://PROVIDER/index", String.class).getBody();
        return helloService.helloService();
    }
    @RequestMapping("/hello1")
    public String hello1() {
        return restTemplate.getForEntity("http://PROVIDER/index", String.class).getBody();
    }

    @RequestMapping("/index")
    public String index() {
        List<String> services = eurekaDiscoveryClient.getServices();
        return services.toString();
    }

    //todo get请求 post请求 put请求 delete请求


    @RequestMapping("/hytrix1")
    public String hytrix1() {
        List<String> services = eurekaDiscoveryClient.getServices();
        //Hot Obserable
        Observable<String> observable = new HelloServiceImplExtend(restTemplate).observe();
        // Cold Observable
        Observable<String> observable0 = new HelloServiceImplExtend(restTemplate).toObservable();
        //同步执行
        String observable1 = new HelloServiceImplExtend(restTemplate).execute();
        //异步执行  异步实现
        Future<String> observable2 = new HelloServiceImplExtend(restTemplate).queue();
        return services.toString();
    }
}
