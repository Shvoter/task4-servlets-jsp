package com.web.khruchov.controller;

import com.web.khruchov.model.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao user = (UserDao) req.getSession().getAttribute("user");
        req.setAttribute("name", user.getName());
        req.setAttribute("surname", user.getSurname());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/home.jsp");
        requestDispatcher.forward(req, resp);
    }
}
