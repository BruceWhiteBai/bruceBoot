package com.bruce.active;

import com.bruce.active.jms.Producer;
import com.bruce.active.jms.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Resource
    Producer producer;

    @Resource
    Publisher publisher;

    @Test
    public void test01(){
        for (int i = 0; i < 50; i++) {
            producer.sendMsg("test.queue","消息"+i);
        }
    }


    @Test
    public void test02(){
        for (int i = 0; i < 50; i++) {
            publisher.publish("test.topic","消息"+i);
        }
    }
}
