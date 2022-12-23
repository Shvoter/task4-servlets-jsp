<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Login page</title>
    </head>

    <body>
        <form style="padding-left: 20px;" method="post" action="${pageContext.request.contextPath}/login">
            <table>
                <tr>
                    <td>Login: </td>
                    <td><input type="text" name="login" value="login1"></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="text" name="password" value="password1"></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
