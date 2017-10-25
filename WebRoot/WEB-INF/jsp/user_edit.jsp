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
<title>编辑会员信息页面</title>
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
<h2>编辑会员</h2>
<form id="UserInfo" action="" method="post">
<table>
	<tr>
		<td>会员名</td><td>昵称</td><td>邮箱</td><td>角色</td>
	</tr>
	<tr>
		<td style="display: none;"><input name="id" value="${user.id }" type="text"></td>
		<td><input name="username" value="${user.username}" type="text"></td>
		<td><input name="nickname" value="${user.nickname}" type="text"></td>
		<td><input name="email" value="${user.email}" type="text"></td>
		<td><c:if test="${user.role=='user'}">普通会员</c:if><c:if test="${user.role=='admin'}">超级管理员</c:if></td>
		
	</tr>
	<tr align="center">
		<td colspan="4"><input id="sub" type="button" value="提交"></td>
	</tr>
</table>
</form>
</body>
</html>