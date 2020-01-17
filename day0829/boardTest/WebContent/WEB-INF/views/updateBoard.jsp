<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시물 수정</h2>
<hr>

<form action="updateBoard.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="no" value="${b.no }"><!-- 수정 -->
제목: <input type="text" name="title" value="${b.title }" ><br>
작성자: <input type="text" name="writer" value="${b.writer }" readonly="readonly"><br>
암호: <input type="password" name="pwd"><br>
내용:<br>
<textarea rows="10" cols="20" name="content">${b.content }</textarea><br>
<input type="hidden" name="fname" value="${b.fname }">
<img src="files/${b.fname }" width="50" height="50">
파일: <input type="file" name="upload"><br>
<input type="submit" value="수정">
</form>
<form action="listBoard.do">
<input type="submit" value="목록">
</form>
</body>
</html>