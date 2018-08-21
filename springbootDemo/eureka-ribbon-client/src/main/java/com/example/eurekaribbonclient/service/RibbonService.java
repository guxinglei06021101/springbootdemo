package com.example.eurekaribbonclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod="hiError")
    public String hi(){
        String str=restTemplate.getForObject("http://eureka-client/hi?name="+123,String.class);
        System.out.println(str);

        ServiceInstance choose = loadBalancerClient.choose("eureka-client");
        System.out.println("Instance:"+choose.toString());
        return str;
    }

    public String hiError(){
        System.out.println(123+",ERROR");
        return 123+",ERROR";
    }
}
