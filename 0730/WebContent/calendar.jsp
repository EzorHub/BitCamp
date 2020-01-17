<%@page import="java.util.Date"%>
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
		int[] lastDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Date today = new Date();
		int year = today.getYear();
		int month = today.getMonth();

		if (request.getParameter("month") != null) {
			month = Integer.parseInt(request.getParameter("month"));
			year = Integer.parseInt(request.getParameter("year"));
			if (month == 12) {
				month = 0;
				year += 1;
			}
		}

		if (request.getParameter("month2") != null) {
			month = Integer.parseInt(request.getParameter("month2"));
			year = Integer.parseInt(request.getParameter("year"));
			if (month == -1) {
				month = 11;
				year -= 1;
			}
		}

		int last = lastDay[month];
		Date startDay = new Date(year, month, 1);
		int blank = startDay.getDay();
	%>

	<h2>
		<a href="calendar.jsp?month2=<%=month - 1%>&year=<%=year%>">◀</a>
		<%=year + 1900%>년
		<%=month + 1%>월 <a
			href="calendar.jsp?month=<%=month + 1%>&year=<%=year%>">▶</a>
	</h2>
	<hr>

	<table border="1">

		<tr>
			<td>일</td>
			<td>월</td>
			<td>화</td>
			<td>수</td>
			<td>목</td>
			<td>금</td>
			<td>토</td>
		</tr>

		<tr>
			<%
				for (int j = 1; j <= blank; j++) {
			%>
			<td></td>
			<%
				}

				for (int i = 1; i <= last; i++) {
			%>
			<td><%=i%></td>
			<%
				if ((i + blank) % 7 == 0) {
			%>
		</tr>
		<tr>
			<%
				}
				}
			%>
		</tr>
	</table>
</body>
</html>