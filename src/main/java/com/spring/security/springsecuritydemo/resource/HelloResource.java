package com.spring.security.springsecuritydemo.resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(HelloResource.BASE_URL)
public class HelloResource {

    public static final String BASE_URL = "/rest";

    //just printing hello world
    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }
}
