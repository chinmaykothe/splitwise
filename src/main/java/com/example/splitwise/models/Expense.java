package com.example.splitwise.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expense extends BaseModel{

    private String description;
    private Double amount;

    private Date createdOn;

    @ManyToOne
    private Group group;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "expense")
    @Where(clause = "type = 'PAID'")
    private List<UserExpense> paidBy = new ArrayList<>();

    @OneToMany(mappedBy = "expense")
    @Where(clause = "type = 'OWED'")
    private List<UserExpense> owedBy = new ArrayList<>();

    @Enumerated
    private ExpenseStatus status;
}

// Expense e1 - Paid
