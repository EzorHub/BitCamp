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
	<h2>부서목록</h2>
	<hr>
	<a href="insertDept.do">부서등록</a>
	<table width="100%">
		<tr>
			<td>번호</td>
			
		</tr>
		<c:forEach items="${list }" var="d">
			<tr>
				<td><a href="getDept.do?no=${d.dno}">${d.dno }</a></td>
				<td>${d.dname }</td>
				<td>${d.dloc }</td>
						
			</tr>
		</c:forEach>
	</table>

</body>
</html>