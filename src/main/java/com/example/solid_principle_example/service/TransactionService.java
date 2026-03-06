package com.example.solid_principle_example.service;

import com.example.solid_principle_example.domain.Account;
import com.example.solid_principle_example.notification.MessageProvider;
import com.example.solid_principle_example.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // SRP: Generates constructor for all 'final' fields (DIP)
public class TransactionService {

    private final AccountRepository repository; // Dependency on Abstraction
    private final MessageProvider messageProvider; // Dependency on Abstraction

    @Transactional // Ensures database integrity
    public void withdraw(String accountId, double amount) {
        // 1. Fetch from Repository
        Account account = repository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + accountId));

        // 2. LSP Check: The domain object itself decides if it's withdrawable
        if (!account.isWithdrawable()) {
            throw new UnsupportedOperationException("Withdrawals are restricted for this account type.");
        }

        // 3. Business Logic
        if (account.getBalance() < amount) {
            throw new IllegalStateException("Insufficient funds.");
        }

        account.updateBalance(-amount);

        // 4. Persistence
        repository.save(account);

        // 5. Notification (DIP in action)
        messageProvider.sendMessage(accountId, "Successfully withdrew: " + amount);
    }

    @Transactional
    public void deposit(String accountId, double amount) {
        Account account = repository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found."));

        account.updateBalance(amount);
        repository.save(account);
        messageProvider.sendMessage(accountId, "Deposited: " + amount);
    }
}
