<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="${ctx}/resources/images/favicon.ico">

<title>조리법 등록</title>

<!-- Bootstrap core CSS -->
<link href="${ctx}/resources/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${ctx}/resources/css/jumbotron-narrow.css" rel="stylesheet">
</head>

<body>

	<div class="container">
		<div class="header">
			<ul class="nav nav-pills pull-right">
				<li class="active"><a href="${ctx}/main">Home</a></li>
			</ul>
			<h3 class="text-muted">Cookbook</h3>
		</div>

		<div class="jumbotron">
			<h1>조리법 등록</h1>
			<form action="${ctx}/recipe/add" method="POST" enctype="multipart/form-data">
					<table id="table" border="1" >
						<tr>
							<td>조리명</td>
							<td><input type="text" class="text" name="name" /></td>
						</tr>
						<tr>
							<td>재료</td>
							<td><textarea class="textarea" name="ingredients"></textarea></td>
						</tr>
						<tr>
							<td>조리과정</td>
							<td><textarea class="textarea" name="procedure"></textarea></td>
						</tr>
						<tr>
							<td>요리사진</td>
							<td><input type="file" class="image" name="imageFile" /></td>
						</tr>
					</table>
					<input id="submit" type="submit" class="btn btn-primary btn-lg btn-block" value="등록" />
			</form>
		</div>

		<div class="footer">
			<p>&copy; Company 2013</p>
		</div>
	</div>
</body>
</html>