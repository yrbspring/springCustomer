package com.kuebikoit.deviceengine.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Test {

    @Value("${test}")
    String prop;

    @PostConstruct
    public void init() {
        System.out.println("prop is " + prop);
    }

}
