package com.machinecoding.command;

import com.machinecoding.model.IssueType;
import com.machinecoding.model.Priority;
import com.machinecoding.model.Role;
import com.machinecoding.model.Status;
import com.machinecoding.service.IssueTrackerService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
// Executes parsed commands
public class CommandInvoker {
    private final IssueTrackerService issueTrackerService;
    public void execute(String input) {
        List<String> tokens = tokenize(input);
        if (tokens.isEmpty()) return;

        String command = tokens.get(0);
        List<String> argsLine = tokens.subList(1, tokens.size());
        System.out.println("command : " + command);

        switch (command) {
            case "ADD_USER" -> issueTrackerService.addUser(argsLine.get(0), argsLine.get(1), Role.valueOf(argsLine.get(2)));
            case "CREATE_ISSUE" -> issueTrackerService.createIssue(argsLine.get(0), argsLine.get(1), argsLine.get(2), IssueType.valueOf(argsLine.get(3)), Priority.valueOf(argsLine.get(4)), argsLine.get(5));
            case "ASSIGN_ISSUE" -> issueTrackerService.assignIssue(argsLine.get(0), argsLine.get(1), argsLine.get(2));
            case "ADD_COMMENT" -> issueTrackerService.commentOnIssue(argsLine.get(0), argsLine.get(1), argsLine.get(2));
            case "UPDATE_STATUS" -> issueTrackerService.transitionIssue(argsLine.get(0), argsLine.get(1), Status.valueOf(argsLine.get(2)));
            case "LIST_ALL_ISSUES" -> issueTrackerService.listAllIssues();
            case "LIST_ISSUES_BY_USER" -> issueTrackerService.listIssuesByAssignee(argsLine.get(0));
            default -> System.out.println("Invalid command");
        }
    }
    private static List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        Matcher m = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(input);
        while (m.find()) {
            if (m.group(1) != null)
                tokens.add(m.group(1));
            else
                tokens.add(m.group(2));
        }
        return tokens;
    }
}