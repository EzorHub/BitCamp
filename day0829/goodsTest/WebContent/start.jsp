<%@page import="org.springframework.web.filter.CharacterEncodingFilter"%>
<%@page import="org.springframework.web.servlet.DispatcherServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버가동!<br>

<a href="listGoods.do">상품목록</a>
<%
	//DispatcherServlet
	//CharacterEncodingFilter
%>

<a href="logOut.jsp">로그아웃</a>


</body>
</html>