<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

ul {
	
	text-align: center;
	overflow: hidden;
}


li {
	position:relative;
	display: inline-block;
	/* float: left; */
	list-style: none;
	padding: 10px;
	cursor: pointer;
}

#wrap {
	overflow: hidden;
}

.item {
	margin: 5px;
	padding: 5px;
	width: 300px;
	height: 150px;
	float: left;
	border-width: 3px;
	border-style: solid;
	border-color: red;
	border-radius: 10px;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
<script type="text/javascript">
	$(function() {
		/*pdf 91참고*/
		var itemsPerPage = 12;
		$.get("getTotalProduct", function(data) { //페이지번호 - data
			var totalItem = Number(data);
			var totalPage = Math.ceil(totalItem / itemsPerPage);
			for (var i = 1; i <= totalPage; i++) {
				var add = $("<li/>").html(i).attr("data-page", i);
				$(".paging_btn").append(add);

				$(add).click(function() {
					var nowPage = $(this).attr("data-page");
					getItems(nowPage, itemsPerPage);
				});
			}
		});
		function getItems(nowPage, itemsPerPage) {//화면당 보여줄 상품수
			/*에이작통신을 해서 응답한 데이터 수만큼 노드생성하여 wrap에 추가*/
			$("#wrap").empty();
			//nowPage와 perPage 변수처리
			//---------------------------------------------
			$.getJSON("getPagingProductList", {
				nowPage : nowPage,
				perPage : itemsPerPage
			}, function(data) {

				$.each(data, function(idx, item) {
					var div = $("<div></div>").addClass("item");
					var name = $("<h3></h3>").html(item.name);
					var fname = $("<img/>").attr({
						src : "img/" + item.fname,
						width : "50",
						height : "50"
					});
					var no = $("<p></p>").html(item.no);
					var price = $("<p></p>").html(item.price);
					var qty = $("<p></p>").html(item.qty);

					$(div).append(name, fname, no, price, qty);
					$("#wrap").append(div);

				});
			});

			//---------------------------------------------

		}

		getItems(1, itemsPerPage); //1페이지에 10개씩 보여주는 함수 호출

	});
</script>
</head>
<body>
	<h2>상품목록</h2>
	<hr>

	<div id="wrap"></div>
	<ul class="paging_btn"></ul>
</body>
</html>