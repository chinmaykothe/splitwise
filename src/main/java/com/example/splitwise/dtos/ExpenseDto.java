package com.example.splitwise.dtos;

import com.example.splitwise.models.ExpenseStatus;
import com.example.splitwise.models.Group;
import com.example.splitwise.models.User;
import com.example.splitwise.models.UserExpense;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class ExpenseDto {
    private String description;
    private Double amount;
    private List<Long> userIds = new ArrayList<>();
}
