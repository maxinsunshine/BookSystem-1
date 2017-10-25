<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>图书列表页</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css"
	type="text/css" media="screen" />

<style type="text/css">
span {
	font-color: red;
}
</style>

</head>

<body>
		<div class="art-block">
				<div class="art-block-body">
					<div class="art-blockheader">
						<div class="l"></div>
						<div class="r"></div>
						<div>
						<span class="art-logo-text">查询图书</span>
						</div>
					</div>
					<div class="art-blockcontent">
						<div class="art-blockcontent-tl"></div>
						<div class="art-blockcontent-tr"></div>
						<div class="art-blockcontent-bl"></div>
						<div class="art-blockcontent-br"></div>
						<div class="art-blockcontent-tc"></div>
						<div class="art-blockcontent-bc"></div>
						<div class="art-blockcontent-cl"></div>
						<div class="art-blockcontent-cr"></div>
							<!-- block-content -->
							<div align="center" valign="center">
								<form method="post" id="newsletterform"
									action="${pageContext.request.contextPath}/books/searchBooks">
									<input type="text" placeholder="请输入书名或图书编号查询" value="" name="searchName" id="searchName"
										style="width: 35%;" /> <span class="art-button-wrapper">
										<span class="l"> </span> <span class="r"> </span> <input
										class="art-button" type="submit" name="search" value="查询" />
									</span>

								</form>
							</div>
					</div>
				</div>
			</div>
			<div id="art-main">
			<div class="art-sheet">
			<div class="art-sheet-tl"></div>
			<div class="art-sheet-tr"></div>
			<div class="art-sheet-bl"></div>
			<div class="art-sheet-br"></div>
			<div class="art-sheet-tc"></div>
			<div class="art-sheet-bc"></div>
			<div class="art-sheet-cl"></div>
			<div class="art-sheet-cr"></div>
			<div class="art-sheet-cc"></div>
			<div class="art-sheet-body">
				<div class="art-header">
					<div></div>
					<div></div>
					<div class="art-logo">
						<h1 id="name-text" class="art-logo-name">
							<a href="#">图书列表页</a>
						</h1>
						<div id="slogan-text" class="art-logo-text"><a href="${pageContext.request.contextPath}">返回首页</a></div>
					</div>
			</div>
			</div>
			</div>
			<c:if test="${not empty list}">
			<table align="center" valign="center" border="3px"  style="border-collapse:separate; border-spacing:30px 20px;">
						<tr>
						<td align="center" valign="center">书名</td>
						<td align="center" valign="center">价格</td>
						<td align="center" valign="center">类型</td>
						<td align="center" valign="center">描述</td>
						<td colspan="6" align="center" valign="center">操作</td>
							</tr>
							
							<c:forEach items="${list }" var="book">
							<tr >
							<td>${book.booksname}</td>
							<td>￥${book.booksprice}</td>
							<td>${book.bookscategory}</td>
							<td>${book.description}</td>
							<td><a href="${pageContext.request.contextPath}/books/toAddBooks">新增</a></td>
							<td><a href="${pageContext.request.contextPath}/books/toEditBooks?id=${book.booksid}">编辑</a></td>
							<td><a href="${pageContext.request.contextPath}/books/deleteBooks?id=${book.booksid }">删除</a></td>
							</tr>
							</c:forEach>
							
						
			</table>
			</c:if>
			
			<c:if test="${empty list}">
			<div class="art-header">
					<div></div>
					<div></div>
					<div class="art-logo">
						<h1 id="name-text" class="art-logo-name">
							对不起，无对应的图书数据
						</h1>
					</div>
			</div>
			
			</c:if>
</body>
</html>
