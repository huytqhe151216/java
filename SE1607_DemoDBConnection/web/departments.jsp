<%-- 
    Document   : departments
    Created on : Jan 19, 2022, 11:59:51 AM
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
        %>
    </head>
    <body>
        <h1>List of departments:</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <% for(Department p:depts) {%>
                <tr>
                    <td><%= p.getId()%></td>
                    <td><%= p.getName()%></td>
                    <td> <a href="./employees?did=<%= p.getId()%>">go details</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>

    </body>
</html>
