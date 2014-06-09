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

<title>조리법 - ${recipe.name}</title>

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
		<h1>${recipe.name}</h1>
		<a class="deleteBtn" href="${ctx}/recipe/${recipe.name}/delete">삭제하기</a>

		<br /> <img id="showImg" src="${ctx}/recipe/${recipe.name}/image" />
		</div>
		
		<h2>재료</h2>
		<ul>
			<c:forEach var="recipeName" items="${recipe.ingredients}">
				<li>${recipeName}</li>
			</c:forEach>
		</ul>

		<h2>조리과정</h2>
		<ul>
			<li>${recipe.procedure}</li>
		</ul>

		<div class="footer">
			<p>&copy; Company 2013</p>
		</div>
	</div>
</body>
</html>