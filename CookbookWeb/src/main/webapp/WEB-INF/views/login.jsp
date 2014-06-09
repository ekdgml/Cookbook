<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="${ctx}/resources/images/favicon.png">

    <title>로그인하기</title>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${ctx}/resources/css/signin.css" rel="stylesheet">
  </head>

  <body>
    <div class="container">

      <form class="form-signin" action="${ctx}/login" method="post">
        <h2 class="form-signin-heading">나무소리 Cookbook</h2>
        <input type="text" class="form-control" placeholder="User Id" name="userId" autofocus>
        <input type="password" class="form-control" placeholder="Password" name="password">
        <label class="checkbox">
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
      </form>

    </div>
  </body>
</html>
