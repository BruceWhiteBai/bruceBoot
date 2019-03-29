package com.bruce.eurekaserver01.controller;


import com.bruce.entity.dto.User;
import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Random;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private EurekaDiscoveryClient eurekaDiscoveryClient;

    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;

    @RequestMapping("/index")
    public String index() throws InterruptedException {
        int sleepTime = new Random().nextInt(3000);
        //xxx  Hystrix 默认超时时间为 2000 毫秒
        logger.info("{} sleep {}",eurekaInstanceConfig.getInstanceId(),sleepTime);
        Thread.sleep(sleepTime);
        List<String> services = eurekaDiscoveryClient.getServices();
        return services.toString().concat(" server-info" + eurekaInstanceConfig.getInstanceId() + "---" + eurekaInstanceConfig.getHostName(false));
    }

    @RequestMapping("/index2")
    public User index2() {
        User user = new User();
        user.setUserId("1");
        user.setMobileNum("15313723513");
        user.setUsername("bruce");
        user.setPassword("asdaf");
        user.setOther("qwer");
        user.setDeleteFlag(1);
        return user;
    }

    /**
     * xxx ribbion 客户端使用 resttemplate 调用时要添加请求注解,否则对象为空
     * @param user
     * @param other
     * @return
     */
    @RequestMapping("/index3")
    public User index3(@RequestBody  User user,String other) {
        logger.info(user.getUserId());
        user.setOther(other);
        return user;
    }

    @GetMapping(path = "/current")
    public Principal getCurrentAccount(Principal principal) {
        return principal;
    }

    @RequestMapping(value= "/feignl", method= RequestMethod.GET)
    public String feignl(@RequestParam String name) {
        return "Hello " + name;
    }
    @RequestMapping(value= "/feign2", method= RequestMethod.GET)
    public User feign2(@RequestHeader String name, @RequestHeader String userId) {
        return new User(userId,name,"","",0,"");
    }
    @RequestMapping(value= "/feign3", method = RequestMethod.POST)
    public String feign3(@RequestBody User user) {
        return "Hello " + user.getUsername() + ", " + user.getUserId();
    }


    @RequestMapping(value= "/trace-1", method= RequestMethod.GET)
    public String trace1(String str, HttpServletRequest request) {
        logger.info("===call trace-1===");
        logger.info("traceId={},spanId={},",request.getHeader("X-B3-TraceId"),request.getHeader("X-B3-SpanId"));
        return "hello trace " + str;
    }
}
