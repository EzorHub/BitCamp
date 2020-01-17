<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="vo.MemberVo"%>
<%@page import="dao.MemberDao"%>
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
		String path=request.getRealPath("MemberUpload");
	 	System.out.println(path);
	 	request.setCharacterEncoding("UTF-8");
	 	MultipartRequest multi = new MultipartRequest(request,path,"UTF-8");
	 	String id = multi.getParameter("id");
	 	String pwd = multi.getParameter("pwd");
	 	String name = multi.getParameter("name");
	 	int age = Integer.parseInt(multi.getParameter("age"));
	 	String tel = multi.getFilesystemName("tel");
	 	String fname = multi.getFilesystemName("fname");
	 	String fname = multi.getFilesystemName("fname");
	 	String fname = multi.getFilesystemName("fname");
	 	
	 	MemberDao dao = new MemberDao();
	 	MemberVo v = new MemberVo();
	 	v.setId(id);
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