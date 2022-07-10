<%-- 
    Document   : productlist
    Created on : Feb 21, 2022, 10:05:39 AM
    Author     : ADMIN
--%>

<%@page import="models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <% 
        ArrayList<Product> pros = (ArrayList<Product>) request.getAttribute("listProduct");
        
    %>
    <div>
        <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Category</th>
                            <th>UnitPrice</th>
                            <th>UnitInStock</th>
                            <th></th> 
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Product p : pros) {%>
                        <tr>
                            <td><%= p.getId()%></td>
                            <td><%= p.getProductName()%></td>
                            <td><%= p.getCategory()%></td>
                            <td><%= p.getUnitPrice()%></td>
                            <td><%= p.getUnitInStock()%></td>
                            <td><a hrel="addtocart?pid=<%=p.getId()%>"> </a>Add to cart</td>
                        </tr>
                        <%}%>
                    </tbody>
                </table> 
    </div>

