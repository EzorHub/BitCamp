<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="dao.GoodsDao"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	   String path = request.getRealPath("goodsUpload");
	   MultipartRequest multi = new MultipartRequest(request,path,"UTF-8");
	   int no = Integer.parseInt(multi.getParameter("no"));
	   String name = multi.getParameter("name");
	   int price = Integer.parseInt(multi.getParameter("price"));
	   int qty = Integer.parseInt(multi.getParameter("qty"));
	   String fname = multi.getFilesystemName("fname");
	   
	   if(fname == null){
	      fname=multi.getParameter("origin_Fname");
	   }
	   GoodsDao dao = new GoodsDao();
	   int re = dao.updateGoods(name, price, qty, fname, no);
	   
	   if(re==1){
	      response.sendRedirect("goodsList.jsp");
	   }else{
	      %>
	      <font color="red">수정에 실패하였습니다</font>
	      <%
	   }
	%>

</body>
</html>