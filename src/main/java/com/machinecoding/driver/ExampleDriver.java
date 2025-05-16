package com.machinecoding.driver;

import com.machinecoding.command.CommandInvoker;
import com.machinecoding.service.ExampleService;

public class ExampleDriver {
    public static void main(String[] args) {
        ExampleService exampleService = new ExampleService();
        CommandInvoker invoker = new CommandInvoker(exampleService);

        //Sample commands
        invoker.execute("HELLO Alice");

    }
}
