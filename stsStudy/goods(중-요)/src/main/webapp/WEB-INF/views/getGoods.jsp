<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>��ǰ��</h2>
<hr>
��ǰ��ȣ: <input type="text" readonly="readonly" name="no" value="${g.no }"><br>
��ǰ��: <input type="text" readonly="readonly" value="${g.name }"><br>
����: <input type="text" readonly="readonly" value="${g.price}"><br>
����: <input type="text" readonly="readonly" value="${g.qty }"><br>
���ϸ�:<br>
 <img src="img/${g.fname }" width="100" height="100"> <br>

<hr>

<a href="listGoods.do">���</a>
<a>���</a>
<a>����</a>
<a>����</a>
</body>
</html>