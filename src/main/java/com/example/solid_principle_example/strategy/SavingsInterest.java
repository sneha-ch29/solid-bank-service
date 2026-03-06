package com.example.solid_principle_example.strategy;

import com.example.solid_principle_example.domain.Account;
import com.example.solid_principle_example.domain.SavingsAccount;
import org.springframework.stereotype.Component;

@Component
public class SavingsInterest implements InterestStrategy{
    @Override
    public boolean supports(Account account) {
        return account instanceof SavingsAccount;
    }

    @Override
    public double calculate(double balance) {
        return balance * 0.03;
    }
}
