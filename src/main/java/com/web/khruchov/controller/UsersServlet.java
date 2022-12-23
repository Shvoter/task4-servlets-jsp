package com.web.khruchov.controller;

import com.web.khruchov.model.User;
import com.web.khruchov.model.UserDao;
import com.web.khruchov.repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    private UserRepository userRepository;

    @Override
    public void init() {
        userRepository = UserRepository.getUserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userRepository.readAll();
        List<UserDao> userDaos = new ArrayList<>();

        for (User user : users) {
            userDaos.add(new UserDao(user));
        }
        req.setAttribute("users", userDaos);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/users.jsp");
        requestDispatcher.forward(req, resp);
    }
}
