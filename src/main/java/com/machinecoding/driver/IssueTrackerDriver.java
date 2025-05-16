package com.machinecoding.driver;

import com.machinecoding.command.CommandInvoker;
import com.machinecoding.repository.IssueRepository;
import com.machinecoding.repository.UserRepository;
import com.machinecoding.service.IssueTrackerService;

import java.util.Scanner;

public class IssueTrackerDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IssueRepository issueRepository = new IssueRepository();
        UserRepository userRepository = new UserRepository();
        IssueTrackerService issueTrackerService = new IssueTrackerService(userRepository, issueRepository);
        CommandInvoker invoker = new CommandInvoker(issueTrackerService);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            invoker.execute(input);
        }
    }
}
