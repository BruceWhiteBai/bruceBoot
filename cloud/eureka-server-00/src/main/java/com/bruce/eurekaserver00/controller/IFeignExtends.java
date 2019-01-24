package com.bruce.eurekaserver00.controller;

import com.bruce.entity.dto.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/feign")
public interface IFeignExtends {

    @RequestMapping(value = "/feign4", method = RequestMethod.GET)
    String feign4(@RequestParam("name") String name);

    @RequestMapping(value = "/feign5", method = RequestMethod.GET)
    User feign5(@RequestHeader("name") String name, @RequestHeader("userId") String userId);

    @RequestMapping(value = "/feign6", method = RequestMethod.POST)
    String feign6(@RequestBody User user);
}
