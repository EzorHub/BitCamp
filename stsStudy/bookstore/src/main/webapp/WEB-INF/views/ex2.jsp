<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
*{
	margin: 0px;
	padding: 0px;
}
body{
	background-color: #525252;
	
}
.item{
	margin: 5px;
	width: 100px;
	border-radius: 10px;
	background-color: white;	
	float: left;
}
.big{
	width: 210px;
	height: 430px;
}
.normal{
	width: 210px;
	height: 210px;
}
.small{
	width: 100px;
	height: 100px;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
<script type="text/javascript" src="masonry/masonry.pkgd.min.js"></script>
<script type="text/javascript">
$(function(){
 	$("masonry_container").masonry({
		itemSelector:'.item',
		columnWidth:110,
		isAnimated:true
		}); 
});
</script>
</head>
<body>


<div id="masonry_container"> 
<div class="item small"></div>
<div class="item big"></div>
<div class="item normal"></div>
<div class="item small"></div>
<div class="item small"></div>
<div class="item small"></div>
<div class="item normal"></div>
<div class="item normal"></div>
<div class="item small"></div>
<div class="item small"></div>
<div class="item small"></div>
</div>
</body>
</html>