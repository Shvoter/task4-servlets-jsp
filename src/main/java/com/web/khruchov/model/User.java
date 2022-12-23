package com.web.khruchov.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String login;
    private String name;
    private String surname;
    private String password;
}
