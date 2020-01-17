<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그아웃</h2>
<hr>

<%
	
	session.invalidate(); //세션을 완전히 파기해줌

%>
</body>
</html>