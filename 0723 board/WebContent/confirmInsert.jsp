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

	<h2>등록 완료</h2>

	<%
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String pwd = request.getParameter("pwd");
		String content = request.getParameter("content");
		
  		BoardVo v = new BoardVo();
  		v.setTitle(title);
  		v.setWriter(writer);
  		v.setPwd(pwd);
  		v.setContent(content);
  		
  		BoardDao dao= new BoardDao();
  		int re= dao.insertBoard(v);
  		if(re==1){
  			response.sendRedirect("boardList.jsp");
  		}else{
  			%>
  			<font color="red">등록 실패</font>
  			<%
  		}
	%>
	
</body>
</html>