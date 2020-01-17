<%@page import="vo.GoodsVo"%>
<%@page import="dao.GoodsDao"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		String path=request.getRealPath("goodsUpload");
	 	System.out.println(path);
	 	request.setCharacterEncoding("UTF-8");
	 	MultipartRequest multi = new MultipartRequest(request,path,"UTF-8");
	 	String name = multi.getParameter("name");
	 	int price = Integer.parseInt(multi.getParameter("price"));
	 	int qty = Integer.parseInt(multi.getParameter("qty"));
	 	String fname = multi.getFilesystemName("fname");
	 	
	 	GoodsDao dao = new GoodsDao();
	 	GoodsVo g= new GoodsVo();
	 	g.setName(name);
	 	g.setPrice(price);
	 	g.setQty(qty);
	 	g.setFname(fname);
	 	
	 	int re = dao.insertGoods(g);
	 	if(re==1){
	 		response.sendRedirect("goodsList.jsp");
	 	}else{
	 		%><font color="red">등록 실패</font><%
	 	}
	%>

</body>
</html>