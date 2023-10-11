package com.dell.dtc.edge.guard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alert")
public class WelcomeController {

    @GetMapping
    public String welcomeAlert() {
        return "get alert is working";
    }
}
