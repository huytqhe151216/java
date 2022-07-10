<%-- 
    Document   : search
    Created on : Mar 21, 2022, 1:12:50 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="well well-small alert alert-warning cntr">
    <form action="product" method="get">
        
        <input type="hidden" value="${sort==true?"1":"0"}" name="sort">
        <h4> Bạn cần tìm gì? </h4>
        <input  style="width: 95%"type="text" placeholder="Tên sản phẩm" name="name" value="${name}" >
        <select name="price"  style="width: 102%">
            <option value="0-10000000" ${price eq "0-10000000"?"selected":""} > Giá</option>
            <option value="0-299999" ${price eq "0-299999"?"selected":""}> Dưới 300.000 đồng</option>
            <option value="300000-700000" ${price eq "300000-700000"?"selected":""}>Từ 300.000 đồng đến 700.000 đồng</option>
            <option value="700000-1500000" ${price eq "700000-1500000"?"selected":""}>Từ 700.000 đồng đến 1.500.000 đồng</option>
            <option value="1500000-10000000" ${price eq "1500000-10000000"?"selected":""}>Trên 1.500.000 đồng</option>
        </select>
        <input type="submit" value="Tìm">
    </form>
</div>
