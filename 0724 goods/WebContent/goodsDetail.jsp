<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="dao.GoodsDao"%>
<%@page import="vo.GoodsVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>상품 상세</h2>
	<hr>
	
	<%
		
		int no = Integer.parseInt(request.getParameter("no"));
	
		GoodsDao dao = new GoodsDao();
		GoodsVo g = dao.getGoods(no);
		String name = g.getName();
		int price = g.getPrice();
		int qty = g.getQty();
		String fname = g.getFname();
		
	%>
	
	품번: <%= no%><br>
	품명: <%= name%><br>
	가격: <%= price%><br>
	수량: <%= qty%><br>
	사진: <img src = "goodsUpload/<%=fname%>">
	
	<form action="confirmDelete.jsp" method="post"> 
	<input type="hidden" name="no" value=<%=no %>>
	<input type="submit" value="삭제">
	</form>
	
	<form action="goodsUpdate.jsp" method="post"> 
	<input type="hidden" name="no" value=<%=no %>>
	<input type="submit" value="수정">
	</form>
	
</body>
</html>