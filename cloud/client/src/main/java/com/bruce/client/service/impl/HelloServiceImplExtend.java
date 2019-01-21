package com.bruce.client.service.impl;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.web.client.RestTemplate;

public class HelloServiceImplExtend extends HystrixCommand<String> {

    RestTemplate restTemplate;

    @Override
    protected String run() throws Exception {
        return restTemplate.getForEntity("http://PROVIDER/index", String.class).getBody();
    }

    public HelloServiceImplExtend(RestTemplate restTemplate) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CommandGroupKey"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("CommandKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadPoolKey")));

        this.restTemplate = restTemplate;
    }



    @Override
    protected String getFallback() {
        //xxx 自定义失败回调处理
        return super.getFallback();
    }

    private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("CommandKey");

    //设置缓存
    @Override
    protected String getCacheKey() {
        return super.getCacheKey();
    }

    public static void flushCache(Long id) {
        //刷新缓存，根据id进行清理
        HystrixRequestCache.getInstance(GETTER_KEY,HystrixConcurrencyStrategyDefault.getInstance()).clear(String.valueOf(id));
    }


}
