package com.bruce.logstash.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/log")
public class LogController {

    Logger logger = LoggerFactory.getLogger(LogController.class);

    /**
     * @param id
     * @return
     */
    @GetMapping("/head/{id}")
    public String getBookById(@PathVariable String id) {
        logger.info("测试初始一些日志吧！--info");
        logger.debug("测试初始一些日志吧！--debug");
        return "logstash test " + id;
    }


}
