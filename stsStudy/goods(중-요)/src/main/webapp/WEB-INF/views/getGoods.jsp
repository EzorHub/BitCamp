<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>상품상세</h2>
<hr>
상품번호: <input type="text" readonly="readonly" name="no" value="${g.no }"><br>
상품명: <input type="text" readonly="readonly" value="${g.name }"><br>
가격: <input type="text" readonly="readonly" value="${g.price}"><br>
수량: <input type="text" readonly="readonly" value="${g.qty }"><br>
파일명:<br>
 <img src="img/${g.fname }" width="100" height="100"> <br>

<hr>

<a href="listGoods.do">목록</a>
<a>답글</a>
<a>수정</a>
<a>삭제</a>
</body>
</html>