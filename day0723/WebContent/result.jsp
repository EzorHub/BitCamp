<%@ page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>결과화면</h2>
	
	<%
		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String[] hobby = request.getParameterValues("hobby");
		String job = request.getParameter("job");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String birth = request.getParameter("birth");
		String self = request.getParameter("self");	
	%>

	아이디: <%=id%><br>
	암호: <%=pwd%><br>
	이름: <%=name%><br>
	
	취미:
		<%
		String hb_str = "없음";
		if(hobby != null)
		{
			//for(String str : hobby){hb_str += str + ",";}
			hb_str = Arrays.toString(hobby);
			hb_str = hb_str.substring(1, hb_str.length()-1);
		}
		%>
		<%= hb_str %><br>
		
	직업: <%= job %><br>
	성별: <%= gender %><br>
	나이: <%= age %><br>
	이메일: <%= email %><br>
	전화번호: <%= tel %><br>
	생일: <%= birth %><br>
	자기소개: <%= self %><br>
	
</body>
</html>