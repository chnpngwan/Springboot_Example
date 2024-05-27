package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/")
    public String testThymeleaf(ModelMap modelMap){
        modelMap.addAttribute("msg", "Hello dalaoyang , this is thymeleaf");
        return "thymeleaf";
    }
}
