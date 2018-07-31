package com.bruce.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/init")
public class InitController {

    @RequestMapping("/")
    public String init(){
        return "application init ";
    }
}
