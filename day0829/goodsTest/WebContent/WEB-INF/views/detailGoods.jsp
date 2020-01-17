<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품상세</h2>
	<hr>
	<form action="updateGoods.do">
		상품번호: <input type="number" name="no" value="${g.no }" readonly="readonly"><br> 
		상품명: <input
			type="text" name="name" value="${g.name }" readonly="readonly"><br> 
			가격: <input type="number"
			name="price" value="${g.price }" readonly="readonly"><br> 
			수량: <input type="number" name="qty" value="${g.qty }" readonly="readonly"><br>
		파일: <img src="img/${g.fname }" width="100" height="100"> <br> 
		<input
			type="submit" value="수정"> 
			<input type="reset" value="취소">
	</form>
	<form action="listGoods.do" >
		<input type="submit" value="목록">
	</form>
	<form action="deleteGoods.do">
		<input type="hidden" name="no" value="${g.no }">
		<input type="submit" value="삭제">
	</form>
</body>
</html>