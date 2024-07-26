package com.ekimtsovss.transferMoney.dao;

import com.ekimtsovss.transferMoney.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Account, Integer> {
}
