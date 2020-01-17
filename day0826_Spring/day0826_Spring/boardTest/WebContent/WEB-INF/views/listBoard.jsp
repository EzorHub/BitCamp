<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 목록</h2>
	<hr>
	<table width="100%">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>등록일</td>
		</tr>
<c:forEach items="${list }" var="b">
		<tr>
			<td>${b.no }</td>
			<td><a href="getBoard.do?no=${b.no}">${b.title }</a></td>
			<td>${b.writer }</td>
			<td>${b.regdate}</td>			
		</tr>
</c:forEach>

	</table>

</body>
</html>