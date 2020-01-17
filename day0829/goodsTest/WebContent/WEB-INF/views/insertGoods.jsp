<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품등록</h2>
	<hr>
	<form action="insertGoods.do" method="post" enctype="multipart/form-data">
		상품번호: <input type="number" name="no"><br> 
		상품명: <input
			type="text" name="name"><br> 
			가격: <input type="number"
			name="price"><br> 
			수량: <input type="number" name="qty"><br>
		파일: <input type="file" name="upload"><br> 
		<input
			type="submit" value="등록"> 
			<input type="reset" value="취소">
	</form>
	<form action="listGoods.do">
		<input type="submit" value="목록">
	</form>
</body>
</html>