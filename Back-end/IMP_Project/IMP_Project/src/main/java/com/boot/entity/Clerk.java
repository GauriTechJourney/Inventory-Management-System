package com.boot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Clerk {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year")
    private int year;

    @Column(name = "head")
    private String head;

    @Column(name = "school")
    private String school;

    @Column(name = "expenses_desc")
    private String expensesDesc;

    @Column(name = "amount")
    private double amount;
}
