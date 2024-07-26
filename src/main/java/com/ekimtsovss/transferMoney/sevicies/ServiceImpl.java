package com.ekimtsovss.transferMoney.sevicies;

import com.ekimtsovss.transferMoney.dao.Repository;
import com.ekimtsovss.transferMoney.entity.Account;
import com.ekimtsovss.transferMoney.entity.TransferRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Component
public class ServiceImpl implements Service{
    @Autowired
    private Repository repository;

    public ServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void transferMoney(TransferRequest transferRequest) {

        Optional<Account> optionalSender = repository.findById(Integer.parseInt(transferRequest.getSenderId()));
        Account accountSender = optionalSender.get();
        BigDecimal amountSender = accountSender.getAmount();

        Optional<Account> optionalReciever = repository.findById(Integer.parseInt(transferRequest.getRecieverId()));
        Account accountReciever = optionalReciever.get();
        BigDecimal amountReciever = accountReciever.getAmount();

        accountSender.setAmount(amountSender.subtract(transferRequest.getAmount()));
        accountReciever.setAmount(amountReciever.add(transferRequest.getAmount()));

        repository.save(accountSender);
        //throw new RuntimeException();
        repository.save(accountReciever);

    }
    public List<Account> getAllAccounts(){
        return  repository.findAll();
    }
}
