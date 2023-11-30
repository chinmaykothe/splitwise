package com.example.splitwise.Services;

import com.example.splitwise.Repositories.GroupRepository;
import com.example.splitwise.dtos.GroupDto;
import com.example.splitwise.models.Group;
import com.example.splitwise.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.GroupPrincipal;
import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {

    private GroupRepository groupRepository;
    private UserService userService;

    public Group createGroup(GroupDto groupDto) {
        User createdBy = userService.getUser(groupDto.getCreatedBy());
        List<User> members = userService.getUsers(groupDto.getMemberIds());

        Group group = Group.builder()
                .name(groupDto.getName())
                .createdBy(createdBy)
                .members(members)
                .admin(List.of(createdBy))
                .build();

        return groupRepository.save(group);
    }

    public Group getGroup(Long id){
        return groupRepository.findById(id).orElse(null);
    }
}
