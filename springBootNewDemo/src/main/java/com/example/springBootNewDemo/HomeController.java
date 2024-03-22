package com.example.springBootNewDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {


    @GetMapping("/home")
    public String sayHello(){


        return "Hello welcome to Homepage...";
    }
}
