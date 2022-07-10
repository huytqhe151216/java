<%-- 
    Document   : managementShop
    Created on : Mar 23, 2022, 8:25:25 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xem đơn chờ</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1>Danh sách đơn chờ duyệt</h1>
        <div style="display: flex; justify-content: center; flex-direction: column;">
            <table border="1" style="text-align: center">
                <thead style="padding: 20px 0">
                    <tr > 
                        <th>mã đơn</th>
                        <th>id người mua</th>
                        <th>tên người mua</th>
                        <th>địa chỉ</th>
                        <th>Chi tiết đơn</th>
                        <th>duyệt</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOrderPending}" var="op">
                        <tr>
                            <td>${op.id}</td>
                            <td>${op.customerId}</td>
                            <td>${op.getCustomerById().name}</td>
                            <td>${op.getCustomerById().address}</td>
                            <td style="display: flex; justify-content: center; flex-direction: column;">
                                <table border="1">
                                    <thead>
                                    <td>Mã sản phẩm</td>
                                    <td>tên sản phẩm</td>
                                    <td>Số lượng</td>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${op.viewOrderDetail()}" var="od">
                                            <tr>
                                                <td>${od.pid}</td>
                                                <td>${od.getproductName()}</td>
                                                <td>${od.quantity}</td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </td>
                            <td>
                                <a href="accept?oid=${op.id}"> duyệt</a>
                            </td>
                        </tr>
                    </c:forEach>


                </tbody>
            </table>
        </div>
        <div><a href="managementAccount">Quay lại</a></div>
    </body>
</html>
