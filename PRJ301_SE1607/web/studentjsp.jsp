<%-- 
    Document   : studentjsp
    Created on : Jan 13, 2022, 9:35:03 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String fName = request.getAttribute("fName").toString();
    String lName = request.getAttribute("lName").toString();
    String gender =request.getAttribute("gender").toString();
    String DOB = request.getAttribute("DOB").toString();
    String major = request.getAttribute("major").toString();
    String mess = request.getAttribute("mess").toString();
    String cb1 = request.getAttribute("cb1").toString();
    String cb2 = request.getAttribute("cb2").toString();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="student" method="POST">
            <label>First Name: </label>
            <input type="text" name="firstName" value="<%=fName%>" required/>
            <br><br>
            <label>Last Name: </label>
            <input type="text" name="lastName" value="<%=lName%>" required/>
            <br><br>
            <label>Gender: </label>
            <input type="radio" name="gender" value="Male" <%=(gender.equals("Male")) ? "checked" : ""%>/>
            <label>Male</label>
            <input type="radio" name="gender" value="Female" <%=(gender.equals("Female")) ? "checked" : ""%> />
            <label>Female</label>
            <br><br>
            <label>Major: </label>
            <select name="major">
                <option value="SE" <%=(major.equals("SE")) ? "selected" : ""%>>SE</option>
                <option value="IA" <%=(major.equals("IA")) ? "selected" : ""%>>IA</option>
                <option value="GD" <%=(major.equals("GD")) ? "selected" : ""%>>GD</option>
            </select>
            <br><br>
            <label>Date of birth: </label>
            <input type="date" name="DOB" value="<%=DOB%>"/>
            <br><br>
            <input type="checkbox" name="cb1" value="In dormitory" <%=(cb1.equals("In dormitory")) ? "checked" : ""%> />
            <label>In dormitory</label>
            <br><br>
            <input type="checkbox" name="cb2" value="In reservation" <%=(cb2.equals("In reservation")) ? "checked" : ""%> />
            <label>In reservation</label>
            <br><br>
            <input type="submit" value="Submit" name="btnSubmit" />
            <p><%=mess%></p>
        </form>
    </body>
</html>
