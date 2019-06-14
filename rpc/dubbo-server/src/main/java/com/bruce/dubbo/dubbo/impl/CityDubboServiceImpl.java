package com.bruce.dubbo.dubbo.impl;


import com.bruce.dubbo.dto.City;
import com.bruce.dubbo.dubbo.CityDubboService;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.*;


// 注册为 Dubbo 服务
@Service(version = "1.0.2")
public class CityDubboServiceImpl implements CityDubboService  {


    @Override
    public City findCityByName(String cityName) {
        return new City(1L, 2L, "xxxx-name", "xxxx-desc");
    }

    @Override
    public CompletableFuture<String> sayHello(String name) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        RpcContext savedContext = RpcContext.getContext();

        // 建议为supplyAsync提供自定义线程池，避免使用JDK公用线程池
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(savedContext.getAttachment("consumer-key1"));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "async response from provider. - " + name;
        }, pool);
    }

    /**
     * 高版本
     *
     * @param name
     * @return
     */
    @Override
    public String sayHelloAsync(String name) {
        /*final AsyncContext asyncContext = RpcContext.startAsync();
        new Thread(() -> {
            // 如果要使用上下文，则必须要放在第一句执行
            asyncContext.signalContextSwitch();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 写回响应
            asyncContext.write("Hello " + name + ", response from provider.");
        }).start();*/
        return null;
    }
}
