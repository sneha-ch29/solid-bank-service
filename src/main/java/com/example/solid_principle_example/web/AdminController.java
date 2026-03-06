package com.example.solid_principle_example.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> closeAccount(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }
}
