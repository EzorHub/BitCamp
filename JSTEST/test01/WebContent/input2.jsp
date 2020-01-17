<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check() {
	var name = document.F.name.value;/*변수 name을 쓰겠음, 현장에선 안씀, 최초의 javaScript*/
	var age = document.F.age.value; /*웹초기 자바스크립트는 제대로 입력했는지, 검사용도로만 쓰였음-유효성검사*/
	
	name = name.trim();	
	if(name=="" || age==""){		
		return;
	}
	if(isNaN(age)==true){		
		return;
	}
	document.F.submit(); /*성공==>원래 submit눌렀을때 다음동작을 해라*/
	
}

</script>

</head>
<body>
<h2>회원 정보 입력</h2>
<hr>

<form action="result.jsp" method="post" name="F">
이름: <input type="text" name="name"><br>
나이: <input type="text" name="age"><br>
<input type="button" value="확인" onclick="check()">
</form>

</body>
</html>