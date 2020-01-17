<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	var listBook = function()
	{
		//$("#tb").empty();
		$("#tb").html("");
		
		$.ajax({url:"listBook.json",success:function(r){
			var arr = eval("("+r+")");
			$.each(arr, function(idx, b){
				var tr = $("<tr></tr>");
				var td1 = $("<td></td>").html(b.bookid);
				var td2 = $("<td></td>").html(b.bookname);
				var td3 = $("<td></td>").html(b.publisher);
				var td4 = $("<td></td>").html(b.price);

				$(tr).append(td1,td2,td3,td4);

				$("#tb").append(tr);
			});
		}});
	}

	listBook();
	
	$("#btnInsert").click(function(){
		var d = $("#F").serializeArray();
		
		$.post("insertBook.do",d,function(r){
			alert(r);
		});
		setTimer(listBook,3000);
		
	});
});
</script>
</head>
<body>
	<form id="F">
		도서번호 : <input type="text" name="bookid"><br>
		도서명 : <input type="text" name="bookname"><br>
		출판사 : <input type="text" name="publisher"><br>
		가격 : <input type="text" name="price"><br>
		<button id="btnInsert">도서등록</button>
	</form>
	
	<h2>도서목록</h2>
	<table>
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
</body>
</html>
