<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>도서삭제</h2>
<hr>
<form action="deleteBook.do" method="post">
도서를 삭제하시려면 관리자 암호를 입력하세요. <br>
<input type="password" name="pwd" value="${pwd }">
<input type="hidden" name="bookid"value="${bookid }">
<input type="submit" value="삭제">
</form>

</body>
</html>