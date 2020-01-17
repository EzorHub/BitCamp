<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>부서상세</h2>
	<hr>
	<form action="listDept.do">
		부서번호: <input type="text" value="${d.dno }" readonly="readonly"><br>
		부서이름: <input type="text" value="${d.dname }" readonly="readonly"><br>
		부서위치: <input type="text" value="${d.dloc }" readonly="readonly"><br>
		<input type="submit" value="목록으로">
	</form>


</body>
</html>