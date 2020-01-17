<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트-삭제 확인요청</title>
<script type="text/javascript">
	function pro() {
		re = confirm("정말로 삭제하시겠어요?");
		if(re==true){
			location.href="start.jsp";
		}
	}
</script>
</head>
<body>
	<button onclick="pro()">삭제</button>
</body>
</html>