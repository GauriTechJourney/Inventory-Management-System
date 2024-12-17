package com.boot.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.ExpenseReport;
import com.boot.service.ExpenseReportService;

@CrossOrigin
@RestController
@RequestMapping("/api/expenses")
public class ExpenseReportController {
    
    @Autowired
    private ExpenseReportService expenseReportService;

    // API to fetch all expenses
    @GetMapping("/all")
    public List<ExpenseReport> getAllExpenses() {
        return expenseReportService.getAllExpenses();
    }

    // API to fetch filtered expenses
    @GetMapping("/filter")
    public List<ExpenseReport> getFilteredExpenses(
            @RequestParam(required = false) Integer reportYear,
            @RequestParam(required = false) String head,
            @RequestParam(required = false) String school) {
        
        return expenseReportService.getFilteredExpenses(reportYear, head, school);
    }
 // Get head-wise expenses for a given year
    @GetMapping("/headwise")
    public List<Object[]> getHeadWiseExpensesByYear(@RequestParam Integer year) {
        return expenseReportService.getHeadWiseExpensesByYear(year);
    }

    // Get school-wise expenses for a given year
    @GetMapping("/schoolwise")
    public List<Object[]> getSchoolWiseExpensesByYear(@RequestParam Integer year) {
        return expenseReportService.getSchoolWiseExpensesByYear(year);
    }


    // API to add a new expense
    @PostMapping("/add")
    public ResponseEntity<ExpenseReport> addExpense(@RequestBody ExpenseReport expense) {
    	ExpenseReport newExpense = expenseReportService.saveExpense(expense);
        return new ResponseEntity<>(newExpense, HttpStatus.CREATED);
    }
 // Get all expenses for a given year (without aggregation)
    @GetMapping("/allByYear")
    public List<ExpenseReport> getAllExpensesByYear(@RequestParam Integer year) {
        return expenseReportService.getAllExpensesByYear(year);
    }

    @GetMapping("/expensesByHeadAndYear")
    public List<ExpenseReport> getExpensesByHeadAndYear(
            @RequestParam String head,
            @RequestParam Integer year) {
        return expenseReportService.getAllExpensesByHeadAndYear(head, year);
    }
    @GetMapping("/expensesBySchoolAndYear")
    public List<ExpenseReport> getExpensesBySchoolAndYear(
            @RequestParam String school,
            @RequestParam Integer year) {
        return expenseReportService.getAllExpensesBySchoolAndYear(school, year);
    }
    @GetMapping("/sumExpensesBySchoolAndYear")
    public Double getSumExpensesBySchoolAndYear(
            @RequestParam String school,
            @RequestParam Integer year) {
        return expenseReportService.getSumExpensesBySchoolAndYear(school, year);
    }

    // API to get the sum of expenses by head and year
    @GetMapping("/sumExpensesByHeadAndYear")
    public Double getSumExpensesByHeadAndYear(
            @RequestParam String head,
            @RequestParam Integer year) {
        return expenseReportService.getSumExpensesByHeadAndYear(head, year);
    }
 // Get sum of expenses year-wise school-wise
    @GetMapping("/sumExpensesBySchoolYearwise")
    public List<Object[]> getSumExpensesBySchoolYearwise() {
        return expenseReportService.getSumExpensesBySchoolYearwise();
    }
    
 // Endpoint to fetch all expense reports
    @GetMapping("/bar_chart")
    public Map<Integer, Double> getAllExpenses1() {
        return (Map<Integer, Double>) expenseReportService.getExpensesGroupedByYear();
    }

}
