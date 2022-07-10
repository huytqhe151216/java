<%-- 
    Document   : edit
    Created on : Feb 27, 2022, 4:58:11 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take attend</title>
    </head>
    <body>
        <h1 style="text-align: center; color: aqua;">List Student</h1>
        <div >
            <form style="justify-content: center;display: flex;flex-direction: column;"method="post" action="editAttendance?date=${date}&slot=${slot}&cid=${cid}">
                <table border="1" style="text-align: center;">
                    <thead>
                        <tr>
                            <th> Roll number</th>
                            <th> Full name</th>
                            <th> Absent</th>
                            <th> Present</th>
                            <th> Comment </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listStudent}" var="ls">
                            <tr>
                                <td>${ls.getStudents().getRoll()}</td>
                                <td>${ls.getStudents().getFullName()}</td>
                                <td>Absent: <input type="radio" name="check${ls.getRollCallBookId()}" value="false" ${ls.isIsAbsent()==false?"checked":""}/></td>
                                <td>Present: <input type="radio" name="check${ls.getRollCallBookId()}" value="true" ${ls.isIsAbsent()==true?"checked":""}/></td> 
                                <td >
                                    <input style="width: 98%;"  type="text" name="comment${ls.getRollCallBookId()}" value="${ls.getComment()}">
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <input style="color: blue;background-color: orange; width: fit-content;margin: 10px auto;" type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>
