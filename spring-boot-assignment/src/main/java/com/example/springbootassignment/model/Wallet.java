package com.example.springbootassignment.model;

import javax.persistence.*;

@Entity
public class Wallet {
    public Wallet() {
    }

    @Id
    private Long id;

    private int balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Wallet(Long id,  int balance) {
        this.id = id;
        this.balance = balance;
    }


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
