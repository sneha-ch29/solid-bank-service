package com.example.solid_principle_example.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FIXED")
public class FixedDepositAccount extends Account {

    // Default constructor for Hibernate
    public FixedDepositAccount() {}

    public FixedDepositAccount(String id, double balance) {
        super(id, balance);
    }

    @Override
    public boolean isWithdrawable() {
        return false;
    }
}