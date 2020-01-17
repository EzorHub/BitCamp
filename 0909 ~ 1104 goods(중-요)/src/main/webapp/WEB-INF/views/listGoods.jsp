<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		var msg = $("#msg").text();		
		setTimeout(function(){
				msg.hide();				
			}, 2000);
	});
</script>
</head>
<body>
	<h2>상품목록</h2><br>
	<span id="msg"><font color="green">${msg }</font></span>	
	<hr>
	<table width="100%">
		<tr>
			<td>번호</td>
			<td>상품명</td>
			<td>가격</td>
		</tr>
		<c:forEach var="g" items="${list }">
			<tr>
				<td>${g.no }</td>
				<td><a href="getGoods.do?no=${g.no}">${g.name }</a></td>
				<td>${g.price }</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="insertGoods.do">상품등록</a>
</body>
</html>