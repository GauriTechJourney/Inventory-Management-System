package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.boot.entity.Clerk;
import com.boot.service.ClerkService;

import java.util.List;

@RestController
@RequestMapping("/api/clerk")
@CrossOrigin
public class ClerkController {

    @Autowired
    private ClerkService expenseService;

    // Endpoint to add an expense
    @PostMapping("/add")
    public ResponseEntity<Clerk> addExpense(@RequestBody Clerk expense) {
    	Clerk savedExpense = expenseService.saveExpense(expense);
        return ResponseEntity.ok(savedExpense);
    }

    // Endpoint to get all expenses
    @GetMapping("/all")
    public ResponseEntity<List<Clerk>> getAllExpenses() {
        List<Clerk> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }
}
