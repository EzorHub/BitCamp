<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function () {
	setTimeout(function() {
		$("#msg").hide();
	}, 2000);
});

</script>

</head>
<body>
	<h2>게시판 목록</h2>
	<hr>
	<span id="msg"><font color="red">${msg }</font></span><br>
	<form action="listBoard.do" method="post">
		<select name="type">
			<option value="writer">작성자</option>
			<option value="title" >제목</option>
			<option value="content">내용</option>
		</select> 		
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	
	<hr>
	<table width="100%">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<c:forEach items="${list }" var="b">
			<tr>
				<td>${b.no }</td>
				<td>
				<c:if test="${b.b_level > 0}">
				<c:forEach begin="1" end="${b.b_level }">
					&nbsp;&nbsp;&nbsp;
				</c:forEach>
				<img src="files/reply.png" width="20" height="20">
				</c:if>
				<a href="detailBoard.do?no=${b.no }">${b.title }</a></td>
				<td>${b.writer }</td>
				<td>${b.regdate }</td>
			</tr>
		</c:forEach>
	</table>
<br>
<hr>
<a href="insertBoard.do">등록</a>
<a href="listBoard.do">전체목록</a>
</body>
</html>