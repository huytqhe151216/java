<%-- 
    Document   : homeBlog
    Created on : Feb 28, 2022, 10:11:22 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog</title>
    </head>
    <body>
        <h1>List Block</h1>
        <table>
            <thead>
                <tr>
                    <th>BlogName</th>
                    <th>Description</th>
                    <th>Date Created</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listBlog}" var="blog">
                    <tr>
                        <td>${blog.blogName}</td>
                        <td>${blog.decription}</td>
                        <td>${blog.date}</td>
                    </tr>
                </c:forEach>
                    
            </tbody>
        </table>
    </body>
</html>
