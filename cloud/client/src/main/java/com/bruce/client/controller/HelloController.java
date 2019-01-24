package com.bruce.client.controller;


import com.bruce.client.service.IFeignHelloService;
import com.bruce.client.service.IHelloService;
import com.bruce.client.service.impl.HelloServiceImplExtend;
import com.bruce.entity.dto.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommand.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import rx.Observable;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@RestController
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    IHelloService helloService;

    @Autowired
    IFeignHelloService iFeignHelloService;

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

    /**
     * 使用 UriComponents
     * 使用 getObject
     * @return
     */
    @RequestMapping("/hello0")
    public String hello0() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://PROVIDER/index").build().encode();
        URI uri = uriComponents.toUri();
        return restTemplate.getForObject(uri, String.class);
    }

    @RequestMapping("/hello2")
    public User hello2() {
        return restTemplate.getForEntity("http://PROVIDER/index2", User.class).getBody();
    }

    @RequestMapping("/hello3")
    public User hello3() {
        User user = new User();
        user.setUserId("1");
        user.setMobileNum("15313723513");
        user.setUsername("bruce");
        user.setPassword("asdaf");
        user.setOther("qwer");
        user.setDeleteFlag(1);
        Map<String,String> param = new HashMap<>();
                param.put("username","12312312");
        param.put("userId","1");
//        return restTemplate.postForEntity("http://PROVIDER/index3", user,User.class).getBody();
//        return restTemplate.postForObject("http://PROVIDER/index3", param,User.class);
        return restTemplate.postForObject("http://PROVIDER/index3?other={other}", user,User.class,"test");
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

    @RequestMapping("/hello4")
    public String hello4() {
        return iFeignHelloService.index();
    }

    @RequestMapping("/hello5")
    public String hello5() {
        return iFeignHelloService.feignl("feign--hello5");
    }


    @RequestMapping("/hello6")
    public User hello6() {
        return iFeignHelloService.feign2("feign--hello6","9527");
    }


    @RequestMapping("/hello7")
    public String hello7() {
        User user = new User();
        user.setUserId("1");
        user.setUsername("bruce");
        return iFeignHelloService.feign3(user);
    }

    @RequestMapping("/hello8")
    public String hello8() {
        return iFeignHelloService.feign4("feign--hello5");
    }


    @RequestMapping("/hello9")
    public User hello9() {
        return iFeignHelloService.feign5("feign--hello6","9527");
    }


    @RequestMapping("/hello10")
    public String hello10() {
        User user = new User();
        user.setUserId("1");
        user.setUsername("bruce");
        return iFeignHelloService.feign6(user);
    }
}

