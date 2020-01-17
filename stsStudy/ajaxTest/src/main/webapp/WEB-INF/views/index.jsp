<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript">
$(function(){

	$("#btnListGoods").click(function(){
		$.ajax({
			url:'listGoods.json',
			success:function(r){
				var arr = eval(  "("+r+")"   ); //객체화시켜줌
				
				 $.each(arr, function(idx, item){
					 var tr = $("<tr></tr>");
						var td1 = $("<td></td>").html(item.no);
						var td2 = $("<td></td>").html(item.name);
						var td3 = $("<td></td>").html(item.price);
						var td4 = $("<td></td>").html(item.qty);
						var img = $("<img/>").attr({
								src:"img/"+item.fname,
								width:'250',
								height:'250'
			
							});
						var td5 = $("<td></td>").append(img);
						$(tr).append(td1,td2,td3,td4,td5);
						$("#list").append(tr);
							 
					}) 


				
				

				
				
				}
				

			});
		});

	$("#btnJSON").click(function(){
		$.ajax({
			url:'member.do',
			success:function(r){
				var m = eval(  "("+r+")"  );
				var name = $("<h1></h1>").html(m.name); 
				var age = $("<p></p>").html(m.age); 
				
				$("#member").append(name,age);
				}
			});
		});

	$("#btn").click(function(){
		$.ajax({
			url:'bit.do',
			success:function(data){
				$("span").append(data);
				}
			});		
		});

	
});
</script>
</head>
<body>
<!-- eval, 객체화, 루프 -->
<table id="list">
<tr>
<td>상품번호</td>
<td>상품명</td>
<td>가격</td>
<td>수량</td>
<td>상품사진</td>
</tr>
</table>
<button id="btnListGoods">상품목록 불러오기</button>



<hr>


<div id="member"></div>
<button id="btnJSON">JSON type의 ajax요청</button>
<hr>

<h2>${title }</h2>
<br>
<br>
<br>
<br>
<br>
<br>
<input type="text"><br>
결과:<span id="span"></span><br>
<button id="btn">ajax통신</button>

</body>
</html>