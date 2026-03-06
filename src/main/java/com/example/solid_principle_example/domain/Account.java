package com.example.solid_principle_example.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
@NoArgsConstructor
public abstract class Account {
    @Id
    private String id;
    private double balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }

    // LSP: Subclasses must implement this
    public abstract boolean isWithdrawable();
}