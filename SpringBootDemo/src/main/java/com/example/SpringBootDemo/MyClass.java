package com.example.SpringBootDemo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {



    @GetMapping("/abc")
    public String sayHello(){


    return "Hello welcome to Homepage...";
    }

    @GetMapping(value = "/getNum/{num}")
    public int getNumber(@PathVariable("num") Integer num){
        return num + num;
    }
}
