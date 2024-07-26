package com.ekimtsovss.transferMoney.controllers;

import com.ekimtsovss.transferMoney.entity.Account;
import com.ekimtsovss.transferMoney.entity.TransferRequest;
import com.ekimtsovss.transferMoney.sevicies.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ServiceImpl service;

    @PostMapping ("/transfer")
    public ResponseEntity<TransferRequest> getRequest(
            @RequestBody TransferRequest transferRequest){
        service.transferMoney(transferRequest);
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(transferRequest);
    }


}
