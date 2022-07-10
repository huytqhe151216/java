<%-- 
    Document   : datejsp
    Created on : Jan 11, 2022, 8:31:24 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String datenow = request.getAttribute("datenow").toString();
    String getOption = request.getAttribute("getOption").toString();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=datenow%></h1>
        <h2><%=getOption%></h2>
        <form action='date' method='post'>
            <select name="dropdown">
                <option value="year">year</option>
                <option value="month">month</option>
                <option value="day">day</option>
                <option value="hour">hour</option>
                <option value="minute">minute</option>
            </select>
            <input type='submit' name='btnSubmit' value='Submit'>
        </form>
    </body>
</html>
