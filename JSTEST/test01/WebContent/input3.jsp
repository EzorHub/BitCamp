<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쌤꺼랑 다시봐라</title>
<script type="text/javascript">
function check() {
	var name = document.getElementById("name").value; /*jquery에서 #id이름으로 갖고오는표현과 같음*/
	var age = document.getElementById("age").value;
	
	name = name.trim();	
	if(name=="" || age==""){		
		return;
	}
	if(isNaN(age)==true){		
		return;
	}
	document.getElementById("F").submit(); /*성공==>원래 submit눌렀을때 다음동작을 해라*/
	
}

</script>

</head>
<body>
<h2>회원 정보 입력</h2>
<hr>

<form action="result.jsp" method="post" id="F">
이름: <input type="text" id="name" name="name"><br>
나이: <input type="text" id="age" name="age"><br>
<input type="button" value="확인" onclick="check()">
</form>

</body>
</html>