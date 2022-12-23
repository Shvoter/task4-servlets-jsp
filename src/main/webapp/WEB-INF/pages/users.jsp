<%@ page import="com.web.khruchov.model.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>List of users</title>
    </head>

    <body>
        <%@include file="menu.jsp"%>

        <h3 style="padding-left: 20px">List of Users</h3>
        <table style="padding-left: 20px" class="table">
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>login</th>
            </tr>
            <%
                for (UserDao userDao : (List<UserDao>)request.getAttribute("users")) {
            %>
            <tr>
                <td><%=userDao.getName()%></td>
                <td><%=userDao.getSurname()%></td>
                <td><%=userDao.getLogin()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
