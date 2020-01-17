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

	<table border="5">
	
		<h2>게시판 목록</h2>
		
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		
		<%
			BoardDao dao = new BoardDao();
			ArrayList<BoardVo> list = dao.listAll();
			for (BoardVo v : list) {
				int no = v.getNo();
				String title = v.getTitle();
				String writer = v.getWriter();
				String regdate = v.getRegdate();
		%>
		
		<tr>
			<td><%=no%></td>
			<td><a href = "boardDetail.jsp?no=<%=no%>"><%=title%></a></td>
			<td><%=writer%></td>
			<td><%=regdate%></td>
		</tr>
		
		<%
			}
		%>
		
	</table>
	
	<form action="boardInsert.jsp" method="get"> 
		<input type = "submit" value = "게시글 등록"> 
	</form>
	
</body>
</html>