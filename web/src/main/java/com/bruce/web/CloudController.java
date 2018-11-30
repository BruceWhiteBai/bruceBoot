package com.bruce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloud")
public class CloudController {


   /* @Autowired
    private DiscoveryClient client;

    @RequestMapping("/")
    public String init(){
        String services  = client.getServices().toString();
        return services;
    }*/



}
