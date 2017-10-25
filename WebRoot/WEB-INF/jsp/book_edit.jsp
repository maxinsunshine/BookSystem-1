<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-1.9.0.min.js"></script>
<script>
$(document).ready(function (){
	$("#sub").click(function (){
		var book =$("#BookInfo").serializeArray(); 
		var str = JSON.stringify(book);
		alert(str);
			$.post("editBook",book,function(tip){
				if(tip=='succeed'){
				 window.location = "bookList";
				}else{
					alert("修改失败");
				}
			});
	});
});
</script>
</head>
<body>
<h2>修改图书</h2>
<form id="BookInfo" action="" method="post">
<table>
	<tr>
		<td>书名</td><td>价格</td><td>图书描述</td>
	</tr>
	<tr>
		<td style="display: none;"><input name="id" value="${book.booksid }" type="text"></td>
		<td><input name="booksname" value="${book.booksname}" type="text"></td>
		<td><input name="booksprice" value="${book.booksprice}" type="text"></td>
		<td><input name="description" value="${book.description}" type="text"></td>
		
	</tr>
	<tr align="center">
		<td colspan="4"><input id="sub" type="button" value="提交"></td>
	</tr>
</table>
</form>
</body>
</html>