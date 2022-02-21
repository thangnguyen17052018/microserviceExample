package com.tma.accountservice.controller;

import com.tma.accountservice.model.AccountDTO;
import com.tma.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/account")
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO){
        accountService.add(accountDTO);

        return accountDTO;
    }

    @GetMapping("/accounts")
    public List<AccountDTO> getAll(){
        return accountService.getALl();
    }

}
