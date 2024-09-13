package com.microcompany.accountsservice.controller;

import com.microcompany.accountsservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@Validated
public class CustomerController {

    @RequestMapping("")
    public String get() {
        return "customers";
    }
}
