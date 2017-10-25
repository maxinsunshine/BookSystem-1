<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>图书管理系统</title>

<link rel="stylesheet"
	href="http://localhost:8090/BookSystem/css/style.css"
	type="text/css" media="screen" />
<!--[if IE 6]><link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.ie6.css" type="text/css" media="screen" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.ie7.css" type="text/css" media="screen" /><![endif]-->

<script src="http://localhost:8090/BookSystem/js/jquery-1.9.0.min.js"></script>

<script>
function check() {
		var username = document.getElementById("username");
		var password = document.getElementById("password");
		
		//非空操作
		var reg = /^\s*$/; //代表0个或多个空白符
		
		if (reg.test(username)) {
			document.getElementById("username").innerHTML=("用户名 不能为空");
			return false;
		}
		if (reg.test(password)) {
			document.getElementById("password").innerHTML=("密码不能为空");
			return false;
		}
		return true;
	};
function checkForm(){

		if(check()){
			return true;
		}
		return false;
}

</script>

<script type="text/javascript">
	var focus_width = 632;
	var focus_height = 320;
	var picPath;
	var linkUrl = "";
	var swfPath = "http://localhost:8090/BookSystem/images/adImage.swf";
	var sp = "|";
	var banners = new Array("images/screen1.jpg", "images/screen2.jpg",
			"images/screen3.jpg", "images/screen4.jpg", "images/screen5.jpg",
			"images/screen6.jpg");
	var links = new Array("#", "#", "#", "#", "#", "#");

	for ( var i = 0; i < banners.length; i++) {
		if (i == banners.length - 1) {
			sp = "";
		}
		picPath += banners[i] + sp;
		var index = picPath.indexOf("undefined");
		if (index != -1) {
			picPath = picPath.substr(index + 9, picPath.length);
		}
		linkUrl += links[i] + sp;
	}

	window.onload = function() {

		var usernamevalue = "${cookie.saveusername.value}"; //从cookie中获取saveusername值,得到的是utf-8码

		//alert(usernamevalue);

		document.getElementById("username").value = window.decodeURIComponent(
				usernamevalue, "utf-8");
		//通过decodeURIComponent这个函数完成utf-8解码操作.
	}
