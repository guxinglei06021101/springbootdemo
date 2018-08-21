package com.example.eurekaribbonclient.controller;

import com.example.eurekaribbonclient.interfaces.feign.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeignController {

    @Autowired
     EurekaClientFeign eurekaClientFeign;


    @GetMapping("/sayhi")
    public String sayHi(){
        String str=eurekaClientFeign.sayHi("xiaoliu");
        System.out.println(str);
        return str;
    }


}
