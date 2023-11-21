package com.kafkaStudy.ndj.domain.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

    @RequestMapping("/")
    public String demo()
    {
        return "/index";
    }

}
