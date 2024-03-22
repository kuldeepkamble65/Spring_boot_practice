package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class StudetController {

    private static final Logger LOGGER= Logger.getLogger(String.valueOf(StudetController.class));
    @RequestMapping("/")
    public String display()
    {
        LOGGER.info("logging service started");
        LOGGER.warning("please check carefully");
        return "index";
    }
}
