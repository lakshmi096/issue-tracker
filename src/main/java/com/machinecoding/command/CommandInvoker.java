package com.machinecoding.command;

import com.machinecoding.service.ExampleService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
// Executes parsed commands
public class CommandInvoker {
    private final ExampleService exampleService;
    public void execute(String input) {
        String [] parts = input.trim().split(" ",2);
        String command = parts[0].toUpperCase();
        switch (command) {
            case "HELLO": {
                String[] args = parts[1].split(" ", 3);
                exampleService.printArgs(args);
                break;
            }
            default: {
                System.out.println("Invalid command: " + command);
            }
        }
    }
}