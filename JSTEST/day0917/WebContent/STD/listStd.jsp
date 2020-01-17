<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스투더 목록</title>
<style type="text/css">
body {
	margin-left: 20%;
	margin-right: 10%;
}

img {
	width: 400px;
	height: 200px;
}

select {
	width: 350px;
	height: 35px;
}

#sector1 {
	text-align: right;
}

#sector2 {
	margin-left: 5%;
	margin-right: 10%;
}

#sector3 {
	margin-left: 5%;
	margin-right: 10%;
}

#keyword {
	width: 300px;
	height: 30px;
}

#search {
	width: 80px;
	height: 30px;
}

.std {
	display: grid;
	grid-template-rows: 200px;
	grid-template-columns: 900px 100px;
	grid-gap: 100px;
}

.studer {
	display: grid;
	grid-gap: 5px;
	grid-template-rows: 200px;
	grid-template-columns: 400px 500px;
	text-align: center;
	font-size: 12pt;
	margin-right: 0px;
}

.studer>div {
	border: 1px solid black;
}

.btn {
	width: 80px;
	height: 30px;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
<!--시/군/구 콤보박스 (sector1)-->
	$('document')
			.ready(
					function() {
						var area0 = [ "시/도 선택", "서울특별시", "인천광역시", "대전광역시",
								"광주광역시", "대구광역시", "울산광역시", "부산광역시", "경기도",
								"강원도", "충청북도", "충청남도", "전라북도", "전라남도", "경상북도",
								"경상남도", "제주도" ];
						var area1 = [ "강남구", "강동구", "강북구", "강서구", "관악구", "광진구",
								"구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구",
								"마포구", "서대문구", "서초구", "성동구", "성북구", "송파구",
								"양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구" ];
						var area2 = [ "계양구", "남구", "남동구", "동구", "부평구", "서구",
								"연수구", "중구", "강화군", "옹진군" ];
						var area3 = [ "대덕구", "동구", "서구", "유성구", "중구" ];
						var area4 = [ "광산구", "남구", "동구", "북구", "서구" ];
						var area5 = [ "남구", "달서구", "동구", "북구", "서구", "수성구",
								"중구", "달성군" ];
						var area6 = [ "남구", "동구", "북구", "중구", "울주군" ];
						var area7 = [ "강서구", "금정구", "남구", "동구", "동래구", "부산진구",
								"북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구",
								"중구", "해운대구", "기장군" ];
						var area8 = [ "고양시", "과천시", "광명시", "광주시", "구리시", "군포시",
								"김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시",
								"시흥시", "안산시", "안성시", "안양시", "양주시", "오산시",
								"용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시",
								"포천시", "하남시", "화성시", "가평군", "양평군", "여주군", "연천군" ];
						var area9 = [ "강릉시", "동해시", "삼척시", "속초시", "원주시", "춘천시",
								"태백시", "고성군", "양구군", "양양군", "영월군", "인제군",
								"정선군", "철원군", "평창군", "홍천군", "화천군", "횡성군" ];
						var area10 = [ "제천시", "청주시", "충주시", "괴산군", "단양군",
								"보은군", "영동군", "옥천군", "음성군", "증평군", "진천군", "청원군" ];
						var area11 = [ "계룡시", "공주시", "논산시", "보령시", "서산시",
								"아산시", "천안시", "금산군", "당진군", "부여군", "서천군",
								"연기군", "예산군", "청양군", "태안군", "홍성군" ];
						var area12 = [ "군산시", "김제시", "남원시", "익산시", "전주시",
								"정읍시", "고창군", "무주군", "부안군", "순창군", "완주군",
								"임실군", "장수군", "진안군" ];
						var area13 = [ "광양시", "나주시", "목포시", "순천시", "여수시",
								"강진군", "고흥군", "곡성군", "구례군", "담양군", "무안군",
								"보성군", "신안군", "영광군", "영암군", "완도군", "장성군",
								"장흥군", "진도군", "함평군", "해남군", "화순군" ];
						var area14 = [ "경산시", "경주시", "구미시", "김천시", "문경시",
								"상주시", "안동시", "영주시", "영천시", "포항시", "고령군",
								"군위군", "봉화군", "성주군", "영덕군", "영양군", "예천군",
								"울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군" ];
						var area15 = [ "거제시", "김해시", "마산시", "밀양시", "사천시",
								"양산시", "진주시", "진해시", "창원시", "통영시", "거창군",
								"고성군", "남해군", "산청군", "의령군", "창녕군", "하동군",
								"함안군", "함양군", "합천군" ];
						var area16 = [ "서귀포시", "제주시", "남제주군", "북제주군" ];

						// 시/도 선택 박스 초기화

						$("select[name^=sido]")
								.each(
										function() {
											$selsido = $(this);
											$
													.each(
															eval(area0),
															function() {
																$selsido
																		.append("<option value='"+this+"'>"
																				+ this
																				+ "</option>");
															});
											$selsido
													.next()
													.append(
															"<option value=''>구/군 선택</option>");
										});

						// 시/도 선택시 구/군 설정

						$("select[name^=sido]")
								.change(
										function() {
											var area = "area"
													+ $("option", $(this))
															.index(
																	$(
																			"option:selected",
																			$(this))); // 선택지역의 구군 Array
											var $gugun = $(this).next(); // 선택영역 군구 객체
											$("option", $gugun).remove(); // 구군 초기화

											if (area == "area0")
												$gugun
														.append("<option value=''>구/군 선택</option>");
											else {
												$
														.each(
																eval(area),
																function() {
																	$gugun
																			.append("<option value='"+this+"'>"
																					+ this
																					+ "</option>");
																});
											}
										});

					});
</script>
<script type="text/javascript">
<!--검색 키워드(sector2)-->
	$(document).ready(function() {
		var arrKey1 = [ "#전체 최다 키워드" ];
		var arrKey2 = [ "#인기키워드1", "#인기키워드2", "#인기키워드3", "#인기키워드4" ];
		var arrKey3 = [ "#지역키워드1", "#지역키워드2", "#지역키워드3", "#지역키워드4" ];

		var allKey = [];
		var allKey_F = [];

		function randomSize(min, max) {
			return Math.floor(Math.random() * (max - min + 1)) + min;
		}

		function shuffle(arr) {
			if (arr instanceof Array) {
				var len = arr.length;
				if (len == 1)
					return arr;
				var i = len * 2;
				while (i > 0) {
					var idx1 = Math.floor(Math.random() * len);
					var idx2 = Math.floor(Math.random() * len);
					if (idx1 == idx2)
						continue;
					var temp = arr[idx1];
					arr[idx1] = arr[idx2];
					arr[idx2] = temp;
					i--;
				}
			} else {
				alert("No Array Object");
			}
			return arr;
		}

		$.each(arrKey1, function(idx, k) {
			var span = $("<span></span>").html(k);
			$(span).css({
				color : "#FF9999",
				'font-size' : function() {
					var s = randomSize(30, 40);
					return s;
				}
			});
			allKey.push(span);
		});

		$.each(arrKey2, function(idx, k) {
			var span = $("<span></span>").html(k);
			$(span).css({
				color : "#6699CC",
				'font-size' : function() {
					var s = randomSize(15, 25);
					return s;
				}
			});
			allKey.push(span);
		});

		$.each(arrKey3, function(idx, k) {
			var span = $("<span></span>").html(k);
			$(span).css({
				color : "#FFCC33",
				'font-size' : function() {
					var s = randomSize(15, 25);
					return s;
				}
			});
			allKey.push(span);
		});

		allKey = shuffle(allKey);

		$.each(allKey, function(idx, k) {
			$(k).css("padding", function() {
				var s = randomSize(30, 140);
				return s;
			});
			$("#sector2").append(k);
		});

		$("#keyword").click(function() {
			$("#keyword").val("");
		});

	});
</script>
<script type="text/javascript">
<!--스투더 목록(sector3)-->
	$(document)
			.ready(
					function() {
						var std1 = {
							std_no : 1,
							std_image : 'cafe_img01.png',
							std_name : '미국 갬성의 소유자 Jenny의 스터디발판딛고 회화실력 up!',
							std_intro : '영어를 체득하는 것이 목표인 스터디입니다!',
							std_start : '2019-07-20',
							std_end : '2019-11-20',
							std_time : '(토) 13:00-15:00',
							std_loc : '대구-동성로',
							std_close : '2019-07-17',
							limit : 6,
							std_content : '평상시에는 정확히 알기 힘들었던 비슷한 단어들의 다른 뉘앙스,재미있는 생활 표현들기호 등에 대해 우리 함께 배워봐요! 시험공부같은 영어가 아니라 영어와 관련된 재미있는 배경 지식들과 유쾌한 주제들을 가지고 자유롭고 즐거운 이야기를 나눠볼 거에요!',
							std_hits : null,
							founder_info : '안녕하세요!저는 impatient 한 사람이에요. but, in the good way :)',
							founder_no : 1
						};

						var std2 = {
							std_no : 2,
							std_image : 'cafe_img02.png',
							std_name : '폰카로 배우는 초기초 사진반 : 근대갬성 편',
							std_intro : '조선 말 근대 갬성이 남아 있는 개항로를 거닐며 나만의 사진을 찍고, 메시지를 담는 방법을 배웁니다.',
							std_start : '2019-08-20',
							std_end : '2019-12-20',
							std_time : "(토) 13:00-15:00",
							std_loc : '대구-동성로',
							std_close : '2019-07-17',
							limit : 6,
							std_content : '영상 촬영, 편집은 정말 아무것도 할 줄 모르고 뭐 어디서 듣기로는 스마트폰 하나로 시작할 수 있다는데 어디서부터 뭘 어떻게 시작해야할지 몰라서 답답하신 분들을 위해 다른 장비나 노트북, 컴퓨터 필요없이 스마트폰 하나로 브이로그 촬영, 편집 할 수 있는 팁과 노하우를 공유 드리려고 해요!',
							std_hits : null,
							founder_info : '개설자 경력 1) 2017년 단체전 출전 : 나이트스캐이프 야경 사진 전시회 2) 2019년 단체전 출전 : 인천주민 : 인천을 줌인하다 展 3) 프리랜서 웨딩스냅 작가로 활동중',
							founder_no : 2
						};

						var std3 = {
							std_no : 3,
							std_image : 'cafe_img03.png',
							std_name : '영상 편집 1도 모르는 사람도 유튜브 시작할 수 있어요!!',
							std_intro : '스마트폰 하나로 브이로그 촬영, 편집 노하우 및 팁 ',
							std_start : '2019-09-18',
							std_end : '2020-01-18',
							std_time : '(월, 수) 13:00-15:00',
							std_loc : '강원도-원주',
							std_close : '2019-08-17',
							limit : 6,
							std_content : '조고든 - 더모임 [사이드 프로젝트 - 유튜브] 진행 예정 - 현) 유튜버 & 프리랜서 마케터 & N잡러널',
							std_hits : null,
							founder_info : '안녕하세요!저는 impatient 한 사람이에요. but, in the good way :)',
							founder_no : 3
						};

						var arr = [ std1, std2, std3 ];

						var str = "";
						for (var i = 0; i < arr.length; i++) {
							var s = arr[i];
							str += "<h4>" + s.std_name + "</h4>";
							str += "<div class='std'><div class='studer'>";
							str += "<div><img src='"+s.std_image+"'></div>";
							str += "<div><br>위치 : " + s.std_loc
									+ "<br> 시작 및 종료일 : " + s.std_start + " ~ "
									+ s.std_end + "<br> 모집 마감일 : "
									+ s.std_close + "<br> 모집 정원 : " + s.limit
									+ "명<br></div></div>";
							str += "<div><br><br><a><button class='btn'>참여하기</button></a></div></div>";
						}
						str += "<br>";
						$('#sector3').html(str);
					});
</script>
<script type="text/javascript">
<!--btn class 처리-->
	$(function() {
		$(".btn").click(function() {
			$(location).attr("href", "detailStd.jsp");
		});
	});
</script>

</head>
<body>
	<h3 align="left">스투더 목록</h3>
	<hr>

	<div id="sector1">
		<font> 지역 </font> <select name="sido1" id="sido1"></select> <select
			name="gugun1" id="gugun1"></select> <br> <br> <font>
			스투더 </font> <input type="text" id="keyword" value="스투더명, 관심키워드"> <br>
		<br> <input type="submit" id="search" value="검색">
	</div>
	<br>

	<div id="sector2"></div>
	<br>
	<br>
	<div id="sector3"></div>
	<br>
	<div id="paging" class="paging mt50" align="center">
		<a href="#none">&lt;&lt;</a> <a class="on" href="#none">1</a> <a
			href="#none">2</a> <a href="#none">3</a> <a href="#none">4</a> <a
			href="#none">5</a> <a href="#none">&gt;&gt;</a>
	</div>

</body>
</html>