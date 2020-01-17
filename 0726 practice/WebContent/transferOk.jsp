<%@page import="dao.AccountDao"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#success{
		color: blue;
	}
	
	#fail{
		color: red;
	}
</style>
</head>
<body>
<%

	int from = Integer.parseInt(request.getParameter("from"));
	int to = Integer.parseInt(request.getParameter("to"));
	int amount = Integer.parseInt(request.getParameter("amount"));
	
	AccountDao dao = new AccountDao();
	boolean re  = dao.transfer(from, to, amount);
	if(re)
	{
		out.println("<p id='success'>이체 성공</p>");
	}
	else
	{
		out.println("<p id='fail'>이체 실패</p>");
	}
%>	
</body>
</html>









