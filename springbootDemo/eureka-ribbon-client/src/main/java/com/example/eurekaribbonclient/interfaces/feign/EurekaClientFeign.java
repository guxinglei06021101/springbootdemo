package com.example.eurekaribbonclient.interfaces.feign;

import com.example.eurekaribbonclient.interfaces.hystrix.HystrixFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",fallback = HystrixFeign.class)
@Component
public interface EurekaClientFeign {

    @RequestMapping("/hi")
    String sayHi(@RequestParam("name") String name);
}
