<%-- 
    Document   : paging
    Created on : Feb 17, 2022, 12:36:29 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div>
    <c:forEach begin="1" end="${endPage}" var="i">
        <a href="${curUrl}pageIndex=${i}"> ${i}</a>
    </c:forEach>
</div>
