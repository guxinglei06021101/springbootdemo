package com.example.eurekaribbonclient.controller;

import com.example.eurekaribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @RequestMapping("/hi")
    public String hi(){
        return ribbonService.hi();
    }
}
