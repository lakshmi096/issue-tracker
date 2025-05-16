package com.machinecoding.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class Comment {
    private final String message;
    private final User author;
    @Builder.Default
    private final LocalDateTime timestamp = LocalDateTime.now();
}
