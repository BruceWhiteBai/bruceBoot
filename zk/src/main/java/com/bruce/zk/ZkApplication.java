package com.bruce.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class ZkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkApplication.class, args);
    }
}
