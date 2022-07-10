<%-- 
    Document   : democookie
    Created on : Jan 17, 2022, 11:54:33 AM
    Author     : lephu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            String rollnum = request.getAttribute("roll").toString();
            String name = request.getAttribute("name").toString();
            %>
    </head>
    <body>
        <form action="DemoCookie" method="post">
            <input type="text" name="roll" value="<%=rollnum%>">
            <input type="text" name="name" value="<%=name%>">
            <input type="submit" name ="btSubmit" value="Submit">
        </form>
    </body>
</html>
