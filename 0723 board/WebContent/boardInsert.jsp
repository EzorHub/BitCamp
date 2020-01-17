<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>게시글 등록</h2>
	
 	<form action="confirmInsert.jsp" method="post"> <br>
 	제목 : <input type="text" name ="title"> <br>
 	작성자 : <input type="text" name = "writer"> <br>
 	비밀번호 : <input type="password" name = "pwd"> <br>
 	내용 :<br> <textarea rows="50" cols="80" name="content"></textarea> <br>
 	<input type="submit" value="등록">
 	</form>
  	 
</body>
</html>