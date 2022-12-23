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

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserRepository userRepository;

    @Override
    public void init() {
        userRepository = UserRepository.getUserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = userRepository.readByLogin(login);

        if (user == null || !password.equals(user.getPassword())) {
            resp.sendError(401);
            return;
        }

        UserDao userDao = new UserDao(user);
        req.getSession().setAttribute("user", userDao);
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
