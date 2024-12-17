package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Clerk;
import com.boot.repository.ClerkRepository;

import java.util.List;

@Service
public class ClerkService {

    @Autowired
    private ClerkRepository expenseRepository;

    public Clerk saveExpense(Clerk expense) {
        return expenseRepository.save(expense);
    }

    public List<Clerk> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
