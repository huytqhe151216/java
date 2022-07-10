<%-- 
    Document   : caculatejsp
    Created on : Jan 13, 2022, 8:00:53 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String first = request.getAttribute("first").toString();
    String second = request.getAttribute("second").toString();
    String mess = request.getAttribute("mess").toString();
    String operator = request.getAttribute("option").toString();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Caculate</title>
    </head>
    <body>
       
        
        <form method="post">
            <label >First :</label>
            <input type="number"  name="first" required value="<%=first%>"><br><br>
            <select name="dropdown">
                <option value="add" <%= (operator.equals("add"))?"selected":"" %>>add</option>
                <option value="sub" <%= (operator.equals("sub"))?"selected":"" %>>sub</option>
                <option value="mul" <%= (operator.equals("mul"))?"selected":"" %>>mul</option>
            </select><br>
            <label for="second">second:</label>
            <input type="number"  name="second" required value="<%=second%>"><br><br>
            <input type="submit" value="Submit">
        </form>
        <h2><%=mess%></h2>
    </body>
</html>
