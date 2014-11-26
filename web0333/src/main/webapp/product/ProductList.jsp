<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/common/Header.jsp"/>
</head>
<body>
<div class='container'>
<h1>제품 목록(1.1)</h1>
<p><a href='add.do' class='btn btn-primary'>새제품</a></p>
<table class='table table-hover'>
<tr>
  <th>#</th><th>제품</th><th>수량</th><th>제조사</th>
</tr>

<c:forEach items="${products}" var="product">
<tr>
  <td>${product.no}</td>
  <td><a href='view.do?no=${product.no}'>${product.name}</a></td>
  <td>${product.quantity}</td>
  <td>${product.makerNo}</td>	
</tr>
</c:forEach>


</table>
</div>
<script src='../js/jquery-1.11.1.js'></script>
<jsp:include page="/common/Footer.jsp"/>
</body>
</html>
