package com.web.khruchov.controller;

import com.web.khruchov.model.UserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = "/*")
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        UserDao user = (UserDao) httpServletRequest.getSession().getAttribute("user");

        if (user == null && !isGeneralAccessURI(httpServletRequest)) {
            httpServletResponse.sendError(403);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private boolean isGeneralAccessURI(HttpServletRequest httpServletRequest) {
        String contextPath = httpServletRequest.getContextPath();
        final List<String> generalAccessURIs = new ArrayList<>();

        generalAccessURIs.add(contextPath + "/");
        generalAccessURIs.add(contextPath + "/login");

        return generalAccessURIs.contains(httpServletRequest.getRequestURI());
    }
}
