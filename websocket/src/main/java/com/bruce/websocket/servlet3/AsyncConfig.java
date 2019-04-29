package com.bruce.websocket.servlet3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.Executor;

/**
 * Created by BruceWhite on 2018/11/17.
 */
@Configuration
@EnableAsync
public class AsyncConfig implements WebMvcConfigurer {

    @Value("${threadpool.corePoolSize}")
    private int corePoolSize  ;
    @Value("${threadpool.maxPoolSize}")
    private int maxPoolSize   ;
    @Value("${threadpool.queueCapacity}")
    private int queueCapacity ;

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }

    /**
    * @brief: 配置异步支持，设置了一个用来异步执行业务逻辑的工作线程池，设置了默认的超时时间是60秒
    * @params:
    * @return:
    * @author bzj
    * @date 2019/4/29
    */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(taskExecutor());
        configurer.setDefaultTimeout(60000L);
    }
}
