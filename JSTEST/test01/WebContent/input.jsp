<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2>회원 정보 입력</h2>
<hr>

<form action="result.jsp" method="post" id="F">
이름: <input type="text" id="name" name="name" required="required"><br>
나이: <input type="number" id="age" name="age" required="required"><br>
<input type="submit" value="확인" onclick="check()">
</form>

</body>
</html>