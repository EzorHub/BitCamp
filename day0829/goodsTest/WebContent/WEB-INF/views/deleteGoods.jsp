<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품삭제</h2>
<hr>
<form action="deleteGoods.do" method="post">
해당 상품을 삭제하시려면 아래 빈칸에 암호를 입력하세요,<br>
암호: <input type="password" name="pwd"><br>
<input type="hidden" value="${no }" name="no"><br>
<input type="submit" value="입력">
</form>

</body>
</html >