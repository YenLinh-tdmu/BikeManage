package com.example.BikeManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Trả về tên của file giao diện (home.html)
        return "home";
    }
}