<%-- 
    Document   : editEmployee
    Created on : Feb 8, 2022, 4:28:18 PM
    Author     : ADMIN
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.Department"%>
<%@page import="models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Employee em = (Employee) request.getAttribute("employee");
    ArrayList<Department> listD= (ArrayList<Department>) request.getAttribute("listD");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Employee</title>
    </head>
    <body>
        <h1>Edit Employee</h1>
        <div>
            <form method="post">
                <div>
                    <label for="id">ID</label>
                    <input type="number" value="<%= em.getId()%>" name="id" readonly="">
                </div>
                <div>
                    <label for="name">Name:</label>
                    <input type="text" value="<%= em.getName()%>" name="name">
                </div>
                <div>
                    <label for="date of birth">Date of birth</label>
                    <input type="date" value="<%= em.getDob()%>" name="dob">
                </div>
                <div >
                    <label for="gender">Gender:</label>
                    <div >
                        <div >
                            <input type="radio" name="gender" value="Male" <%=em.getSex().equals("Male") ? "checked" : ""%>>Male
                        </div>
                        <div >
                            <input type="radio"  name="gender" value="Female" <%=em.getSex().equals("Female") ? "checked" : ""%>>Female
                        </div>
                    </div>
                </div>
                <div >
                    <label for="position">Position:</label>
                    <input type="text"  value="<%=em.getPosition()%>" name="position">
                </div>
                <div>
                    <label for="department">Department</label>
                    <select name="departmentidold" >
                        <% for (Department d : listD ) {%>
                        <option value="<%=d.getId()%>" <%=em.getDepartment().getName().equals(d.getName()) ? "selected" : ""%>><%=d.getName()%></option>
                            <% }%>
                    </select>
                </div>
                <button type="submit" class="btn">Submit</button>
            </form>
        </div>
    </body>
</html>