</script>
</head>
<body>
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
					<div class="art-header-png"></div>
					<div class="art-header-jpeg"></div>
					<div class="art-logo">
						<h1 id="name-text" class="art-logo-name">
							<a href="#">图书管理系统</a>
						</h1>
						<div id="slogan-text" class="art-logo-text">书中自有黄金屋</div>
					</div>
				</div>
				<div class="art-nav">
					<div class="l"></div>
					<div class="r"></div>
					<ul class="art-menu">
						<li><a href="#" class="active"><span class="l"></span><span
								class="r"></span><span class="t">主页</span> </a>
						</li>
						<!--<li><a href="#"><span class="l"></span><span class="r">**</span><span
								class="t"></span> </a></li>
						<li><a href="#"><span class="l"></span><span class="r"></span><span
								class="t"></span> </a>
						</li>
						--><li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</li>
						<li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</li>
						
						<li>
						<span class="l"></span><font color="red">
						<c:if test="${empty user }">
							<li>用户未登录</li>
						</c:if>

						<c:if test="${not empty user }">
							<li>当前用户:${user.username}</li>
							<li><a
								href='${pageContext.request.contextPath}/indexs/logout'>注销</a>
							</li>
						</c:if>
						</font><span
								class="t"></span>
						</li>

					</ul>
				</div>
				<div class="art-content-layout">
					<div class="art-content-layout-row">
						<div class="art-layout-cell art-content">
							<div class="art-post">
								<div class="art-post-tl"></div>
								<div class="art-post-tr"></div>
								<div class="art-post-bl"></div>
								<div class="art-post-br"></div>
								<div class="art-post-tc"></div>
								<div class="art-post-bc"></div>
								<div class="art-post-cl"></div>
								<div class="art-post-cr"></div>
								<div class="art-post-cc"></div>
								<div class="art-post-body">
									<div class="art-post-inner art-article">
										<div class="art-postmetadataheader">
											<h2 class="art-postheader">热门图书信息</h2>
										</div>
										<div class="art-postcontent">
											<!-- article-content -->
											<script type="text/javascript" src="http://localhost:8090/BookSystem/js/mutilpleFlash.js"></script>
											<!-- /article-content -->
										</div>
										<div class="cleared"></div>
									</div>

									<div class="cleared"></div>
								</div>
							</div>

							<div class="art-post">
								<div class="art-post-tl"></div>
								<div class="art-post-tr"></div>
								<div class="art-post-bl"></div>
								<div class="art-post-br"></div>
								<div class="art-post-tc"></div>
								<div class="art-post-bc"></div>
								<div class="art-post-cl"></div>
								<div class="art-post-cr"></div>
								<div class="art-post-cc"></div>
								<div class="art-post-body">
									<div class="art-post-inner art-article">
										<div class="art-postmetadataheader">
											<h2 class="art-postheader">图书信息</h2>
										</div>
										<div class="art-postcontent">
											<!-- article-content -->
											<p>
												<span class="art-button-wrapper"> <span class="l">
												</span> <span class="r"> </span> <a class="art-button"
													href="${pageContext.request.contextPath}/books/booksAll">查看更多...</a> </span>
											</p>

											<div class="cleared"></div>


											<div class="art-content-layout overview-table">



												<div class="art-content-layout-row">
													<c:forEach items="${list}" var="book" varStatus="vs">
														<div class="art-layout-cell">
															<div class="overview-table-inner">
																<h4>${book.booksname }</h4>
																<img
																	src="${pageContext.request.contextPath}/${book.booksimgurl}"
																	width="55px" height="55px" alt="an image" class="image" />
																<p>价格: ￥${book.booksprice }</p>
																<!--<p>
																	<a
																		href='${pageContext.request.contextPath}/product?method=findById&id=${p.id}'>速速抢购</a>
																</p>
															--></div>
														</div>
														<!-- end cell -->

														<c:if test="${vs.count%4==0}">
												</div>
												<!-- end row -->
												<div class="art-content-layout-row">
													</c:if>

													</c:forEach>
												</div>
												<!-- end row -->

											</div>
											<!-- end table -->

											<!-- /article-content -->
										</div>
										<div class="cleared"></div>
									</div>

									<div class="cleared"></div>
								</div>
							</div>
						</div>
						<div class="art-layout-cell art-sidebar1">
							<div class="art-vmenublock">
								<div class="art-vmenublock-body">
									<div class="art-vmenublockheader">
										<div class="l"></div>
										<div class="r"></div>
										<div class="t">导航菜单</div>
									</div>
									<div class="art-vmenublockcontent">
										<div class="art-vmenublockcontent-tl"></div>
										<div class="art-vmenublockcontent-tr"></div>
										<div class="art-vmenublockcontent-bl"></div>
										<div class="art-vmenublockcontent-br"></div>
										<div class="art-vmenublockcontent-tc"></div>
										<div class="art-vmenublockcontent-bc"></div>
										<div class="art-vmenublockcontent-cl"></div>
										<div class="art-vmenublockcontent-cr"></div>
										<div class="art-vmenublockcontent-cc"></div>
										<div class="art-vmenublockcontent-body">
											<!-- block-content -->
											<ul class="art-vmenu">
												<li><a
													href="${pageContext.request.contextPath}"><span
														class="l"></span><span class="r"></span><span class="t">主页</span>
												</a>
												</li>
												<li><a
													href="${pageContext.request.contextPath}/users/usersList"><span
														class="l"></span><span class="r"></span><span class="t">用户管理</span>
												</a>
												</li>
												<li><a
													href="${pageContext.request.contextPath}"><span
														class="l"></span><span class="r"></span><span class="t">借阅查询</span>
												</a>
												</li>
											</ul>
											<!-- /block-content -->

											<div class="cleared"></div>
										</div>
									</div>
									<div class="cleared"></div>
								</div>
							</div>
							<div class="art-block">
								<div class="art-block-body">
									<div class="art-blockheader">
										<div class="l"></div>
										<div class="r"></div>
										<div class="t">用户登陆</div>
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
										<div class="art-blockcontent-cc"></div>
										<div class="art-blockcontent-body">
											<!-- block-content -->
											<div>
												<form method="post" id="loginForm"
													action="${pageContext.request.contextPath}/indexs/login" onsubmit="return checkForm();">
													<table>
														<tr>
															<td colspan="2"><font color='red'>${requestScope["login.message"]
																	}</font>
															</td>
														</tr>
														<tr>
															<td>用户</td>
															<td><input type="text" value="" name="username"
																id="username" /><br /></td>
														</tr>
														<tr>
															<td>密码</td>
															<td><input type="password" value="" name="password"
																id="password" /></td>
														</tr>
														<!--<tr>
															<td colspan="2"><input type="checkbox"
																name="remember" value="on" />记住用户 <input
																type="checkbox" name="autologin" value="on" />自动登陆</td>
														</tr>
														--><tr>
															<td colspan="2"><span class="art-button-wrapper">
																	<span class="l"> </span> <span class="r"> </span> <input
																	class="art-button" type="submit" name="loginbtn"
																	value="登陆" /> </span> &nbsp;&nbsp;&nbsp;<a
																href='http://localhost:8090/BookSystem/regist.jsp'>注册</a>
															</td>
													</table>
												</form>
											</div>
											<!-- /block-content -->

											<div class="cleared"></div>
										</div>
									</div>
									<div class="cleared"></div>
								</div>
							</div>
							<div class="art-block">
								<div class="art-block-body">
									<div class="art-blockheader">
										<div class="l"></div>
										<div class="r"></div>
										<div class="t">图书搜索</div>
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
										<div class="art-blockcontent-cc"></div>
										<div class="art-blockcontent-body">
											<!-- block-content -->
											<div>
												<form method="get" id="newsletterform"
													action="javascript:void(0)">
													<input type="text" value="" name="email" id="s"
														style="width: 95%;" /> <span class="art-button-wrapper">
														<span class="l"> </span> <span class="r"> </span> <input
														class="art-button" type="submit" name="search" value="查询" />
													</span>

												</form>
											</div>
											<!-- /block-content -->

											<div class="cleared"></div>
										</div>
									</div>
									<div class="cleared"></div>
								</div>
							</div>

							<div class="art-block">
								<div class="art-block-body">
									<div class="art-blockheader">
										<div class="l"></div>
										<div class="r"></div>
										<div class="t">联系信息</div>
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
										<div class="art-blockcontent-cc"></div>
										<div class="art-blockcontent-body">
											<!-- block-content -->
											<div>
												<img src="http://localhost:8090/BookSystem/images/contact.jpg" alt="an image"
													style="margin: 0 auto;display:block;width:95%" /> <br />
												<b>公司信息</b><br /> 图书系统<br /> 电子邮箱: <a
													href="mailto:yuyang@itcast.cn">duhong@itcast.cn</a><br />
												<br /> 电话: (010)51552112 <br /> 传真: (010)51552110
											</div>
											<!-- /block-content -->

											<div class="cleared"></div>
										</div>
									</div>
									<div class="cleared"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="cleared"></div>
				<div class="art-footer">
					<div class="art-footer-t"></div>
					<div class="art-footer-l"></div>
					<div class="art-footer-b"></div>
					<div class="art-footer-r"></div>
					<div class="art-footer-body">
						<a href="#" class="art-rss-tag-icon" title="RSS"></a>
						<div class="art-footer-text">
							<p>
								<a href="#">关于我们</a> | <a href="#">联系我们</a> | <a href="#">人才招聘</a>
								| <a href="#">商家入驻</a><br /> 版权 &#169; 2012 ---. ***版权.
							</p>
						</div>
						<div class="cleared"></div>
					</div>
				</div>
				<div class="cleared"></div>
			</div>
		</div>
		<div class="cleared"></div>
	</div>

</body>
</html>
