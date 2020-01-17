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
	<h2>사원검색</h2>
	<hr>

	<form action="searchEmp.do" method="post">
		관리자: <input type="text" name="name">
		<input type="submit" value="검색"><br>
		<table width="100%">
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>부서명</td>
				<td>부서위치</td>
				<td>연봉</td>
				<td>입사연도</td>
				<td>근무개월수</td>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
				<td>${vo.eno }</td>
				<td>${vo.ename }</td>
				<td>${vo.dname }</td>
				<td>${vo.dloc }</td>
				<td>${vo.income }</td>
				<td>${vo.hiredate }</td>
				<td>${vo.m }</td>				
			</tr>
			</c:forEach>
		</table>

		
	</form>
</body>
</html>