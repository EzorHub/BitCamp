<%@page import="dao.GoodsDao"%>
<%@page import="vo.GoodsVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>상품 목록</h2>
	<hr>
	<table border="2">
	<tr>
		<td>품번</td>
		<td>품명</td>
		<td>가격</td>
		<td>수량</td>
	</tr>
		
	<%
		GoodsDao dao = new GoodsDao();
		ArrayList<GoodsVo> list = dao.listAll();
		for (GoodsVo v : list) {
			int no = v.getNo();
			String name = v.getName();
			int price = v.getPrice();
			int qty = v.getQty();
	%>
		
		<tr>
			<td><%=no%></td>
			<td><a href="goodsDetail.jsp?no=<%=no%>"><%=name%></a> </td>
			<td><%=price%></td>
			<td><%=qty%></td>
		</tr>
		
		<%
			}
		%>
		
	</table>
	
	<form action="goodsInsert.jsp" method="post"> 
		<input type = "submit" value = "상품 등록"> 
	</form>

</body>
</html>