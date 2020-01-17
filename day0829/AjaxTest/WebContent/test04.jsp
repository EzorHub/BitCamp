<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제이쿼리 필요성, 대상이 되는 노드</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnEnter").click(function() {
			var name = $("#name").val();
			var h = $("<h2></h2>").html(name + "님, 반갑습니다.");
			$("#result").html(h);
		});

	});
</script>
</head>
<body>
	이름:
	<input type="text" id="name">
	<input type="button" value="입장" id="btnEnter">
	<p id="result"></p>


</body>
</html>