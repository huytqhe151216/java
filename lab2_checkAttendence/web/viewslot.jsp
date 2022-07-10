<%-- 
    Document   : viewslot
    Created on : Feb 27, 2022, 4:14:44 PM
    Author     : ADMIN
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            HashMap<String, ArrayList<Integer>> hm = (HashMap<String, ArrayList<Integer>>) request.getAttribute("cs");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align: center;color: aqua;">Schedule</h1>
        <table border="1" style="width: 60%; margin: 0 auto; text-align: center;">
            <thead>
                <tr>
                    <th>TeachingDate</th>
                    <th>Slot</th>
                    
                </tr>
            </thead>
            <tbody>
                <%for (Map.Entry<String, ArrayList<Integer>> set : hm.entrySet()) {%>
                <tr>
                    <td>
                        <%=set.getKey()%>
                    </td>
                    <td>
                        <table >
                            <%for (Integer i : set.getValue()) {%>
                            <tr>
                            <label>Slot <%=i%></label>
                            <a style="padding: 0 20px;" href="editAttendance?cid=${cid}&date=<%=set.getKey()%>&slot=<%=i%>">Edit</a>
                            <br>
                            </tr>
                            <%}%> 
                        </table> 
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
