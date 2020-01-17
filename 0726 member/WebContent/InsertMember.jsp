<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>회원등록</h2>
	<hr>
	
	<form action="InsertConfirm.jsp" post="method">
	아이디: <input type="text" name="id"><br>
	암호: <input type="password" name="pwd"><br>
	이름: <input type="text" name="name"><br>
	나이: <input type="number" name="age"><br>
	연락처: <input type="tel" name="tel"> <br>
	주소: <input type="text" name="addr"><br>
	취미: <input type="text" name="hobby"><br>
	직업: <input type="text" name="job"><br>
	성별: 남<input type="radio" name="gender" value="남">
		 여<input type="radio" name="gender" value="여"><br>
	사진: <input type="file" name="img"><br>
	<input type="submit" value="등록">
	</form>

</body>
</html>