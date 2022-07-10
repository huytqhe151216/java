<%-- 
    Document   : login
    Created on : Jan 18, 2022, 8:30:06 PM
    Author     : ADMIN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String name= request.getAttribute("name").toString();
    String password = request.getAttribute("password").toString();
    String mess = request.getAttribute("mess").toString();
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="Login" method="post">
            <label>Name</label>
            <input type="text" name="name" value="<%=name%>"><br>
            <label>Password</label>
            <input type="password" name="password" value="<%=password%>"><br>
            <input type="checkbox" name="remember">
            <label> Remember me</label><br>
            <input type="submit" value="submit">
        </form>
        <%=mess%>
    </body>
</html>
