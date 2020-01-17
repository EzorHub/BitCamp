<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function pro(id) {
	re = confirm("정말로 선택한 도서를 삭제하시겠습니까?");
	if(re==true){
		location.href="deleteBook.do?bookid="+id;
	}
}
</script>
</head>
<body>
<h2>도서상세</h2>
<hr>

도서번호: ${b.bookid }<br>
도서명: ${b.bookname }<br>
출판사: ${b.publisher }<br>
가격: ${b.price }<br>
<a href="updateBook.do?bookid=${b.bookid }">수정</a>
<a href="#" onclick="pro(${b.bookid})">삭제</a>
<a href="listBook.do">목록</a>
</body>
</html>