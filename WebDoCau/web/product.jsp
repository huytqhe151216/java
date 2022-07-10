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
        <title>Sản phẩm</title>
        <%@include file="include.jsp" %>

    </head>
    <body>


        <div class="container">
            <div id="gototop"> </div>
            <%@include file="header.jsp" %>
            <%@include file="navigationBar.jsp" %>
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
                    <!-- 
                    New Products
                    -->
                    <div class="well well-small">

                        <div style="display: flex;flex-wrap: wrap; justify-content: space-between">
                            <c:if test="${cid!=null}">
                                <h3>${c.categoryName}  </h3>
                            </c:if>
                            <c:if test="${cid==null}">
                                <h3>Tất cả sản phẩm  </h3>
                            </c:if>
                            <form method="get" action="product">
                                <input type="hidden" value="${name}" name="name">
                                <input type="hidden" value="${price}" name="price">
                                <select name="sort" style="margin: auto 0" onchange="this.form.submit()">
                                    <option value="1" ${sort==true?"selected":""}>Giá tăng dần</option>
                                    <option value="0" ${sort==false?"selected":""}>Giá giảm dần</option>
                                </select>
                            </form>

                        </div>

                        <div class="row-fluid">
                            <ul class="thumbnails">
                                <c:forEach items="${listProduct}" var="p">
                                    <li class="span4" style="margin: 0; margin-right: 2px;height: 390px">
                                        <div class="thumbnail">
                                            <a href="product_details.html" class="overlay"></a>
                                            <a class="zoomTool" href="product_details?pid=${p.id}" title="add to cart"><span class="icon-search"></span> Xem chi tiết</a>
                                            <a href="product_details?pid=${p.id}"><img src="${p.getImg()}" alt=""></a>
                                            <div class="caption cntr">
                                                <div style="min-height: 80px;"><p>${p.name}</p></div>
                                                <p><strong> ${p.price} đồng</strong></p>
                                                <c:if test="${p.unitInStock>0}">
                                                    <h4><a class="shopBtn" href="addtocart?pid=${p.id}" title="add to cart"> Thêm vào giỏ hàng </a></h4>
                                                </c:if>
                                                <c:if test="${p.unitInStock<1}">
                                                    <h4><a class="shopBtn" href="#" title="add to cart"> Hết hàng =)) </a></h4>
                                                </c:if>
                                                <br class="clr">
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>

                        </div>   
                        <div>
                            <div class="pagination">
                                <ul>
                                    <li><a href="product?cid=${cid}&page=${currentPage==1?1:currentPage-1}&sort=${sort==true?"1":"0"}&name=${name}&price=${price}">Trang trước</a></li>

                                    <c:forEach begin="1" end="${totalPage}" step="1" var="page">
                                        <li><a href="product?cid=${cid}&page=${page}&sort=${sort==true?"1":"0"}&name=${name}&price=${price}">${page}</a></li>
                                        </c:forEach>
                                    <li><a href="product?cid=${cid}&page=${currentPage==totalPage?totalPage:currentPage+1}&sort=${sort==true?"1":"0"}&name=${name}&price=${price}">Trang sau</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <%@include file="footer.jsp" %>
        </div>
        <a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.easing-1.3.min.js"></script>
        <script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
        <script src="assets/js/shop.js"></script>
    </body>
</html>
