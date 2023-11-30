package com.example.splitwise.commands;


import java.util.Arrays;
import java.util.List;

// Step 1: Create a parent command interface
public interface Command {

    boolean matches(String input); // splitwise register Tantia

    void execute(String input);

    static String getCommand(String input) {
        // check if the first token is the same as command name
        return getTokens(input).get(0);
    }
    static List<String> getTokens(String input) {
        return Arrays.stream(input.split(" ")).toList();
    }
}
