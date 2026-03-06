package com.example.solid_principle_example.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("SAVINGS")
@NoArgsConstructor
public class SavingsAccount extends Account {
    public SavingsAccount(String id, double balance) {
        super(id, balance);
    }

    @Override
    public boolean isWithdrawable() {
        return true;
    }
}

