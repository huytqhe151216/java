<%-- 
    Document   : addemployee
    Created on : Jan 21, 2022, 11:52:47 AM
    Author     : lephu
--%>

<%@page import="models.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Department> depts = (ArrayList<Department>) request.getAttribute("depts");
            String mess = request.getAttribute("mess").toString();
        %>
    </head>
    <body>
        <h1>Add new employee</h1>
        <form action="addemployee" method="post">
            Name: <input type="text" name="ename"><br>
            Sex: <select name="esex">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select><br>
            Dob: <input type="date" name="edob"><br>
            Position: <input type="text" name="eposition"><br>
            Department: <select name="deparment">
                <%for (Department d : depts) {%>
                <option value="<%= d.getId()%>"><%= d.getName()%></option>
                <%}%>
            </select><br>

            <input type="submit" value="Add new">
        </form>
        <%=mess%>
    </body>
</html>
