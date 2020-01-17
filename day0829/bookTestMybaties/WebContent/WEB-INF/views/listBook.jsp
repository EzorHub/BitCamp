<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
<script type="text/javascript">
	$(function() {
		$("#op").hide();
		
		$(".col").click(function () {
			var cname = $(this).attr("cname");
			location.href="listBook.do?colName="+cname;
		});
		
		
		var h_type = $("#h_type").val();
		$("#type").val( h_type );		
		
		if(h_type=='price'){
			$("#op").show();
		}else{
			$("#op").hide();
		}
		
		$("#op").val( $("#h_op").val() );
		
		if( $("#h_keyword").val() == '' ){
			$("#type").val("bookname");
			$("#op").val("=");
		}
		
		
		$("#col").change(function() {
			var v = $(this).val();
			if (v == 'price') {
				$("#op").show();
			} else {
				$("#op").hide();
			}
		});
	});
</script>
</head>
<body>
	<h2>도서목록</h2>
	<hr>
	<form action="listBook.do" method="post">
		<select name="type" id="col">
			<option value="bookname">도서명</option>
			<option value="price">가격</option>
		</select> <select id="op" name="op">
			<option value=">=">>=</option>
			<option value="=">=</option>
			<option value="<="><=</option>
		</select> <input type="text" name="keyword" value="${keyword }"> 
		<input type="submit" value="검색">
	</form>
	<hr>
	<table width="100%">
		<tr>
			<td class="col" cname="bookid">번호</td>			
			<td class="col" cname="bookname">도서명</td>			
			<td class="col" cname="price">가격</td>					
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.bookid }</td>
				<td>${b.bookname }</td>
				<td>${b.price }</td>
			</tr>
		</c:forEach>
	</table>
	<input type="hidden" id="h_type" value="${type }">
	<input type="hidden" id="h_op" value="${op }">
	<input type="hidden" id="h_keyword" value="${keyword }">
	<input type="hidden" id="h_col" value="${col }">
	<!--  <br><a href="listBook.do?type=${null}">전체목록</a> -->

</body>
</html>