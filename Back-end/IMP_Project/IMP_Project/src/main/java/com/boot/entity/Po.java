package com.boot.entity;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.cglib.core.Local;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity

public class Po {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serialNumber;

    @Column(name = "year")
    private int year;

    @Column(name = "head")
    private String head;

    
    @Column(name = "expenses_desc")
    private String expensesDesc;

    @Column(name = "amount")
    private double amount;
    
    @Column(name= "date")
    private Date date;
}
