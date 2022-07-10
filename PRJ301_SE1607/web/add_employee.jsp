<%-- 
    Document   : add_employee
    Created on : Jan 16, 2022, 8:45:49 PM
    Author     : ADMIN
--%>

<%@page import="models.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add employees</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="add_employee" method="post">
            <label>Name</label>
            <input  type="text" name="name" required=""><br><br>
            <label>Gender: </label>
            <input type="radio" name="gender" value="Male"/>
            <label>Male</label>
            <input type="radio" name="gender" value="Female"  />
            <label>Female</label>
            <br><br>
            <label>Position: </label>
            <select name="position">
                <option value="Dev" >Dev</option>
                <option value="Tester" >Tester</option>
                <option value="Manager" >Manager</option>
            </select>
            <br><br>
            <label>Salary:</label>
            <input  type="text" name="salary" required=""><br><br>
            <input type="submit" value="add to list" name="btnSubmit"/>
            <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Gender</th>
                            <th>Position</th>
                            <th>Salary</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Employee> employee = (ArrayList<Employee>) request.getAttribute("employee");
                            if (employee.size() != 0) {
                                for (int i = 0; i < employee.size(); i++) {
                                    out.println("<tr>");
                                    out.println("<td>" + employee.get(i).getName() + "</td>");
                                    out.println("<td>" + employee.get(i).getGender()+ "</td>");
                                    out.println("<td>" + employee.get(i).getPosition() + "</td>");
                                    out.println("<td>" + employee.get(i).getSalary() + "</td>");
                                    out.println("</tr>");
                                }
                            }
                        %>
                    </tbody>
                </table>
        </form>
    </body>
</html>
