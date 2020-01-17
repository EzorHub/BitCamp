<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#result {
	width: 300px;
	height: 50px;
	border: 1px solid blue;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnAjax").click(function() {
			$.ajax({url:"hello.jsp",  success:function (data) {
				$("#result").html(data);
				
				
			}});
		});
	});
</script>
</head>
<body>
	<button id="btnAjax">Ajax통신</button>
	<div id="result"></div>
	<img src="content.PNG">
</body>
</html>