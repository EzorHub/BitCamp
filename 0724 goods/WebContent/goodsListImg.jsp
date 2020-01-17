<%@page import="vo.GoodsVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.GoodsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img{display:block;
	width:50px;
	height:50px;}
</style>
</head>
<body>

<%
	GoodsDao dao = new GoodsDao();
	ArrayList<GoodsVo> list = dao.listAll();
	for(GoodsVo g: list){
		%>
		<img src="goods/<%=g.getFname()%>">
		<%
	}
%>

</body>
</html>