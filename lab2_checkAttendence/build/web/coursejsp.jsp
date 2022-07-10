<%-- 
    Document   : coursejsp
    Created on : Feb 26, 2022, 4:12:05 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align: center; color: aquamarine;">List Course</h1>
        <h2>${mess}</h2>
        <div class="course" style="display: flex; justify-content: center; flex-direction: column;">
            <table border="2" style="text-align: center;" >
                <thead >
                    <tr>
                        <th>courseID</th>
                        <th>CourseCode</th>
                        <th>SubjectName</th>
                    </tr>   
                </thead>
                <tbody>
                    <c:forEach items="${listCourse}" var="list" >
                    <tr>
                        <td>${list.id}</td>
                        <td>${list.courseCode}</td>
                        <td>${list.subjectId.name}</td>
                        <td>
                            <a href="takeAttendance?cid=${list.id}">Take attendance</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
