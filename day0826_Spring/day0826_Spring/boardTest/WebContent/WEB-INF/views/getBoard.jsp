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
	<h2>게시물 상세</h2>
	<hr>
<form action="listBoard.do"> 
	글번호: <input type="text" value="${vo.no}" readonly="readonly"><br> 
	 제목:<input type="text" value="${vo.title }" readonly="readonly"><br>
	작성자: <input type="text" value="${vo.writer }" readonly="readonly"><br>
	조회수:<input type="text" value="${vo.hit }" readonly="readonly"><br>
	 내용:<br>
	<textarea rows="10" cols="50">${vo.content }</textarea>	 
	<br>
	<input type="submit" value="돌아가기">
</form>
</body>
</html>