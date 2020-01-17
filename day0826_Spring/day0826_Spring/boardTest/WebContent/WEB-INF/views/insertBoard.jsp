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
<form action="listBoard.do"> 
	글번호: <input type="text" name="" ><br> 
	 제목:<input type="text" value="${vo.title }" ><br>
	작성자: <input type="text" value="${vo.writer }" ><br>
	조회수:<input type="text" value="${vo.hit }"><br>
	 내용:<br>
	<textarea rows="10" cols="50">${vo.content }</textarea>	 
	<br>
	<input type="submit" value="돌아가기">
</form>
</body>
</html>