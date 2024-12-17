package com.boot.service;



import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.ExpenseReport;
import com.boot.repository.ExpenseReportRepository;

@Service
public class ExpenseReportService 
{
	 @Autowired
	    private ExpenseReportRepository expenseReportRepository;

	    // Get all expenses
	    public List<ExpenseReport> getAllExpenses() {
	        return expenseReportRepository.findAll();
	    }

	    // Get expenses with filters
	    public List<ExpenseReport> getFilteredExpenses(Integer reportYear, String head, String school) {
	        if (reportYear != null && head != null && school != null) {
	            return expenseReportRepository.findByReportYearAndHeadAndSchool(reportYear, head, school);
	        } else if (reportYear != null && head != null) {
	            return expenseReportRepository.findByReportYearAndHead(reportYear, head);
	        } else if (reportYear != null && school != null) {
	            return expenseReportRepository.findByReportYearAndSchool(reportYear, school);
	        } else if (head != null && school != null) {
	            return expenseReportRepository.findByHeadAndSchool(head, school);
	        } else if (reportYear != null) {
	            return expenseReportRepository.findByReportYear(reportYear);
	        } else if (head != null) {
	            return expenseReportRepository.findByHead(head);
	        } else if (school != null) {
	            return expenseReportRepository.findBySchool(school);
	        } else {
	            return expenseReportRepository.findAll();
	        }
	    }

	    // Save a new expense entry
	    public ExpenseReport saveExpense(ExpenseReport expense) {
	        return expenseReportRepository.save(expense);
	    }
	    public double getTotalExpensesByYear(Integer reportYear) {
	        return expenseReportRepository.sumExpensesByYear(reportYear);
	    }

	    // Get all expenses for a given year
	    public List<ExpenseReport> getExpensesByYear(Integer reportYear) {
	        return expenseReportRepository.findByReportYear(reportYear);
	    }

	    // Get head-wise expenses for a given year
	    public List<Object[]> getHeadWiseExpensesByYear(Integer reportYear) {
	        return expenseReportRepository.findHeadWiseExpensesByYear(reportYear);
	    }

	    // Get school-wise expenses for a given year
	    public List<Object[]> getSchoolWiseExpensesByYear(Integer reportYear) {
	        return expenseReportRepository.findSchoolWiseExpensesByYear(reportYear);
	    }

	    // Get year-wise school expenses for the bar chart
	    public List<Object[]> getYearWiseSchoolExpenses() {
	        return expenseReportRepository.findYearWiseSchoolExpenses();
	    }
	    
	    public List<ExpenseReport> getAllExpensesByYear(Integer year) {
	        return expenseReportRepository.findByReportYear(year);
	    }
	    public List<ExpenseReport> getAllExpensesByHeadAndYear(String head, Integer reportYear) {
	        return expenseReportRepository.findAllExpensesByHeadAndYear(head, reportYear);
	    }
	    public List<ExpenseReport> getAllExpensesBySchoolAndYear(String school, Integer reportYear) {
	        return expenseReportRepository.findAllExpensesBySchoolAndYear(school, reportYear);
	    }
	    public Double getSumExpensesBySchoolAndYear(String school, Integer reportYear) {
	        return expenseReportRepository.sumExpensesBySchoolAndYear(school, reportYear);
	    }

	    // Method to get the total expenses by head and year
	    public Double getSumExpensesByHeadAndYear(String head, Integer reportYear) {
	        return expenseReportRepository.sumExpensesByHeadAndYear(head, reportYear);
	    }
	    public List<Object[]> getSumExpensesBySchoolYearwise() {
	        return expenseReportRepository.findYearWiseSchoolExpenses();
	    }
	    
	    // Group expenses by report year and calculate total amount
	    public Map<Integer, Double> getExpensesGroupedByYear() {
	        List<ExpenseReport> expenses = expenseReportRepository.findAll();
	        return expenses.stream()
	                .collect(Collectors.groupingBy(
	                        ExpenseReport::getreportYear,
	                        Collectors.summingDouble(ExpenseReport::getAmount)
	                ));
	    }

}
