package com.bruce.rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Autowired
	MsgProducer msgProducer;

	@Test
	public void testSendMsg(){
		for (int i = 0; i < 50 ; i++) {
			msgProducer.sendMsg("asdf"+i);
		}
	}

	@Test
	public void testSendAll(){
		for (int i = 0; i < 50 ; i++) {
			msgProducer.sendAll("asdf---"+i);
		}
	}

	@Test
	public void testSendTopicMsg(){
		for (int i = 0; i < 50 ; i++) {
			msgProducer.sendTopicMsg("asdf--asdf---"+i);
		}
	}
}
