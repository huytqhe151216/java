<%-- 
    Document   : navigationBar
    Created on : Mar 6, 2022, 10:08:53 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="navbar">
    <div class="navbar-inner">
        <div class="container">
            <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <div class="nav-collapse">
                <ul class="nav">
                    <li class="${sessionScope.localPage eq "home" ?"active":""}" ><a href="WebDoCau">Trang chủ	</a></li>
                    <li class="${sessionScope.localPage eq "product" ?"active":""}"><a href="product">Sản phẩm</a></li>
                    <li class=""><a href="list-view.html">Giới thiệu</a></li>
                    <li class=""><a href="list-view.html">Liên hệ</a></li>

                </ul>

                <ul class="nav pull-right" style="" >

                    <div style="display: flex; align-items: center; flex-direction: row; margin-bottom: 3px" >
                        <a href="viewcart" style="margin-right: 10px"> <span  class="btn " >[ ${(sessionScope.cart.size()>0?sessionScope.cart.size():"0")}] <span class="icon-shopping-cart"></span></span></a>
                                <c:if test="${sessionScope.isLogin!=null}">
                            <a href="managementAccount" style="background-color: orange; margin-right: 15px; padding: 5px">Hello ${sessionScope.isLogin.username}</a>
                            <a href="logout" style="background-color: orange; margin-right: 15px; padding: 5px">Đăng xuất</a>
                        </c:if >
                        <c:if test="${sessionScope.isLogin==null}">
                            <a href="login" style="color: orange ; margin-right: 10px; " >Đăng nhập</a>
                            <a href="register" style="color: orange ; margin-right: 10px; ">Đăng ký</a>
                        </c:if>
                    </div>

                </ul>
            </div>
        </div>
    </div>
</div>
