package com.boot.entity;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExpenseReport {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id;
	private Integer reportYear;
	private String head;
	private String school;
	private String expenseDesc;
	private Double amount;
	private Date date;
	
	public ExpenseReport(long id, Integer reportYear, String head, String school, String expenseDesc, Double amount,Date date) {
		super();
		this.id = id;
		this.reportYear = reportYear;
		this.head = head;
		this.school = school;
		this.expenseDesc = expenseDesc;
		this.amount = amount;
		this.date = date;
	}
	
	public ExpenseReport() {
		super();
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getreportYear() {
		return reportYear;
	}
	public void setreportYear(Integer reportYear) {
		this.reportYear = reportYear;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getExpenseDesc() {
		return expenseDesc;
	}
	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
