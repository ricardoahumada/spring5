package com.microcompany.accountsservice.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@Validated
public class AccountController {

    @RequestMapping("")
    public String get() {
        return "accounts";
    }
}
