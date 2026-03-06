package com.example.solid_principle_example.service;

import com.example.solid_principle_example.domain.Account;
import com.example.solid_principle_example.strategy.InterestStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestService {
    private final List<InterestStrategy> strategies;

    public InterestService(List<InterestStrategy> strategies) {
        this.strategies = strategies;
    }

    public double getTotalInterest(Account account) {
        return strategies.stream()
                .filter(s -> s.supports(account))
                .mapToDouble(s -> s.calculate(account.getBalance()))
                .findFirst()
                .orElse(0.0);
    }
}
