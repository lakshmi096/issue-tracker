package com.machinecoding.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@ToString
@Builder
public class Issue {
    private String id;
    private String title;
    private String description;
    private IssueType type;
    private Priority priority;
    private User reporter;
    @Setter
    private User assignee;
    @Setter
    private Status status;
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();
}
