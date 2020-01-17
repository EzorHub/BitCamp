<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#delete").click(function () {
			var re = confirm("정말로 삭제할까요?");			
			if(re==true){
				
			var no = $("#no").val();
			
			location.href="deleteBoard.do?no="+no;
		}
		});
	});
</script>
</head>
<body>
<h2>게시물 상세</h2>
<hr>
<input type="hidden" id="no" value="${b.no }">
<input type="hidden" id="pwd" value="${b.pwd }">
<form action="listBoard.do">
	글번호 : <input type="text" value="${b.no }" readonly="readonly"><br>
	제목 : <input type="text" value="${b.title }" readonly="readonly"><br>
	작성자 : <input type="text" value="${b.writer }" readonly="readonly"><br>
	내용 :<br><textarea rows="10" cols="20">${b.content }</textarea><br>
	조회수 : <input type="text" value="${b.hit }" readonly="readonly"><br>
	작성일: <input type="text" value="${b.regdate }" readonly="readonly"><br>
	ip: <input type="text" value="${b.ip }" readonly="readonly"><br>
	<img src="files/${b.fname }" width="100" height="100"><br>
<input type="submit" value="목록">
</form>
<!-- 
<form action="updateBoard.do">
<input type="hidden" name="no"><br>
<input type="submit" value="수정">
</form>
 -->
<hr>
<a href="insertBoard.do?no=${b.no }">답글작성</a>
<a href="updateBoard.do?no=${b.no }">수정</a>
<a href="#" id = "delete">삭제</a>
</body>
</html>