package com.example.solid_principle_example.web;

import com.example.solid_principle_example.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class CustomerController {

    private final TransactionService transactionService;

    // POST http://localhost:8080/api/accounts/SAV-101/withdraw?amount=100
    @PostMapping("/{id}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable String id, @RequestParam double amount) {
        try {
            transactionService.withdraw(id, amount);
            return ResponseEntity.ok("Withdrawal successful for account: " + id);
        } catch (UnsupportedOperationException e) {
            // This catches the LSP violation (e.g., withdrawing from Fixed Deposit)
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Transaction failed: " + e.getMessage());
        }
    }

    // POST http://localhost:8080/api/accounts/SAV-101/deposit?amount=500
    @PostMapping("/{id}/deposit")
    public ResponseEntity<String> deposit(@PathVariable String id, @RequestParam double amount) {
        transactionService.deposit(id, amount);
        return ResponseEntity.ok("Deposit successful for account: " + id);
    }
}