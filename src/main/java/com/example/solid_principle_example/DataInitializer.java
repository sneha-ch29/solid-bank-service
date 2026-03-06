package com.example.solid_principle_example;

import com.example.solid_principle_example.domain.FixedDepositAccount;
import com.example.solid_principle_example.domain.SavingsAccount;
import com.example.solid_principle_example.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDatabase(AccountRepository repository) {
        return args -> {
            repository.save(new SavingsAccount("SAV-101", 5000.0));
            repository.save(new FixedDepositAccount("FIX-202", 10000.0));
            System.out.println("--- Real-time Bank Data Initialized ---");
        };
    }
}
