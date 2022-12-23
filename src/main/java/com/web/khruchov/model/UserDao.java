package com.web.khruchov.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserDao {
    private String login;
    private String name;
    private String surname;

    public UserDao(User user) {
        this.login = user.getLogin();
        this.name = user.getName();
        this.surname = user.getSurname();
    }
}
