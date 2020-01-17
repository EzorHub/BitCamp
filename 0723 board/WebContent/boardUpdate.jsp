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
	BoardDao dao = new BoardDao();
	int no = Integer.parseInt(request.getParameter("no"));
	BoardVo v = dao.getBoard(no);
	%>

	<h2>게시물 수정</h2>
	<hr>

	<form action="confirmUpdate.jsp?no=<%=no%>" method="post">
	제목 : <input type="text" name ="title" value="<%=v.getTitle()%>"> <br>
  	작성자 : <input type="text" name = "writer" value="<%=v.getWriter()%>" readonly="readonly"> <br>
  	비밀번호 : <input type="password" name = "pwd" > <br>
  	내용 :<br> <textarea rows="50" cols="80" name="content"><%=v.getContent()%></textarea> <br>
 	<input type="submit" value="수정">
	</form>
	
</body>
</html>