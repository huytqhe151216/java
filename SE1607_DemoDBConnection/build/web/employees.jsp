<%-- 
    Document   : employees
    Created on : Jan 21, 2022, 11:35:55 AM
    Author     : lephu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="models.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Employee> emps = (ArrayList<Employee>) request.getAttribute("emps");
//            int depID = Integer.parseInt(request.getAttribute("did").toString());
        %>
    </head>
    <body>
        <div style="display: flex">
            <div>
                <h1>List of employees:</h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Sex</th>
                            <th>Dob</th>
                            <th>Position</th>
                            <th>Department</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Employee e : emps) {%>
                        <tr>
                            <td><%= e.getId()%></td>
                            <td><%= e.getName()%></td>
                            <td><%= e.getSex()%></td>
                            <td><%= e.getDob()%></td>
                            <td><%= e.getPosition()%></td>
                            <td><%= e.getDepartment().getName()%></td>
                            <td><a href="./editEmployee?eid=<%= e.getId()%>&did=<%=e.getDepartment().getId()%>">Edit</a></td>
                            <td><a href="./deleteEmployee?eid=<%= e.getId()%>&did=<%=e.getDepartment().getId()%>">Delete</a></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table> 
                <a href="addemployee">Add new Employee</a>
            </div>

            <div style="margin-left: 20px">
                <div>
                    <h1>Filter</h1>
                    <form method="post">
                        <table border="1" cellspacing="2" cellpadding="2">
                            <thead>
                                <tr>
                                    <th>Attribute</th>
                                    <th>Input</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Name</td>
                                    <td><input type="text" name="name"></td>
                                </tr>
                                <tr>
                                    <td>Date from</td>
                                    <td><input type="date" name="dobFrom"></td>
                                </tr>
                                <tr>
                                    <td>Date to</td>
                                    <td><input type="date" name="dobTo"></td>
                                </tr>
                                <tr>
                                    <td>Gender</td>
                                    <td><select name="gender">
                                            <option value="">All gender</option>
                                            <option value="Male">Male</option>
                                            <option value="Female">Female</option>
                                        </select></td>
                                </tr>
                                <tr>
                                    <td>Position</td>
                                    <td><select name="position">
                                            <option value="">All Position</option>
                                            <c:forEach items="${listP}" var="p">
                                                <option value="${p}">${p}</option>
                                            </c:forEach>
                                        </select></td>
                                </tr>
                                <tr>
                                    <td>Department</td>
                                    <td><select name="department">
                                            <option value="">All Department</option>
                                            <c:forEach items="${listD}" var="d">
                                                <option value="${d.getId()}">${d.getName()}</option>
                                            </c:forEach>
                                        </select></td>
                                </tr>
                                <tr>
                                    <td>Submit</td>
                                    <td><button>Search</button></td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
                    <div>
                        <%@include file="paging.jsp"%>
                        
                    </div>           
        


    </body>
</html>
