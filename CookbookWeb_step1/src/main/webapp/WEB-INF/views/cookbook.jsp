<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>요리책</title>
</head>
<body>

<h1>${cookbook.name}</h1>

<h2>저자 : ${cookbook.writer}</h2>
<h2>조리법 목록</h2>
<ul>
	<c:forEach var="recipe" items="${cookbook.recipes}">
		<li>${recipe.name} [ <a href="${ctx}/recipe/${recipe.name}">상세보기</a> ]</li>
	</c:forEach>
</ul>

<a href="${ctx}/recipe/add">조리법 등록</a>

</body>
</html>