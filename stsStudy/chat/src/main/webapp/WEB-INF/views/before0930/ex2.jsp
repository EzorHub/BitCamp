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
#box{
	padding: 5px;
	
}
#box h1{
	margin: 0px;
	padding: 5px;
	text-align: center;
}

#list > div{ /*list의 자식 div*/

	padding:5px; float: left; 
	 
}
</style>


<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
<script type="text/javascript" src="jqueryUI/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
			var arr = $("#list").find("h1");
			$(arr).hover(function(){
					$(this).addClass("ui-state-hover");
				}, function(){
					$(this).removeClass("ui-state-hover");
					//$(this).addClass("ui-state-default"); - 제거가안됨
					});
	});
</script>
</head>
<body>
<div id="list">
	<div class="ui-state-default ui-corner-all">
	<span class="ui-icon ui-icon-heart"></span>
	</div>
	
	<div class="ui-state-default ui-corner-all">
	<span class="ui-icon ui-icon-heart"></span>
	</div>
	<div class="ui-state-default ui-corner-all">
	<span class="ui-icon ui-icon-star"></span>
	</div>
	<div class="ui-state-default ui-corner-all">
	<span class="ui-icon ui-icon-plus"></span>
	</div>
	</div>
	<br>
	<br>
	
	<div id="test" class="ui-widget-content">
	<h1>무지</h1>
	<h1>어피치</h1>
	<h1>프로도</h1>
	<h1>콘</h1>
	</div>
	<br>
	<br>
	<div id="box" class="box ui-state-default ui-corner-all">
	<h1 class="ui-widget-header">Lorem ipsum dolor sit amet</h1>
	<p>Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a,</p>
	</div>
</body>
</html>