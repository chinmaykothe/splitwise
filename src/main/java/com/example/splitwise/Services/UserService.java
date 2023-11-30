package com.example.splitwise.Services;

import com.example.splitwise.Repositories.UserRepository;
import com.example.splitwise.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private BCryptEncoder bCryptEncoder;
    public User createUser(User request) {
        // Hash the password
        String hashedPassword = bCryptEncoder.encode(request.getPassword());

        // Create a new user
        User user = request.toBuilder()
                .password(hashedPassword)
                .build();
        //Store it
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers(List<Long> memberIds) {
        return userRepository.findAllById(memberIds);
    }
}
