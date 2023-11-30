package com.example.splitwise.controllers;

import com.example.splitwise.Services.GroupService;
import com.example.splitwise.dtos.GroupDto;
import com.example.splitwise.models.Group;
import com.example.splitwise.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class GroupController {

    private GroupService groupService;

    public Group createGroup(GroupDto groupDto) {
        return groupService.createGroup(groupDto);
    }
}
