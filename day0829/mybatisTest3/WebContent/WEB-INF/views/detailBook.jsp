<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>암호 - 제이쿼리방식</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>

<script type="text/javascript">
	$(function () {
		$("#delBook").click(function() {
			re = confirm("정말로 삭제하시겠습니까?");
			if(re==true){
				var bookid = $("#bookid").val();
				location.href="deleteBook.do?bookid="+bookid;
			}
		});
	});
</script>

</head>
<body>
<h2>도서상세</h2>
<hr>
<input type="hidden" value="${b.bookid }" id="bookid">
도서번호: ${b.bookid }<br>
도서명: ${b.bookname }<br>
출판사: ${b.publisher }<br>
가격: ${b.price }<br>
<a href="updateBook.do?bookid=${b.bookid }">수정</a>
<a href="#" id="delBook" >삭제</a>
<a href="listBook.do">목록</a>
</body>
</html>