<%@page import="dao.BoardDao"%>
<%@page import="vo.BoardVo"%>
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
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String pwd = request.getParameter("pwd");
		String content = request.getParameter("content");
		
  		BoardDao dao = new BoardDao();
  		BoardVo v = dao.getBoard(no);
  		String c_pwd = v.getPwd();
  		
  		if(c_pwd.equals(pwd)){
  		int re = dao.updateBoard(title, content, no);
  		if(re==1){
  		response.sendRedirect("boardList.jsp");
  		}else{
  		%><font color="red">수정 실패</font><%
  		}}else{
  		%><font color="red">암호 확인</font><%
  		}
	%>
	
</body>
</html>