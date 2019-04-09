package com.bruce.redisson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(RedissonApplicationTests.class);

    @Autowired
    private RedissonClient redissonClient;


    @Test
    public void contextLoads() {
    }



    @Test
    public void testRedisson01() throws IOException {
        Config config = redissonClient.getConfig();
        logger.info(config.toJSON());

    }

}
