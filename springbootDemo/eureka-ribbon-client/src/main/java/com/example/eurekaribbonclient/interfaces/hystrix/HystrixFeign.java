package com.example.eurekaribbonclient.interfaces.hystrix;

import com.example.eurekaribbonclient.interfaces.feign.EurekaClientFeign;
import org.springframework.stereotype.Component;

@Component
public class HystrixFeign implements EurekaClientFeign {
    @Override
    public String sayHi(String name) {
        System.out.println("接口请求失败！");
        return name+",ERROR";
    }
}
