<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>도서등록</h2>
<hr>
<form action="insertBook.do" method="post">
번호:<input type="text" name="bookid"><br>
도서명:<input type="text" name="bookname"><br>
출판사:<input type="text" name="publisher"><br>
가격:<input type="text" name="price"><br>
<input type="submit" value="등록"> 
<input type="reset" value="취소"> 
</form>
<form action="listBook.do">
<input type="submit" value="목록">
</form>
</body>
</html>