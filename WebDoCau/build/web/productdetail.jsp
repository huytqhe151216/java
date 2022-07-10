<%-- 
    Document   : product
    Created on : Mar 15, 2022, 5:02:15 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web do cau</title>
        <%@include file="include.jsp" %>
    </head>
    <body>

        <div class="container">
            <div id="gototop"> </div>
            <%@include file="header.jsp" %>
            <%@include file="navigationBar.jsp" %>
            <!-- 
Body Section 
            -->
            <div class="row">
                <div id="sidebar" class="span3">
                    <div class="well well-small">
                        <ul class="nav nav-list">
                            <c:forEach items="${listCategory}" var="c">
                                <li><a href="product?cid=${c.categoryId}"><span class="icon-chevron-right"></span>${c.getCategoryName()}</a></li>
                                    </c:forEach>
                        </ul>
                    </div>

                    <%@include file="search.jsp" %>


                </div>
                <div class="span9">

                    <div class="well well-small">
                        <div class="row-fluid">
                            <div class="span5">
                                <div id="myCarousel" class="carousel slide cntr">
                                    <div class="carousel-inner">
                                        <div class="item active">
                                            <a href="#"> <img src="${listImg.get(0)}" alt="" style="width:100%"></a>
                                        </div>
                                        <div class="item">
                                            <a href="#"> <img src="${listImg.get(1)}" alt="" style="width:100%"></a>
                                        </div>
                                        <div class="item">
                                            <a href="#"> <img src="${listImg.get(2)}" alt="" style="width:100%"></a>
                                        </div>
                                    </div>
                                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                                    <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
                                </div>
                            </div>
                            <div class="span7">
                                <h3>${product.name}</h3>
                                <hr class="soft" />

                                <form class="form-horizontal qtyFrm">
                                    <div class="control-group">
                                        <label class="control-label"><span>${product.price} đồng</span></label>
                                        <div class="controls">
                                            /${product.quantityPerUnit}
                                        </div>
                                    </div>



                                    <h4> Còn lại :${product.unitInStock} </h4>

                                    <c:if test="${product.unitInStock>0}">
                                                <h4><a class="shopBtn" href="addtocart?pid=${product.id}" title="add to cart"> Thêm vào giỏ hàng </a></h4>
                                            </c:if>
                                            <c:if test="${product.unitInStock<1}">
                                                <h4><a class="shopBtn" href="#" title="add to cart"> Hết hàng =)) </a></h4>
                                            </c:if>
                                    <c:if test="${sessionScope.isLogin.isAdmin}">
                                        <h4> <a href="modifyProduct?pid=${product.id}">Sửa</a> </h4>
                                    </c:if>
                                </form>
                            </div>
                        </div>
                        <hr class="softn clr" />


                        <ul id="productDetail" class="nav nav-tabs">
                            <li class="active"><a href="#home" data-toggle="tab">Thông tin sản phẩm</a></li>

                        </ul>
                        <div>
                            ${product.depscription}
                        </div>

                    </div>
                </div>
            </div> <!-- Body wrapper -->
            <!-- 
Clients 
            -->


            <!--
Footer
            -->
            <%@include file="footer.jsp" %>
        </div><!-- /container -->


        <a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.easing-1.3.min.js"></script>
        <script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
        <script src="assets/js/shop.js"></script>
    </body>
</html>
