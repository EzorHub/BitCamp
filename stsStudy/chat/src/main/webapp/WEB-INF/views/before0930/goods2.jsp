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
	padding:0px;
	overflow:hidden;
}
.item{
	margin: 5px;
	padding: 5px;
	width:300px;
	height:150px;
	float: left;
	border-width: 3px;
	border-style: solid;
	border-color: grey;
	border-radius: 10px;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
<script type="text/javascript">
$(function(){
	$.getJSON("getProductList", function(data){
			
		$.each(data, function(idx, item){
				var div = $("<div></div>").addClass("item");
				var name = $("<h3></h3>").html(item.name);
				var fname = $("<img/>").attr(
						{src:"img/"+item.fname,
						width:100,
						height:100
							});
						
				var no = $("<p></p>").html(item.no);				
				var price = $("<p></p>").html(item.price);
				var qty = $("<p></p>").html(item.qty);

				$(div).append(name,fname,no,price,qty);
				$("#wrap").append(div);
				
			
			});
		});
});

</script>
</head>
<body>
<h2>상품목록</h2>
<hr>

<div id="wrap"></div>
</body>
</html>