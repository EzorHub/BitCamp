<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스투더 상세보기</title>
<style type="text/css">

body {
	margin-left: 20%;
	margin-right: 10%;
}

img {
	width: 500px;
	height: 300px;
}

#sector1 {
	margin-left: 5%;
	margin-right: 10%;
	
	display: grid;
	grid-template-rows: 300px;
	grid-template-columns: 500px 500px;
	grid-gap: 100px;
}

#sector2 {
	margin-left: 5%;
	margin-right: 10%;
	
	display: grid;
	grid-template-rows: 100px;
	grid-template-columns: 400px 300px 400px;
	grid-gap: 100px;
}

#sector3 {
	margin-left: 5%;
	margin-right: 10%;
}

.detail {
	font-size: 11px;
}

.textarea {
	border: 1px solid ;
	width: 900px;
	height: 200px;
}

</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
<!--btn class 처리-->
	$(function() {
		$("#btn").click(function() {
			$(location).attr("href", "listStd.jsp");
		});
	});
</script>
</head>
<body>
	<h3 align="left">스투더 상세보기</h3>
	<hr><br>
	
	<div id="sector1">
		<div style="border-radius:5px; border: 1px solid black;" align="center">
		</div>
		<div>
			<h3>스투더명</h3>
			<p style="font-size: 15px; color='#666666'">스투더 한줄 소개</p>
			<br>
			<p class="detail">스투더 기간</p>
			<p class="detail">스투더 시간</p>
			<p class="detail">스투더 장소</p>
			<p class="detail">스투더 정원</p>
			<p class="detail">스투더 개설자(닉네임)</p>
		</div>
	</div>
	
	<br>
	
	<div id="sector2">
		<div>
			<h4>해시태그</h4>
			<p style="font-size: 13px; color='#666666'">#지역,#지역,#주제,#주제</p>
		</div>
		<div></div>
		<div>
		현재 신청자수____  <button>신청가능여부</button>
		</div>
	</div>
	
	<br>
	
	<div id="sector3">
		<h4>스투더 내용</h4>
		<div class="textarea"></div>
		<br>
		<h4>스투더 개설자 간략 소개</h4>
		<div class="textarea"></div>	
	</div>
	
	<br>
	<div align="center"><button id="btn" style="width: 100px; height: 30px; font-size: 15px;">목록</button></div>

</body>
</html>