package com.ekimtsovss.transferMoney.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {
    @Id
    ///@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int id;
    @Column(name = "iduser")
    private  int idUser;
    private BigDecimal amount;

    public Account() {
    }

    public Account(int idUser, BigDecimal amount) {

        this.idUser = idUser;
        this.amount = amount;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
