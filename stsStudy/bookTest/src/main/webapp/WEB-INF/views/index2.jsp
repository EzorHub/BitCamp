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
	$(function() {
			var tr;
			var td1, td2, td3, td4;
			var bookid;

		
		/* $(".booktr").click(function(){
			var bookid = $(this).$(td1).val();
			alert("bookid: "+bookid);

			}); */

		
		$("#btnList").click(function() {
			$.ajax({
				url : "listBook.json",
				success : function(result) {
					var arr = eval("(" + result + ")");

					$.each(arr, function(idx, b) {
						tr = $("<tr id='booktr'></tr>");

						td1 = $("<td id='bookid'></td>").html(b.bookid);
						td2 = $("<td></td>").html(b.bookname);
						td3 = $("<td></td>").html(b.publisher);
						td4 = $("<td></td>").html(b.price);

						$(tr).append(td1, td2, td3, td4);
						$("#bookTB").append(tr);
						
					});

				}

			});

		});
		

		$(document).on("click","#booktr", function() {
			   bookid = $(this).find("td").html();
			   //var bookid= tds.td[0].html();
			  /*  
			   $.each(tds, function(idx, item){
					

				   });
			   var str= $("tr:eq(1)").text();
			   var bookid = str.substring(0, 1);
			   alert("bookid: "+bookid);
 */
			   $.ajax({
					url : "listBuyer.json?bookid="+bookid+"",
					success : function(result) {
						var arr = eval("(" + result + ")");

						$.each(arr, function(idx, c) {
							tr = $("<tr></tr>");

							td1 = $("<td></td>").html(c.custid);
							td2 = $("<td></td>").html(c.name);
							td3 = $("<td></td>").html(c.address);
							td4 = $("<td></td>").html(c.phone);

							$(tr).append(td1, td2, td3, td4);
							$("#custTB").append(tr);
							
							
							
						});

					}

				});
			});
	});
</script>
</head>
<body>

	<h2>도서목록</h2>
	<hr>

	<button id="btnList">목록</button>

	<table class="table table-hover" id="bookTB" width="100%">
		<tr>
			<td>도서번호</td>
			<td>도서명</td>
			<td>출판사</td>
			<td>가격</td>
		</tr>
	</table>
	<br>
	<h2>고객</h2>
	<hr>

	

	<table class="table table-hover" id="custTB" width="100%">
		<tr>
			<td>고객번호</td>
			<td>고객명</td>
			<td>주소</td>
			<td>전화번호</td>
		</tr>
	</table>


</body>
</html>