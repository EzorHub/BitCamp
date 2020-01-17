<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>상품등록</h2>
<hr>
<form action="insertGoods.do" method="post" enctype="multipart/form-data">
상품명: <input type="text" name="name"><br>
가격: <input type="text" name="price"><br>
수량: <input type="text" name="qty"><br>
사진: <input type="file" name="upload"><br>
<input type="submit" value="등록">
</form>
</body>
</html>