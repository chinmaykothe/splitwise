package com.example.splitwise.dtos;

import com.example.splitwise.models.Group;
import com.example.splitwise.models.User;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class GroupDto {
    private String name;
    private Long createdBy;
    private List<Long> memberIds = new ArrayList<>();

//    public Group toGroup() {
//        return Group.builder()
//                .name(name)
//                .createdBy(createdBy)
//                .members(members)
//                .build();
//    }
}
