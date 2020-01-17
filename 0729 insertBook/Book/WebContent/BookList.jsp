<%@page import="dao.BookDao"%>
<%@page import="vo.BookVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
	<tr>
	<td>번호</td>
	<td>제목</td>
	<td>출판사</td>
	<td>가격</td>
	</tr>

	<%
	ArrayList<BookVo> list = new ArrayList<BookVo>();
	BookDao dao = new BookDao();
	list= dao.allBookList();
	
	for(BookVo v : list){
		%><tr>
		<td><%=v.getBookid()%></td>
		<td><%=v.getBookname()%></td>
		<td><%=v.getPublisher()%></td>
		<td><%=v.getPrice()%></td>
		</tr><%
	}
	%>
	</table>
</body>
</html>