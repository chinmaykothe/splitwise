package com.example.splitwise.commands;

import com.example.splitwise.Services.GroupService;
import com.example.splitwise.controllers.GroupController;
import com.example.splitwise.dtos.GroupDto;
import com.example.splitwise.dtos.UserDto;
import com.example.splitwise.models.Group;
import com.example.splitwise.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class CreateGroupCommand implements Command{

    private GroupController groupController;
    @Override
    public boolean matches(String input) {
        String command = Command.getCommand(input);
        if(!command.equals(Commands.CREATE_GROUP_COMMAND)) {
            return false;
        }
        return true;
    }

    @Override
    public void execute(String input) {
        // UserController
        // Arguments -> register name email password phoneNumber
        System.out.println("Executing create group command");
        List<String> tokens = Command.getTokens(input);
        List<Long> memberIds = Arrays.stream(tokens.get(3).split(","))
                .map(Long::valueOf)
                .toList();
        // Create group dto
        GroupDto createGroupDto = GroupDto.builder()
                .name(tokens.get(1))
                .createdBy(Long.valueOf(tokens.get(2)))
                .memberIds(memberIds)
                .build();

        Group group = groupController.createGroup(createGroupDto);
        System.out.println("Created group with id: " + group.getId());
    }
}
