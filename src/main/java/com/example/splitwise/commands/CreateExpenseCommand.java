package com.example.splitwise.commands;

import com.example.splitwise.controllers.ExpenseController;
import com.example.splitwise.dtos.ExpenseDto;
import com.example.splitwise.models.Expense;
import com.example.splitwise.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
@AllArgsConstructor
public class CreateExpenseCommand implements Command{

    private ExpenseController expenseController;
    @Override
    public boolean matches(String input) {
        String command = Command.getCommand(input);
        if(!command.equals(Commands.REGISTER_USER_COMMAND)) {
            return false;
        }
        return true;
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing create expense command");
        List<String> tokens = Command.getTokens(input);

        List<Long> userIds = Arrays.stream(tokens.get(3).split(","))
                .map(Long::valueOf)
                .toList();

        ExpenseDto expenseDto = ExpenseDto.builder()
                .description(tokens.get(1))
                .amount(Double.valueOf(tokens.get(2)))
                .userIds(userIds)
                .build();

        Expense expense = expenseController.createExpense(expenseDto);
    }
}
