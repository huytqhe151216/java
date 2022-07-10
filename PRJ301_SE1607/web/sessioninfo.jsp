<%-- 
    Document   : sessioninfo
    Created on : Jan 14, 2022, 11:39:22 AM
    Author     : lephu
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String name = request.getAttribute("name").toString();
    String add = request.getAttribute("add").toString();
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>SessionInfo: <%=request.getSession().getId()%> </h1>
            <div>CreationTime: <%= new Date(request.getSession().getCreationTime()) %></div>
            <div>Last Access: <%= new Date(request.getSession().getLastAccessedTime())%></div>
        </div>
        Current: <%= name%> - <%= add%>
        <form action="SessionInfo" method="post">
            Name: <input type="text" value="" name="tbName">
            Add: <input type="text" value="" name="tbAdd">
            <input type="submit" value="Add info to session">
        </form>
    </body>
</html>
