package com.onfleek.accountservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/ping")
    public String ping() {
        return "Hey! I'm alive!";
    }
}
