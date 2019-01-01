package com.bruce.flume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.nio.ch.Net;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/flume")
public class FlumeController {

    private final static Logger logger = LoggerFactory.getLogger(FlumeController.class);

    /**
     * TRACE < DEBUG < INFO < WARN < ERROR
     * 打印级别比当前高的,如info级别时，以下打印info和error2个级别,debug不会打印
     *
     */
    @RequestMapping("/")
    public void flumeLogger01() {
        try {
            MDC.put("ip", InetAddress.getLocalHost().getHostAddress().toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        MDC.put("user","flume");
        logger.info("logback-info 成功了");
        logger.error("logback-error 成功了");
        logger.debug("logback-debug 成功了");
        logger.trace("logback-trace 成功了"+System.currentTimeMillis());
    }
}
