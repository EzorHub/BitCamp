<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>��ǰ���</h2>
<hr>
<form action="insertGoods.do" method="post" enctype="multipart/form-data">
��ǰ��: <input type="text" name="name"><br>
����: <input type="text" name="price"><br>
����: <input type="text" name="qty"><br>
����: <input type="file" name="upload"><br>
<input type="submit" value="���">
</form>
</body>
</html>