package com.bruce.kfkmq;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class KfkmqApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Test
    public void test01(){
        kafkaTemplate.send("foo",0,"kkk","k-v");
    }


    @Test
    public void test02(){
        kafkaTemplate.send("topic1",3,"kkk123","k-v123123");
        kafkaTemplate.send("topic1","kkk456","k-v1456456");
        kafkaTemplate.send("test","kkk--456","k-v--456456");

    }


    @Test
    public void test03(){
        for (int i = 0; i < 50; i++) {
            kafkaTemplate.send("foo",0,"foo-p0-k-"+i,"k-v-"+i);
        }

        for (int i = 0; i < 100; i++) {
            kafkaTemplate.send("foo",1,"foo-p1-k-"+i,"k-v-"+i);
        }


    }


    /**
     *
     */
    @Test
    public void test04(){
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("topic", "test");
        jsonObj.put("ts", System.currentTimeMillis() + "");

        log.info("json+++++++++++++++++++++  message = {}", jsonObj.toJSONString());

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("test", jsonObj.toJSONString());
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("msg OK. " + result.toString());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("msg send failed.", ex);
            }
        });
    }
}
