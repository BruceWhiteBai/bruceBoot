package com.bruce.client.service;

import com.bruce.entity.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient("provider")
public interface IFeignHelloService  extends IFeignExtends{

    @RequestMapping("/index")
    String index();


    @RequestMapping(value = "/feignl", method = RequestMethod.GET)
    String feignl(@RequestParam("name") String name);

    @RequestMapping(value = "/feign2", method = RequestMethod.GET)
    User feign2(@RequestHeader("name") String name, @RequestHeader("userId") String userId);

    @RequestMapping(value = "/feign3", method = RequestMethod.POST)
    String feign3(@RequestBody User user);
}