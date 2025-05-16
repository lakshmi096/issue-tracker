package com.machinecoding.service;

import com.machinecoding.model.*;
import com.machinecoding.repository.IssueRepository;
import com.machinecoding.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IssueTrackerService {
    private UserRepository userRepository;
    private IssueRepository issueRepository;

    public void addUser(String id, String name, Role role) {
        if(userRepository.get(id) != null) {
            System.out.println("User already exists");
            return;
        }
        User user = User.builder().id(id).name(name).role(role).build();
        userRepository.add(id, user);
        System.out.println("User added: " + user);
    }

    public void createIssue(String id, String title, String desc, IssueType type, Priority priority, String reporterId) {
        if(userRepository.get(reporterId) == null) {
            System.out.println("User does not exists");
            return;
        }
        User reporter = userRepository.get(reporterId);
        Issue issue = Issue.builder()
                .id(id)
                .title(title)
                .description(desc)
                .type(type)
                .priority(priority)
                .reporter(reporter)
                .status(Status.OPEN)
                .build();
        issueRepository.add(id, issue);
        System.out.println("Issue created: " + issue);
    }

    public void assignIssue(String issueId, String managerId, String assigneeId) {
        User manager = userRepository.get(managerId);
        if (manager == null || manager.getRole() != Role.MANAGER) {
            System.out.println("Only managers can assign issues.");
            return;
        }

        Issue issue = issueRepository.get(issueId);
        User assignee = userRepository.get(assigneeId);
        if (issue == null || assignee == null) {
            System.out.println("Issue or assignee not found.");
            return;
        }

        issue.setAssignee(assignee);
        System.out.println("Issue assigned to: " + assignee.getName());
    }

    public void transitionIssue(String issueId, String userId, Status status) {
        Issue issue = issueRepository.get(issueId);
        User user = userRepository.get(userId);

        if (issue == null || user == null || issue.getAssignee() == null || !issue.getAssignee().getId().equals(userId)) {
            System.out.println("Only assignee can update issue status.");
            return;
        }
        issue.setStatus(status);
        System.out.println("Status updated to " + status);
    }

    public void listAllIssues() {
        for (Issue issue : issueRepository.getAll()) {
            System.out.println(issue);
        }
    }

    public void commentOnIssue(String issueId, String userId, String comment) {
        Issue issue = issueRepository.get(issueId);
        User user = userRepository.get(userId);

        if (issue == null || user == null) {
            System.out.println("Invalid issue or user.");
            return;
        }
        Comment newComment = Comment.builder().message(comment).author(user).build();

        issue.getComments().add(newComment);
        System.out.println("Comment added: " + newComment);
    }

    public void listIssuesByAssignee(String userId) {
        for (Issue issue : issueRepository.getAll()) {
            if (issue.getAssignee() != null && issue.getAssignee().getId().equals(userId)) {
                System.out.println(issue);
            }
        }
    }


}