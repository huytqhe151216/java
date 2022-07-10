<%-- 
    Document   : managementaccount
    Created on : Mar 20, 2022, 6:34:41 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html >

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
        <title>Document</title>

    </head>

    <body>
        <section style="background-color: #eee;">
            <div class="container py-5">


                <div class="row">
                    <div class="col-lg-4">
                        <div class="card mb-4">
                            <div class="card-body text-center">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
                                     alt="avatar" class="rounded-circle img-fluid" style="width: 150px;">
                                <h5 class="my-3">${sessionScope.isLogin.username}</h5>

                            </div>
                        </div>

                    </div>
                    <div class="col-lg-8">
                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Tên</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">${newC.name}</p>
                                    </div>
                                </div>
                                <hr>


                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Số điện thoại</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">${newC.phone}</p>
                                    </div>
                                </div>


                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Địa chỉ</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">${newC.address}</p>
                                    </div>
                                </div>
                                <div>
                                    <a href="changeInfo" ><button style="background-color: blue">Thay đổi thông tin</button></a>
                                    <a href="viewHistory"><button style="background-color: blue">Xem danh sách sản phẩm đã mua</button></a>
                                    <a href="viewHistory"><button style="background-color: blue">Đổi mật khẩu</button></a>
                                </div>
                                        <c:if test="${sessionScope.isLogin.isAdmin}">
                                            <a href="addProduct" ><button style="background-color: red">Thêm sản phẩm</button></a>
                                            <a href="managementShop" ><button style="background-color: red">Xem đơn chờ duyệt</button></a>
                                    </c:if>
                                <div style="margin-top: 10px; padding: 5px">
                                    <a href="WebDoCau" style="background-color: orange;padding: 5px ">Trở về trang chủ</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </section>
    </body>

</html>
