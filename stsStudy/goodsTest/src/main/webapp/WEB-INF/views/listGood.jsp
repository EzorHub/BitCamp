<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>서버가동</h2>
	<hr>
	<table width="100%">
		<tr>
			<td>번호</td>
			<td>상품명</td>
			<td>가격</td>
			<td>수량</td>
			<td>파일명</td>
		</tr>
		<c:forEach var="g" items="${list }">
			<tr>
				<td>${g.no }</td>
				<td>${g.name }</td>
				<td>${g.price }</td>
				<td>${g.qty }</td>
				<td>${g.fname }</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>