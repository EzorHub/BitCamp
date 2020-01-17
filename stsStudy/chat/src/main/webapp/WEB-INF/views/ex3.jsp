<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,user-scalable=no">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript">
	$(function() {

		var li;
		
			$.getJSON("getProductList", function(data){
					
					$.each(data, function(idx, item){
						
						li = $("<li id='goods'></li>");
						var a = $("<a href='#second_page' data-transition='slide'></a>").html(item.name);
						
						$(li).append(a);
						$("#ul").append(li);					
						$("#ul").listview("refresh"); /*미래에 추가된 노드에 jqueryMobile적용*/
							

						$(li).click(function(){
							$("#detail_info").empty();							
							/* alert(g[idx].name); */
							
							var h3 = $("<h3></h3>").html(item.name);
							var hr = $("<hr>");
							var img = $("<img/>").attr({src:"img/"+item.fname})
							var p1 = $("<p></p>").html("가격: "+item.price);
							var p2 = $("<p></p>").html("수량: "+item.qty);

							$("#detail_info").append(h3, hr, img, p1, p2);						
							
							});

						
						});

					

				});
	});
</script>
</head>
<body>
	<div data-role='page' id="first_page">
		<!-- data-role: 모바일에서 css,혹은 기능을 적용시켜주는 구분자 -->

		<div data-role='header'>
			<h1>상품목록</h1>
		</div>
		<div data-role='content' id="content">
			<ul data-role='listview' id="ul">
			<!-- 	<li><a href="#second_page" data-transition='slide'>오뎅</a></li>
				<li><a href="#second_page">순대</a></li>
				<li><a href="#second_page">떡볶이</a></li> -->
			</ul> 
		</div>
		<div data-role='footer'>
			<h1>스녕분식</h1>
		</div>

	</div>
	<div data-role='page' id='second_page' data-add-back-btn='true'>
		<div data-role='header'>
			<h1>상품상세</h1>
		</div>
		<div data-role='content' id="detail_info">
			<!-- <p>정보</p>
			<img id="img"/> -->
		</div>
	</div>
</body>
</html>