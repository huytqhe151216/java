<%-- 
    Document   : register
    Created on : Mar 20, 2022, 7:32:21 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm sản phẩm</title>
        <style>
            @import url(https://fonts.googleapis.com/css?family=Roboto:300);

            .login-page {
                width: 360px;
                padding: 4% 0 0;
                margin: auto;
            }
            .form {
                position: relative;
                z-index: 1;
                background: #FFFFFF;
                max-width: 360px;
                margin: 0 auto 50px;
                padding: 45px;
                text-align: center;
                box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
            }
            .form input {
                font-family: "Roboto", sans-serif;
                outline: 0;
                background: #f2f2f2;
                width: 100%;
                border: 0;
                margin: 0 0 15px;
                padding: 15px;
                box-sizing: border-box;
                font-size: 14px;
            }
            .form button {
                font-family: "Roboto", sans-serif;
                text-transform: uppercase;
                outline: 0;
                background: #4CAF50;
                width: 100%;
                border: 0;
                padding: 15px;
                color: #FFFFFF;
                font-size: 14px;
                -webkit-transition: all 0.3 ease;
                transition: all 0.3 ease;
                cursor: pointer;
            }
            .form button:hover,.form button:active,.form button:focus {
                background: #43A047;
            }
            .form .message {
                margin: 15px 0 0;
                color: #b3b3b3;
                font-size: 12px;
            }
            .form .message a {
                color: #4CAF50;
                text-decoration: none;
            }
            .form .register-form {
                display: none;
            }
            .container {
                position: relative;
                z-index: 1;
                max-width: 300px;
                margin: 0 auto;
            }
            .container:before, .container:after {
                content: "";
                display: block;
                clear: both;
            }
            .container .info {
                margin: 50px auto;
                text-align: center;
            }
            .container .info h1 {
                margin: 0 0 15px;
                padding: 0;
                font-size: 36px;
                font-weight: 300;
                color: #1a1a1a;
            }
            .container .info span {
                color: #4d4d4d;
                font-size: 12px;
            }
            .container .info span a {
                color: #000000;
                text-decoration: none;
            }
            .container .info span .fa {
                color: #EF3B3A;
            }
            body {
                background: grey; /* fallback for old browsers */

                font-family: "Roboto", sans-serif;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;      
            }
        </style>
    </head>
    <body>
        <div style="color: blue; margin: 0 auto ; text-align: center;">

            <a href="managementAccount" style="background-color: orange">Quay lại</a>
        </div>
        <div class="login-page">
            <div class="form">
                <form class="login-form" method="post" action="addProduct">
                    <input type="text" placeholder="Tên sản phẩm" name="name" required/>
                    <input type="text" placeholder="Mô tả sản phẩm" name="description" required/>
                    <input type="text" placeholder="Giá" required name="price"/>
                    <input type="text" placeholder="Số lượng một đơn vị" name="quantityperunit" required/>
                    <input type="text" placeholder="trong giỏ còn" name="unitinstock" required/>
                    <input type="text" placeholder="ảnh 1" name="img1" required/>
                    <input type="text" placeholder="ảnh 2" name="img2" required/>
                    <input type="text" placeholder="ảnh 3" name="img3" required/>
                    ListCategory: <select name="categoryid">

                        <c:forEach items="${listCategory}" var="c">
                            <option value="${c.categoryId}">${c.categoryName}</option>
                        </c:forEach>

                    </select>

                    <button>Thêm</button>
                </form>
            </div>
            <div style="color: blue; margin: 0 auto; text-align: center">
                ${mess}
            </div>
        </div

    </body>
</html>
