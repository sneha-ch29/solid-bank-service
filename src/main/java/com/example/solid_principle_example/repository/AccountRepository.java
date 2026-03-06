package com.example.solid_principle_example.repository;

import com.example.solid_principle_example.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
