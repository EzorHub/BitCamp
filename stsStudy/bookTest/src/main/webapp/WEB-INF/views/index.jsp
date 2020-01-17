<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {

		var listBook = function() {
			//$("#tb").empty();
			$("#tb").html("");

			$.ajax({
				url : "listBook.json",
				success : function(r) {
					var arr = eval("(" + r + ")"); //==getJSON 이란 함수도있음
					$.each(arr, function(idx, b) { //책한권의속성만큼 td만드는 반복문
						var tr = $("<tr></tr>");
						var td1 = $("<td></td>").html(b.bookid);
						var td2 = $("<td></td>").html(b.bookname);
						var td3 = $("<td></td>").html(b.publisher);
						var td4 = $("<td></td>").html(b.price);
						$(tr).append(td1, td2, td3, td4);
						$("#tb").append(tr);
					});
				}
			});

		}
		listBook();//함수호출

		$("#btnInsert").click(function() {

			/*
			입력양식을 감싸고 있는 레이어 - 보통은 form
			seirialize - 직렬화(순서가 있는 형태) {bookid:10,bookname:'jsp',publisher:'bitcamp',price:1000}
			
			$.ajax({url:"",data:data,success:function(r){}});			

			$.ajax({
				url:"insertBook.do",
				data:data,
				success:function(r){
					reqMapping에 의해 데이터가 잘 오는지, vo 확인!

					}});			
			 */

			//var data = "bookid='"+$("#bookid").val()+"'&bookname='축구의역사'&publisher='굿스포츠'&price=''";
			//var data = $("#F").serialize(); //쿼리스트링
			var data = $("#F").serializeArray(); //객체
			/* $.ajax({
					url:"insertBook.do",
					data:data,
					success:function(r){
						alert(r);

						
				});
			 */

			//				 $.post("",d,function(){});

			 $.post("insertBook.do",data,function(r){
					alert(r);
				});
				setTimer(listBook,3000);
			/* $.post("insertBook.do", data, function(r) {
				alert(r);
			});

			listBook(); //변경된 후에도 적용할라고 함수가져옴
 */
		});
	});
</script>
</head>
<body>

	<h2>도서등록</h2>
	<hr>



	<form id="F">

		도서번호: <input type="text" name="bookid"><br> 도서명: <input
			type="text" name="bookname"><br> 출판사: <input
			type="text" name="publisher"><br> 가격: <input
			type="text" name="price"><br>
		<button id="btnInsert">등록</button>
		<!-- <input type="submit">  onsubmit -->
	</form>
	<h2>도서목록</h2>
	<hr>

	<button id="btnList">목록</button>


	<table class="table table-hover" id="bookTB" width="100%">
		<thead>
			<tr>
				<td>도서번호</td>
				<td>도서명</td>
				<td>출판사</td>
				<td>가격</td>
			</tr>
		</thead>
		<tbody id="tb"></tbody>

	</table>
	<br>

</body>
</html>