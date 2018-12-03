package com.bruce.rabbit.controller;


import com.bruce.rabbit.rmq.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rmq")
public class RabbitController {

    @Autowired
    MsgProducer msgProducer;

    @RequestMapping("/hello")
    public void rmqHello(){
        for (int i = 0; i < 50 ; i++) {
            msgProducer.sendMsg("asdf"+i);
        }
    }
}
