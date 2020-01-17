<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
<script type="text/javascript">
	$(function() {
		$("#op").hide();
		var type = $("#type").val();
		if (type == "price") {
			$("#op").show();
		}
		$("#type").change(function() {
			var type = $(this).val();
			if (type == "price") {
				$("#op").show();
			} else {
				$("#op").hide();
			}
			$("#keyword").val("");
		});

		setTimeout(function() {
			$("#msg").hide();
			$("#suc").hide();
		}, 3000);
	});
</script>
<style type="text/css">
.goods{
	width: 200px;
	height: 200px;	
	border: 1px solid white;
	display: inline;
	float: left;
	margin: 10px;
}
#line{
		display: block;
	}
	
#page{
		display: block;
		position: absolute; /*절대위치에 위치시킴*/
		left: 200px;
		top: 400px;
	}
#btn{
		display: block;
		position: absolute; /*절대위치에 위치시킴*/
		right: 200px;
		top: 400px;
	}
	
/* .all{
	width: 70%;		
	border: 1px solid white;
	display: inline;
	float: left;
	margin: 7px;
} */

</style>

</head>
<body>
	<h2>상품목록</h2>
	<hr>
	<span id="msg"><font color="red">${msg }</font></span>
	<span id="suc"><font color="blue">${suc }</font></span>
	&nbsp;&nbsp;&nbsp;
	<form action="listGoods.do" method="post">
		<select name="type" id="type">
			<option value="name">상품명</option>
			<option value="price" id="price">가격</option>
		</select> <select name="op" id="op">
			<option value="<="><=</option>
			<option value="=">=</option>
			<option value=">=">>=</option>
		</select> 
		<input type="text" name="keyword"> 
		<input type="hidden" name="search" value="1"> <% //검색을 위한 장치 기본값은 0을 주고 그냥 검색어에 공백이고 검색버튼을 누른경우 1을 줌-세션초기화? %> 
		<input type="submit"value="검색">
	</form>
	<hr>
	<div>
	<c:forEach var="g" items="${list }">
		<div class="goods">
			<img src="img/${g.fname }" width="150" height="150"><br>
			${g.no}<br> 
			${g.name }<br>
			${g.price }<br>
		</div>
	</c:forEach>
	</div>
	<br>
	
	<div id="line"></div>	
	<br>
	<br>
	<br>
	<br>
	<div id="page">
		${pageStr}
	</div>
	
	
	<!-- 
	<div>
		<c:forEach var="g" items="${list }">
			<div class="goods">
				<img  src="image/${g.fname }" width="50" height="50"><br>
				${g.name }<br>
				${g.price }				
			</div>
		</c:forEach>
	</div>
	<div id="line"></div>
	<br>
	<br>
	<br>
	<div id="page">
		${pageStr }
	</div>
	 -->
	<div id="btn">
	<a href="insertGoods.do">상품등록</a>
	<a href="listGoods.do?search=1&keyword=''">전체목록</a>
	</div>
	<input type="hidden" name="h_type" value="${ type}">
	<input type="hidden" name="h_op" value="${ op}">
	<input type="hidden" name="h_keyword" value="${ keyword}">
	<input type="hidden" name="h_colName" value="${ colName}">
</body>
</html>