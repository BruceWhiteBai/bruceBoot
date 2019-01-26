package com.bruce.client.service.impl;

import com.bruce.client.service.IFeignHelloService;
import com.bruce.entity.dto.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class FeignHelloServiceFallBack implements FallbackFactory<IFeignHelloService> {

    @Override
    public IFeignHelloService create(Throwable throwable) {
        return  new IFeignHelloService() {
            @Override
            public String index() {
                return "index-error";
            }

            @Override
            public String feignl(@RequestParam("name") String name) {
                return "feignl-error";
            }

            @Override
            public User feign2(@RequestHeader("name") String name, @RequestHeader("userId") String userId) {
                User user = new User();
                user.setOther("feign2-未知");
                return user;
            }

            @Override
            public String feign3(@RequestBody User user) {
                return "feign3-error";
            }

            @Override
            public String feign4(@RequestParam("name") String name) {
                return "feign4-error";
            }

            @Override
            public User feign5(@RequestHeader("name") String name, @RequestHeader("userId") String userId) {
                User user = new User();
                user.setOther("feign5-未知");
                return user;
            }

            @Override
            public String feign6(@RequestBody User user) {
                return "feign6-error";
            }
        };
    }
}
