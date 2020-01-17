<%@page import="dao.BoardDao"%>
<%@page import="java.util.ArrayList"%>
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
		BoardVo b = dao.getBoard(no);
		%>
		
		<h2>게시물 상세</h2>
		<hr>
		
		글번호 : <%= b.getNo() %> <br>
		글제목 : <%= b.getTitle() %> <br>
		작성자 : <%= b.getWriter() %> <br>
		글내용 :
		<br>
		<textarea rows="10" cols="80" readonly="readonly"><%= b.getContent() %></textarea>
		<br>
		조회수 : <%= b.getHit() %> <br>
		등록일 : <%= b.getRegdate() %> <br>

		<a href="boardUpdate.jsp?no=<%=b.getNo()%>">수정</a>
		<a href="boardDelete.jsp?no=<%=b.getNo()%>">삭제</a>
		
</body>
</html>