package com.smartlogi.sdms.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {

    @RequestMapping("/")
    public String sayHay(){
        return "Hello World";
    }
}
