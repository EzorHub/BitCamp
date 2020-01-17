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
</head>
<body>
<%
try{
	int from = Integer.parseInt(request.getParameter("from"));
	int to = Integer.parseInt(request.getParameter("to"));
	int amount = Integer.parseInt(request.getParameter("amount"));
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.91:1521:XE", "c##madang", "madang");
	conn.setAutoCommit(false);
	
	String sql1 = "update bank set balance = balance - ? where no=?";
	String sql2 = "update bank set balance = balance + ? where no=?";
	
	PreparedStatement pstmt1 = conn.prepareStatement(sql1);
	PreparedStatement pstmt2 = conn.prepareStatement(sql2);
	
	pstmt1.setInt(1, amount);
	pstmt1.setInt(2, from);
	
	pstmt2.setInt(1, amount);
	pstmt2.setInt(2, to);
	
	int re = 0;
	int re1 = pstmt1.executeUpdate();
	int re2 = pstmt2.executeUpdate();
	
	if(re1 == 1 && re2 == 1)
	{
		conn.commit();
	}
	else
	{
		conn.rollback();
	}
	

	if(pstmt1 != null)
	{
		pstmt1.close();
	}

	if(pstmt2 != null)
	{
		pstmt2.close();
	}
	
	if(conn != null)
	{
		conn.close();
	}
	
}catch(Exception e)
{
	System.out.println(e.getMessage());
}
	
%>
완료!
</body>
</html>









