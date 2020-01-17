<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시물 등록</h2>
<hr>

<form action="insertBoard.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="no" value="${no }"><!-- 답글인지 새글(부모글)인지 구분하기 위해 글번호를 보냄 -->
제목: <input type="text" name="title"><br>
작성자: <input type="text" name="writer"><br>
암호: <input type="password" name="pwd"><br>
내용:<br>
<textarea rows="10" cols="20" name="content"></textarea><br>
파일: <input type="file" name="upload"><br>
<input type="submit" value="등록">
</form>
<form action="listBoard.do">
<input type="submit" value="목록">
</form>
</body>
</html>