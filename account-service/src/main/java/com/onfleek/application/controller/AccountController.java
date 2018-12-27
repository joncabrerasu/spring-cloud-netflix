package com.onfleek.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Value("${sample.msg}")
    private String msg;

    @GetMapping("/ping")
    public String ping() {
        return "Hey! I'm alive!" + msg;
    }
}
