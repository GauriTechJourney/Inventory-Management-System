package com.boot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.entity.ExpenseReport;


@Repository
public interface ExpenseReportRepository extends JpaRepository<ExpenseReport, Long> {
	    
	    // Custom Query Methods for filtering data
	    //List<ExpenseReport> findByReportYear1(Integer reportYear);
	    List<ExpenseReport> findByHead(String head);
	    List<ExpenseReport> findBySchool(String school);
	    List<ExpenseReport> findByReportYearAndHead(int reportYear, String head);
	    List<ExpenseReport> findByReportYearAndSchool(int reportYear, String school);
	    List<ExpenseReport> findByHeadAndSchool(String head, String school);

	    List<ExpenseReport> findByReportYearAndHeadAndSchool(Integer reportYear, String head, String school);
	   
	    
	    @Query("SELECT SUM(e.amount) FROM ExpenseReport e WHERE e.reportYear = ?1")
	    double sumExpensesByYear(Integer year);

	    // Find expenses by year
	    List<ExpenseReport> findByReportYear(Integer reportYear);

	    // Find head-wise expenses by year
	    @Query("SELECT e.head, SUM(e.amount) FROM ExpenseReport e WHERE e.reportYear = ?1 GROUP BY e.head")
	    List<Object[]> findHeadWiseExpensesByYear(Integer reportYear);

	    // Find school-wise expenses by year
	    @Query("SELECT e.school, SUM(e.amount) FROM ExpenseReport e WHERE e.reportYear = ?1 GROUP BY e.school")
	    List<Object[]> findSchoolWiseExpensesByYear(Integer reportYear);

	    // Find year-wise school expenses for the bar chart
	    @Query("SELECT e.reportYear, e.school, SUM(e.amount) FROM ExpenseReport e GROUP BY e.reportYear, e.school")
	    List<Object[]> findYearWiseSchoolExpenses();
	    
	    @Query("SELECT e FROM ExpenseReport e WHERE e.head = ?1 AND e.reportYear = ?2")
	    List<ExpenseReport> findAllExpensesByHeadAndYear(String head, Integer reportYear);
	    
	    @Query("SELECT e FROM ExpenseReport e WHERE e.school = ?1 AND e.reportYear = ?2")
	    List<ExpenseReport> findAllExpensesBySchoolAndYear(String school, Integer reportYear);
	    @Query("SELECT SUM(e.amount) FROM ExpenseReport e WHERE e.school = ?1 AND e.reportYear = ?2")
	    Double sumExpensesBySchoolAndYear(String school, Integer reportYear);

	    // Method to calculate the sum of expenses for a given head and year
	    @Query("SELECT SUM(e.amount) FROM ExpenseReport e WHERE e.head = ?1 AND e.reportYear = ?2")
	    Double sumExpensesByHeadAndYear(String head, Integer reportYear);
	    
	    @Query("SELECT e.reportYear, e.school, SUM(e.amount) FROM ExpenseReport e GROUP BY e.reportYear, e.school")
	    List<Object[]> findYearWiseSchoolExpenses1();

	
	}
	    
		


	
	

