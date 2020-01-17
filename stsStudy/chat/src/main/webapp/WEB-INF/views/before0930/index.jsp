<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
<script type="text/javascript">
$(function(){
	$("#write_form").submit(function(){
			/*insert하는 ajax*/
			var data = $(this).serialize();			
			//$.ajax({url:"",data:data,type="post"});
			$.post({url:"addMsg",data:data});			
		});

	/*단추누르는 것과 관계없이 메시지 업데이트*/
	setInterval(function(){
			var today = new Date().getTime();
			/* $.ajax({url:"",data:today,success:function(r){
				var arr = eval( "("+r+")" );				
				}}); */
			$.getJSON("getList",
					{today: new Date().getTime()},
					function(data){ //today: 매번 갱신-새로운요청임을 알림

					$("#output").empty();
					$.each(data,function(idx,c){
						var div = $("<div></div>");
						var h2 = $("<h2></h2>").html(c.name);
						var p = $("<p></p>").html(c.msg);
						$(div).append(h2,p);
						$("#output").append(div);
						});
					
				
				});
		},1000);	
});
</script>
</head>
<body>
<h2>채팅</h2>
<hr>
<form id="write_form">
<table>
<tr>
<td>닉네임</td>
<td><input type="text" name="name"></td>
</tr>
<td>메시지</td>
<td><textarea rows="3" cols="60" name="msg"></textarea> </td>
</table>
<br>
<input type="submit"  value="글쓰기">
</form>
<hr>
<div id="output">

</div>

</body>
</html>