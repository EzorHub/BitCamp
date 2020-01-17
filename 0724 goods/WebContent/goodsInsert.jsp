<%@page import="dao.GoodsDao"%>
<%@page import="vo.GoodsVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>상품 등록</h2>
	<hr>
	
	<form action="confirmInsert.jsp" method = "post" enctype="multipart/form-data">
	품명: <input type="text" name ="name"><br>
	가격: <input type="number" name ="price"><br>
	수량: <input type="number" name ="qty"><br>
	사진: <input type="file" name ="fname">
	<input type="submit" value="등록">
	</form>

</body>
</html>