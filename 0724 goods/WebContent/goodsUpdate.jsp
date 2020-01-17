<%@page import="vo.GoodsVo"%>
<%@page import="dao.GoodsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>상품 수정</h2>
	<hr>
	
	<form action="confirmUpdate.jsp" method="post" enctype="multipart/form-data">
	<%
		int no = Integer.parseInt(request.getParameter("no"));
		String path = request.getRealPath("goodsUpload");
		GoodsDao dao = new GoodsDao();
		GoodsVo g = dao.getGoods(no);
		
		String name = g.getName();
		int price = g.getPrice();
		int qty = g.getQty();
		String fname = g.getFname();
	%>

	품명: <input type="text" name="name" value="<%=name %>">
	가격: <input type="number" name="price" value="<%=price %>">
	수량: <input type="number" name="qty" value="<%=qty %>">
	사진: <input type="file" name="fname">
		 <input type="hidden" name="origin_Fname" value="<%=fname %>">
	
	<input type="hidden" name="no" value =<%=no %>>
	<input type="submit" value="수정">
	</form>
	
</body>
</html>