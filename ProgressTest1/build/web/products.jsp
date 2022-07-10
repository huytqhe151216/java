<%-- 
    Document   : products
    Created on : Mar 16, 2022, 6:27:09 PM
    Author     : ADMIN
--%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
        <div class="container bootdey">
            <div class="col-md-3">

                <section class="panel">
                    <header class="panel-heading">
                        <a href="products">Category</a>
                    </header>
                    <div class="panel-body">
                        <ul class="nav prod-cat" >
                            <c:forEach items="${listCategory}" var="c">      
                                <li>
                                    <a href="products?cid=${c.id}"><i class="fa fa-angle-right"></i> ${c.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </section>
                <section class="panel">
                    <header class="panel-heading" style="text-align: center">
                        <c:if test="${cart!=null}">
                            Have ${cart.size()} products in cart
                        </c:if>
                            <c:if test="${cart==null}">
                            Have 0 product in cart
                        </c:if>
                    </header>
                    <div class="panel-body" style="background-color: orange; width: fit-content; margin: 0 auto">
                        <a href="viewcart">View cart</a>
                    </div>
                </section>



            </div>
            <div class="col-md-9">


                <div class="row product-list" >
                    <c:forEach items="${listProducts}" var="p">
                        <div class="col-md-4">

                            <section class="panel">
                                <div class="pro-img-box">
                                    <img src="https://images.squarespace-cdn.com/content/v1/53883795e4b016c956b8d243/1578496681225-V1ZI0Y20V6BJYO1RX7IB/chup-anh-san-pham-gucci.jpg" alt="" />
                                    <a href="addtocart?pid=${p.id}" class="adtocart">
                                        <i class="fa fa-shopping-cart"></i>
                                    </a>
                                </div>

                                <div class="panel-body text-center">
                                    <h4>
                                        <div style="min-height: 60px">
                                            ${p.name}
                                        </div>
                                    </h4>
                                    
                                    <p class="price">$<fmt:formatNumber type = "number" maxIntegerDigits = "4" value = "${p.unitPrice}" /></p>
                                </div>
                            </section>

                        </div>
                    </c:forEach>

                </div>
                <section class="panel" >
                    <div class="panel-body" >
                        <div class="pull-right">
                            <ul class="pagination pagination-sm pro-page-list">
                                <c:forEach begin="1" end="${numberPage}" step="1" var="page">
                                    <li><a href="products?cid=${cid}&page=${page}">${page}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>
                </section>
            </div>
        </div>


        <style type="text/css">
            body{margin-top:20px;
                 background:#f1f2f7;
            }

            /*panel*/
            .panel {
                border: none;
                box-shadow: none;
            }

            .panel-heading {
                border-color:#eff2f7 ;
                font-size: 16px;
                font-weight: 300;
            }

            .panel-title {
                color: #2A3542;
                font-size: 14px;
                font-weight: 400;
                margin-bottom: 0;
                margin-top: 0;
                font-family: 'Open Sans', sans-serif;
            }


            /*product list*/

            .prod-cat li a{
                border-bottom: 1px dashed #d9d9d9;
            }

            .prod-cat li a {
                color: #3b3b3b;
            }

            .prod-cat li ul {
                margin-left: 30px;
            }

            .prod-cat li ul li a{
                border-bottom:none;
            }
            .prod-cat li ul li a:hover,.prod-cat li ul li a:focus, .prod-cat li ul li.active a , .prod-cat li a:hover,.prod-cat li a:focus, .prod-cat li a.active{
                background: none;
                color: #ff7261;
            }

            .pro-lab{
                margin-right: 20px;
                font-weight: normal;
            }

            .pro-sort {
                padding-right: 20px;
                float: left;
            }

            .pro-page-list {
                margin: 5px 0 0 0;
            }

            .product-list img{
                width: 100%;
                border-radius: 4px 4px 0 0;
                -webkit-border-radius: 4px 4px 0 0;
            }

            .product-list .pro-img-box {
                position: relative;
            }
            .adtocart {
                background: #fc5959;
                width: 50px;
                height: 50px;
                border-radius: 50%;
                -webkit-border-radius: 50%;
                color: #fff;
                display: inline-block;
                text-align: center;
                border: 3px solid #fff;
                left: 45%;
                bottom: -25px;
                position: absolute;
            }

            .adtocart i{
                color: #fff;
                font-size: 25px;
                line-height: 42px;
            }

            .pro-title {
                color: #5A5A5A;
                display: inline-block;
                margin-top: 20px;
                font-size: 16px;
            }

            .product-list .price {
                color:#fc5959 ;
                font-size: 15px;
            }

            .pro-img-details {
                margin-left: -15px;
            }

            .pro-img-details img {
                width: 100%;
            }

            .pro-d-title {
                font-size: 16px;
                margin-top: 0;
            }

            .product_meta {
                border-top: 1px solid #eee;
                border-bottom: 1px solid #eee;
                padding: 10px 0;
                margin: 15px 0;
            }

            .product_meta span {
                display: block;
                margin-bottom: 10px;
            }
            .product_meta a, .pro-price{
                color:#fc5959 ;
            }

            .pro-price, .amount-old {
                font-size: 18px;
                padding: 0 10px;
            }

            .amount-old {
                text-decoration: line-through;
            }

            .quantity {
                width: 120px;
            }

            .pro-img-list {
                margin: 10px 0 0 -15px;
                width: 100%;
                display: inline-block;
            }

            .pro-img-list a {
                float: left;
                margin-right: 10px;
                margin-bottom: 10px;
            }

            .pro-d-head {
                font-size: 18px;
                font-weight: 300;
            }
        </style>

        <script type="text/javascript">

        </script>
    </body>
</html>
