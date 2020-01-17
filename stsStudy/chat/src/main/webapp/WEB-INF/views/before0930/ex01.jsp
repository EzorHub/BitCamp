<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link rel="stylesheet" href="jqueryUI/themes/dark-hive/jquery-ui.css">
<title>제이쿼리 플러그인 연습_ex01</title>
<style type="text/css">
#title_name, #title_date {
	background-color: #3b5c31;
	color: #ffffff;
}
body {
	//font-size: 62.5%;
	font-size: 70%;
}

h1 {
	text-align: center;
}

input[type=text], label {
	margin-bottom: 12px;
	padding: .4em;
	width: 95%;
}
</style>


<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
<script type="text/javascript" src="jqueryUI/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
			var tr;
			var td1, td2;
		function list(){	


			//------------------------------------
		$("#sTB").empty();
         tr1 = $("<tr id='title_name'></tr>");
         var td = $("<td id='title_name' style='font-size:20px''></td>").html("일정이름");
         var td0 = $("<td id='title_loc' style='font-size:20px''></td>").html("일정날짜");
      
         $(tr1).append(td,td0);
         $("#parkTB").append(tr1);   
			
			//------------------------------------
					
			$.getJSON("listSchedule", function(data){
				//$(tr).empty();
				$.each(data, function(idx, item){
					
					//tr = $("<tr></tr>").attr("idx", idx);
					tr = $("<tr></tr>");
					td1 = $("<td></td>").html(item.evt_name);
					td2 = $("<td></td>").html(item.evt_date);

					$(tr).append(td1, td2);
					$("#sTB").append(tr);
					
					});
				});
			};

		list();
		
		$("#dialog").dialog({
			buttons : {
				submit : function() {
					var data = $("#dialog").serialize(); //쿼리스트링 serializeArray는 객체
					$.ajax({
						url : "insertSchedule",
						type : "POST",
						data : data,
						success : function(r) {
//							list().empty();
							list();
							$("input").val("");
							
						}
					});
				},
				reset : function() {
					
				},
				cancel : function() {
					
				}
			},
			modal:true
		//modal:false
		});
		$("#evt_date").datepicker();
	});
</script>
</head>
<body>

	<form id="dialog" title="일정등록">
		<!-- 플러그인에서 title속성 요구? -->
		<h1>일정등록</h1>
		<label for="evt_name">일정이름</label>
		<!-- html5, 라벨사용권장 -->
		<input type="text" name="evt_name" id="evt_name"><br> 
		<label for="evt_date">날 짜</label>
		<!-- html5, 라벨사용권장 -->
		<input type="text" name="evt_date" id="evt_date">
	</form>
	
	 <table id="sTB" width="100%" class="table table-hover"></table> 

</body>
</html>