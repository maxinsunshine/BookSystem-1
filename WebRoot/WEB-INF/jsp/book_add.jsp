<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
<script>

</script>
</head>
<body>
<h2>新增图书</h2>
<form action="addBook" method="post">
<table>
	<tr>
		<td>书名</td><td>价格</td><td>描述</td><td>图书类型</td>
	</tr>
	<tr>
		<td><input name="bookName" type="text"></td>
		<td><input name="author" type="text"></td>
		<td><input name="price" type="text"></td>
		<td>
			<select name="bookTypeInfo.id">
			<c:forEach  items="${list}" var="bookType">
				<option value="${bookType}">${bookType}</option>
			</c:forEach>
			</select>
		</td>
	</tr>
	<tr align="center">
		<td colspan="4"><input type="submit" value="提交"></td>
	</tr>
</table>
</form>
</body>
</html>