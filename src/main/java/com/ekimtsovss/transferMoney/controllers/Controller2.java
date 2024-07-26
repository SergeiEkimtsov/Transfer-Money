package com.ekimtsovss.transferMoney.controllers;

import com.ekimtsovss.transferMoney.entity.Account;
import com.ekimtsovss.transferMoney.sevicies.ServiceImpl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;


@RestController
public class Controller2{
    private static final Logger logger = LoggerFactory.getLogger(Controller2.class);
    @Autowired
    private ServiceImpl service;
    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        logger.info("Method getAllAccounts");
        var list = service.getAllAccounts();
        var newList = list.stream().sorted(Comparator.comparing(Account::getAmount).reversed()).toList();
        return newList;

    }

}
