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
<title>제이쿼리 플러그인 연습_ex04_상품이미지_배열</title>
<style type="text/css">

/*구성전 css설정*/
*{
	margin: 0px;padding: 0px;
}	
body{
	font-size: 62.5%;
}

.item{
	margin: 3px;padding: 5px;
}
.item>img{
	width: 100px;height: 100px;
}

#wrap{overflow: hidden;}
#wrap>div{float: left;}
#dock{position: fixed; min-height: 120px;width: 100%;
		bottom: 0px;z-index: 1;}
#dock>div{float: right;}
</style>


<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
<script type="text/javascript" src="jqueryUI/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		//상품이미지 20개의 이름을 배열에 저장
		//배열의 수만큼 div노드 생성		
		//생성된 div에 이미지 노드 생성하여 추가
		//생성된 div는 wrap에 추가
		//생성된 div에 item클래스를 설정
		//pdf 39p참고
		
		
		var arr = ['od.jpg','sd.jpg','tbbk.jpg','ud.jpg','soju.jpg'];
		
		for(var i=0;i<arr.length;i++){
			var div = $('<div class="item"></div>');
			var img = $('<img/>').attr(
					"src","img/"+arr[i]
				);
			
			$(div).append(img);
			$("#wrap").append(div);
			
			}

		
		
		/* 파일명이 통일되어있을때 반복문 돌릴 수 있음
		var arr = new Array();
		for(var i=0;i<20;i++){
			arr[i] += '.jpg';
			} */


		$("#wrap>div").draggable({
			helper:'clone',
			zIndex:100,
			scroll:false
			});

		$("#dock").droppable({
			accept:"#wrap>div",
			drop:function(evt, ui){
				$(ui.draggable).fadeOut(function(){
					$(this).appendTo("#dock").fadeIn();
					});
				}
			});
		$("body").droppable({
			accept:"#dock>div",
			drop:function(evt, ui){
				$(ui.draggable).fadeOut(function(){
					$(this).appendTo("#wrap").fadeIn();
					});
				}
			});

		
			
	});
</script>
</head>
<body>
	<div id="wrap">	
	</div>
	<div id="dock" class="ui-state-error"></div>
</body>
</html>