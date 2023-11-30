package com.example.splitwise.commands;

import com.example.splitwise.controllers.UserController;
import com.example.splitwise.dtos.UserDto;
import com.example.splitwise.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// Step 2: create concrete classes
@Component
@AllArgsConstructor
public class CreateUserCommand implements Command{

    private UserController userController;
    @Override
    public boolean matches(String input) {
        // register tantia
        String command = Command.getCommand(input);
        if(!command.equals(Commands.REGISTER_USER_COMMAND)) {
            return false;
        }
        return true;
    }

    @Override
    public void execute(String input) {
        // UserController
        // Arguments -> register name email password phoneNumber
        System.out.println("Executing create user command");
        List<String> tokens = Command.getTokens(input);

        // Create user dto
        UserDto createUserDto = UserDto.builder()
                .name(tokens.get(1))
                .email(tokens.get(2))
                .password(tokens.get(3))
                .phoneNumber(tokens.get(4))
                .build();

        User user = userController.createUser(createUserDto);
        System.out.println("Created user with id: " + user.getId());
    }
}
