<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2 {
	text-align: left;
}

table, td {
	text-align: left;
	border: 1px solid grey;
	border-collapse: collapse;
	/*  width: 60%;*/
	/* height: 0px;
	margin: auto;	 */
	margin-left: 30%;
	margin-right: 30%;
	font-size: 10pt;
	font-weight: bold;
	/* position: relative; */
}

* {
	text-align: center;
	margin: 2px;
}

.title_box {
	margin-left: 270px;
	margin-right: 270px;
	border: 1px solid white;
	font-weight: bold;
	color: grey;
	font-size: 11.5pt;
	padding: 3px;
}

.polisy_box, .cafe_info_box {
	margin: 10px;
}

#img {
	width: 250px;
	height: 250px;
	border: 1px solid black;
}

input {
	margin: 1px;
	text-align: left;
	border: 1px solid white;
}

#txt, .btn {
	
}

input.img_btn {
	background: url("add.png") no-repeat;
	border: none;
	width: 23px;
	height: 23px;
	cursor: pointer; 
	text-align: right;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function () {
		<!-- append, animation처리-->
		
		
		/*추후에 tr로 append하는 걸로 변경하기*/
		//var td = $("<td></td>");
		$("#addPass").click(function () {
			var tr = $("<tr></tr>");
			var td = $("<td></td>");
			var str = "";
			str += "이용권명&nbsp;&nbsp;"
			str +="input type='text' placeholder='ex) @시간이용권'>"
			$(td).html(str);
			$(tr).append(td);
			$("#addPass_tb").append(tr);
			
			str = "";
			str +="이용권 가격&nbsp;&nbsp;";
			str +="<input type='text' placeholder='1700'>"
			$(td).html(str);
			$(tr).append(td);
			
			$("#addPass_tb").append(tr);
				
				
		});
	});
	$(function () {
		$("#addRoom").click(function () {
			alert("눌림")
		});
	});
	$(function () {
		$("#addRoomTime").click(function () {
			alert("눌림")
		});
	});
</script>
</head>
<body>



	<h2>신규 카페 등록</h2>
	<hr>


	<br>
	<table width="50%" border="1">
		<tr>
			<td width="-30%" rowspan="7"><div id="img">
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br> <input type="image" value="대표이미지">
					<!-- 버튼나오는거 보기싫어서 file 임시대체함 -->
				</div></td>
		</tr>
		<tr>
			<td colspan="2"><input type="text" placeholder="카페명"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="text" placeholder="카페 한줄 소개">
			</td>
		</tr>
		<tr>
			<td width="20%">위치</td>
			<td width="*"><input type="text" placeholder="ex) 서울시 마포구 백범로"></td>
		</tr>
		<tr>
			<td width="20%">전화번호</td>
			<td width="*"><input type="text" placeholder="ex) 02-2644-2655"></td>
		</tr>
		<tr>
			<td width="20%">운영시간</td>
			<td width="*"><input type="text" placeholder="ex) 09:00 ~ 24:00"></td>
		</tr>
		<tr>
			<td width="20%">좌석수</td>
			<td width="*"><input type="text" placeholder="ex) 124석"></td>
		</tr>
	</table>
	<br>
	<table class="addPass_tb" width="50%">
		<tr>
			<td>이용권명&nbsp;&nbsp; <input type="text" placeholder="ex) @시간이용권">
			</td>
			<td>이용권 가격&nbsp;&nbsp; <input type="text" placeholder="1700"></td>
			<td><input type="button" class="img_btn" id="addPass"></td>			
		</tr>
		<!-- 스크립트를 통해 버튼 눌리면 자동생성 처리 -->
		
	</table>
	<br>
	<table class="addRoom_tb" width="50%">
		<tr>
			<td colspan="2">룸&nbsp;명 &nbsp;&nbsp;&nbsp; <input type="text" placeholder="ex) Room 4 - 6~8">	
			</td>			
			<td><input type="button" class="img_btn" id="addRoom"></td>			
		</tr>
		<!-- 스크립트를 통해 버튼 눌리면 자동생성 처리 -->
		
	</table>
	<br>
	<table class="addRoomTime_tb" width="50%">
		<tr>
			<td>룸시간 설정&nbsp;&nbsp; <input type="text" placeholder="09:00 ~ 10:00">
			</td>
			<td>시간당 금액&nbsp;&nbsp; <input type="text" placeholder="1700"></td>
			<td><input type="button" class="img_btn" id="addRoomTime"></td>			
		</tr>
		
		
	</table>
	<br>
	<div class="title_box">카페설명</div>
	<div class="cafe_info_box">
		<textarea id="txt" rows="3" cols="80" placeholder="이용관련공지"></textarea>
	</div>

	<div class="cafe_info_box">
		<textarea id="txt" rows="5" cols="80" placeholder="카페시설이미지"></textarea>
	</div>

	<div class="cafe_info_box">
		<textarea id="txt" rows="4" cols="80" placeholder="업체정보"></textarea>
	</div>



	<div class="title_box">취소/환불규정</div>

	<div class="polisy_box">
		<textarea id="txt" rows="5" cols="80" placeholder="상품정보 제공고시"></textarea>
	</div>

	<div class="polisy_box">
		<textarea id="txt" rows="5" cols="80" placeholder="취소/환불 규정 안내"></textarea>
	</div>
	<br>


	<button id="btn" type="button">취소</button>
	<button type="submit">등록</button>

</body>
</html>