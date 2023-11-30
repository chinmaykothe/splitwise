package com.example.splitwise.controllers;

import com.example.splitwise.Services.ExpenseService;
import com.example.splitwise.dtos.ExpenseDto;
import com.example.splitwise.models.Expense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExpenseController {

    private ExpenseService expenseService;

    public Expense createExpense(ExpenseDto expenseDto) {
        return expenseService.createExpense(expenseDto);
    }
}
