package com.example.splitwise.Services;

public interface PasswordEncoder {
    String encode(String password);
    boolean matches(String plaintext, String hashedPassword);
}
