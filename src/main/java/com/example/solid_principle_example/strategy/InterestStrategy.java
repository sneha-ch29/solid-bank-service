package com.example.solid_principle_example.strategy;

import com.example.solid_principle_example.domain.Account;

public interface InterestStrategy {
    boolean supports(Account account);
    double calculate(double balance);
}
