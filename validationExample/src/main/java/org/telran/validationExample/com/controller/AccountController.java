package org.telran.validationExample.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telran.validationExample.com.entity.Account;
import org.telran.validationExample.com.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("Accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    public List<Account> getAll() {
        return service.getAll();
    }
}
