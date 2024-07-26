package com.ekimtsovss.transferMoney;

import com.ekimtsovss.transferMoney.dao.Repository;
import com.ekimtsovss.transferMoney.entity.Account;
import com.ekimtsovss.transferMoney.entity.TransferRequest;
import com.ekimtsovss.transferMoney.sevicies.ServiceImpl;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.annotation.Testable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestService {
    @Mock
    Repository repository;
    @Inject
    ServiceImpl service;
    @BeforeEach
    void init(){
        service = new ServiceImpl(repository);

    }

    @Test

    public void moneyTransferHappyFlow(){


        TransferRequest request = new TransferRequest();
        request.setSenderId("1");
        request.setRecieverId("2");
        request.setAmount(BigDecimal.valueOf(100));

        Account sender = new Account();
        sender.setIdUser(2);
        sender.setAmount(BigDecimal.valueOf(1000));

        Account destination = new Account();
        destination.setIdUser(2);
        destination.setAmount(BigDecimal.valueOf(1000));

        given(repository.findById(Integer.valueOf(request.getSenderId()))).willReturn(Optional.of(sender));
        given(repository.findById(destination.getIdUser())).willReturn(Optional.of(destination));

        service.transferMoney(request);

        verify(repository,times(1)).save(sender);
        verify(repository,times(1)).save(destination);

    }
}
