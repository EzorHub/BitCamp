<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link rel="stylesheet" href="jqueryUI/themes/dark-hive/jquery-ui.css">
<title>제이쿼리 플러그인 연습_ex01</title>
<style type="text/css">
	.box{
		width: 100px;height: 100px; float: left;
	}
</style>


<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
<script type="text/javascript" src="jqueryUI/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
			$("div.box").draggable({
					grid:[102,102],
					stop:function(event,ui){
						/*
							event
							실행했던 이벤트? 여기서는 grid
							ui 드레그한 요소에 대한 정보
						*/
						alert(ui.offset.top+': '+ui.offset.left);
						/*이동한 요소가 있는 위치: x, y*/
						}
					

				});
	});
</script>
</head>
<body>
	<div class="box ui-widget-content">망고</div>
	<div class="box ui-widget-content">복숭아</div>
	<div class="box ui-widget-content">무화과</div>
	<div class="box ui-widget-content">청포도</div>
</body>
</html>