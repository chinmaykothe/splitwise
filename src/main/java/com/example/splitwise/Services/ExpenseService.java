package com.example.splitwise.Services;

import com.example.splitwise.Repositories.ExpenseRepository;
import com.example.splitwise.dtos.ExpenseDto;
import com.example.splitwise.models.Expense;
import com.example.splitwise.models.ExpenseStatus;
import com.example.splitwise.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ExpenseService {

    private ExpenseRepository expenseRepository;
    private UserService userService;

    public Expense createExpense(ExpenseDto expenseDto) {

        List<User> users = userService.getUsers(expenseDto.getUserIds());
        Expense expense = Expense.builder()
                .description(expenseDto.getDescription())
                .amount(expenseDto.getAmount())
                .users(users)
                .status(ExpenseStatus.PENDING)
                .build();

        return expenseRepository.save(expense);
    }
}
