package com.machinecoding.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class User {
    private String id;
    private String name;
    private Role role;
}
