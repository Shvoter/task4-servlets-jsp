<%@ page import="com.web.khruchov.model.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Home page</title>
    </head>

    <body>
        <%@ include file="menu.jsp"%>

        <h3 style="padding-left: 20px">
            Hello, <%=((UserDao)request.getSession().getAttribute("user")).getName() + " " +
                    ((UserDao)request.getSession().getAttribute("user")).getSurname()%>
        </h3>
    </body>
</html>
