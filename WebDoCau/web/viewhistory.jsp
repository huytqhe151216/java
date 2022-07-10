<%-- 
    Document   : viewhistory
    Created on : Mar 20, 2022, 9:26:52 PM
    Author     : ADMIN
--%>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@page import="java.lang.Integer"%>
<%@page import="models.Product"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <title>shopping cart checkout - Bootdey.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <style type="text/css">
            body{margin-top:20px;
                 background:#eee;
            }
            h3 {
                font-size: 16px;
            }
            .text-navy {
                color: #1ab394;
            }
            .cart-product-imitation {
                text-align: center;
                padding-top: 30px;
                height: 80px;
                width: 80px;
                background-color: #f8f8f9;
            }
            .product-imitation.xl {
                padding: 120px 0;
            }
            .product-desc {
                padding: 20px;
                position: relative;
            }
            .ecommerce .tag-list {
                padding: 0;
            }
            .ecommerce .fa-star {
                color: #d1dade;
            }
            .ecommerce .fa-star.active {
                color: #f8ac59;
            }
            .ecommerce .note-editor {
                border: 1px solid #e7eaec;
            }
            table.shoping-cart-table {
                margin-bottom: 0;
            }
            table.shoping-cart-table tr td {
                border: none;
                text-align: right;
            }
            table.shoping-cart-table tr td.desc,
            table.shoping-cart-table tr td:first-child {
                text-align: left;
            }
            table.shoping-cart-table tr td:last-child {
                width: 80px;
            }
            .ibox {
                clear: both;
                margin-bottom: 25px;
                margin-top: 0;
                padding: 0;
            }
            .ibox.collapsed .ibox-content {
                display: none;
            }
            .ibox:after,
            .ibox:before {
                display: table;
            }
            .ibox-title {
                -moz-border-bottom-colors: none;
                -moz-border-left-colors: none;
                -moz-border-right-colors: none;
                -moz-border-top-colors: none;
                background-color: #ffffff;
                border-color: #e7eaec;
                border-image: none;
                border-style: solid solid none;
                border-width: 3px 0 0;
                color: inherit;
                margin-bottom: 0;
                padding: 14px 15px 7px;
                min-height: 48px;
            }
            .ibox-content {
                background-color: #ffffff;
                color: inherit;
                padding: 15px 20px 20px 20px;
                border-color: #e7eaec;
                border-image: none;
                border-style: solid solid none;
                border-width: 1px 0;
            }
            .ibox-footer {
                color: inherit;
                border-top: 1px solid #e7eaec;
                font-size: 90%;
                background: #ffffff;
                padding: 10px 15px;
            }
        </style>
    </head>
    <body>

        <div class="container">

            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row">
                    <div class="col-md-9">
                        <div class="ibox">
                            <div class="ibox-title">
                                
                                <h5>${(listProduct==null || listProduct.size()==0)?"Bạn chưa mua sản phẩm nào":"Danh sách sản phẩm đã mua"}</h5>
                            </div>
                            <c:if test="${listProduct.size()>0}">
                                <div class="ibox-content">
                                    <div class="table-responsive">
                                        <table class="table shoping-cart-table">
                                            <tbody>
                                                <c:forEach items="${listProduct}" var="p">
                                                    <tr >
                                                        <td width="90">
                                                            <div class="cart-product-imitation" style="background-image: url('${p.getImg()}'); background-size: cover">
                                                                
                                                            </div>
                                                        </td>
                                                        <td class="desc">
                                                            <h3>
                                                                <a href="product_details?pid=${p.id}" class="text-navy">
                                                                    ${p.name}
                                                                </a>
                                                            </h3>
                                                            
                                                            


                                                        </td>

                                                        <td>
                                                            <p class="price">${p.price} đồng </p>

                                                        </td>
                                                        
                                                        <td>
                                                            
                                                            <a href="product_details?pid=${p.id}" style="background-color: orange; padding: 3px">Mua lại</a>
                                                            
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>

                                </div>
                                <a href="managementAccount" style="background-color: "><input type="submit" value="Quay lại" style="background-color: orange" ></a>
                            </c:if>
                        </div>

                    </div>
                    
                </div>
            </div>
        </div>
    </body>
</html>
