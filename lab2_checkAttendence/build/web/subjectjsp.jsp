<%-- Document : subjectjsp Created on : Feb 26, 2022, 3:20:39 PM Author : ADMIN --%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Subject</title>
                <style>
                    .main{
                       display: flex;
                       justify-content: center;
                       flex-direction: column;
                    }   
                </style>
            </head>

            <body>
                <h1 style="text-align: center; color: chartreuse;">List Subjects </h1>
                <div class="main" >
                    
                    <table border="1" style="text-align: center;">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>SubjectCode</th>
                                <th>SubjectName</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listSubject}" var="i">
                                <tr>
                                    <td>${i.id}</td>
                                    <td>${i.code}</td>
                                    <td>${i.name}</td>
                                    <td>
                                        <a href="CoursePage?subjectId=${i.id}">View Course</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </body>

            </html>