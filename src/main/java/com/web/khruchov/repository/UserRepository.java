package com.web.khruchov.repository;

import com.web.khruchov.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final List<User> users;
    private static UserRepository userRepository;

    private UserRepository() {
        users = new ArrayList<>();
        users.add(new User("login1", "name1", "surname1", "password1"));
        users.add(new User("login2", "name2", "surname2", "password2"));
        users.add(new User("login3", "name3", "surname3", "password3"));
        users.add(new User("login4", "name4", "surname4", "password4"));
        users.add(new User("login5", "name5", "surname5", "password5"));
    }

    public static synchronized UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public User readByLogin(String login) {
        return users.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    public List<User> readAll() {
        return users;
    }
}
