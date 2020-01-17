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
.big img{
	width: 210px;
	height: 430px;
	font-size: 50%;
}
.normal{
	width: 210px;
	height: 210px;
}
.normal img{
	width: 210px;
	height: 210px;
	font-size: 70%;
	
}
.small{
	width: 100px;
	height: 100px;
}
.small img{
	width: 100px;
	height: 100px;
	font-size: 62.5%;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
<script type="text/javascript" src="masonry/masonry.pkgd.min.js"></script>
<script type="text/javascript">
$(function(){
	var div, img, p1, p2, p3, p4;
 	$("masonry_container").masonry({
		itemSelector:'.item',
		columnWidth:110,
		isAnimated:true
		}); 
	
	$.getJSON("getProductList",function(data){
		
				$.each(data, function(idx, item){

					function items(){
						img = $("<img/>").attr({
							src:"img/"+item.fname
							});						
						
						}
					
						if(0<idx&&idx<15){
							div = $("<div class='item big'></div>");
							items();
							 p1 =$("<p></p>").html(item.no);
							 p2 =$("<p></p>").html(item.name);
							 p3 =$("<p></p>").html(item.price);
							 p4=$("<p></p>").html(item.qty);
							$(div).append(img,p1,p2,p3,p4);
							$("#masonry_container").append(div);
							
						}else if(16<idx&&idx<25){
							div = $("<div class='item small'></div>")
							items();
							$(div).append(img);
							$("#masonry_container").append(div);
						}else if(25<idx&&idx<30){
							div = $("<div class='item normal'></div>")
							items();
							$(div).append(img);
							$("#masonry_container").append(div);
							}
					});
				});
	
});
</script>
</head>
<body>


<div id="masonry_container"> 
<!-- <div class="item small"><img src="img/od.jpg"></div>
<div class="item big"><img src="img/sd.jpg"></div>
<div class="item normal"><img src="img/ttbk.jpg"></div>
<div class="item small"><img src="img/ud.jpg"></div>
<div class="item small"><img src="img/toto.jpg"></div>
<div class="item small"><img src="img/wine.jpg"></div>
<div class="item normal"><img src="img/soju.jpg"></div>
<div class="item normal"><img src="img/od.jpg"></div>
<div class="item small"><img src="img/od.jpg"></div>
<div class="item small"><img src="img/od.jpg"></div>
<div class="item small"><img src="img/od.jpg"></div> -->
</div>
</body>
</html>