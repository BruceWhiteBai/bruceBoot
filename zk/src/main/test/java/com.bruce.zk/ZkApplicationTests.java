package com.bruce.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ZkApplicationTests {

    public static final String connectionInfo="127.0.0.1:2181";
    RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

    //todo 方式一:使用静态工程方法创建客户端
//    CuratorFramework client =
//            CuratorFrameworkFactory.newClient(
//                    connectionInfo,
//                    5000,
//                    3000,
//                    retryPolicy);

    //todo 方式二Fluent-流式风格的Api创建会话
//    CuratorFramework client =
//            CuratorFrameworkFactory.builder()
//                    .connectString(connectionInfo)
//                    .sessionTimeoutMs(5000)
//                    .connectionTimeoutMs(5000)
//                    .retryPolicy(retryPolicy)
//                    .build();



    //方式三: 创建包含隔离命名空间的会话
    CuratorFramework client =
            CuratorFrameworkFactory.builder()
                    .connectString(connectionInfo)
                    .sessionTimeoutMs(500000)
                    .connectionTimeoutMs(500000)
                    .retryPolicy(retryPolicy)
                    .namespace("curator_base")
                    .build();


    @Before
    public void init(){
        System.out.println("---------------测试开始----------------");
        client.start();

    }

    @After
    public void end(){
        client.close();
        System.out.println("---------------测试结束----------------");
    }

}
