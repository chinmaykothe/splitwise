package com.example.splitwise.dtos;

import com.example.splitwise.models.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    public User toUser() {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .build();
    }
}
