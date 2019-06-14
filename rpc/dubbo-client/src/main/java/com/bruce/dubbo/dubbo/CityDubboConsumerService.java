package com.bruce.dubbo.dubbo;

import org.apache.dubbo.config.annotation.Reference;
import com.bruce.dubbo.dto.City;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@Component
public class CityDubboConsumerService implements Serializable {




    @Reference(version = "1.0.2", url = "dubbo://127.0.0.1:20880",check = false)
    CityDubboService cityDubboService;

    public City printCity() {
        String cityName = "xxx";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
        return city;
    }

    public String futureResult() throws ExecutionException, InterruptedException {
        final String[] result = new String[1];
        // 调用直接返回CompletableFuture
        CompletableFuture<String> future = cityDubboService.sayHello("async call request");
        // 增加回调
        Future<String> f =future.whenComplete((v, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println("Response: " + v);
            }
        });
        // 早于结果输出
        System.out.println("Executed before response return.");
        return  f.get();
    }

}
