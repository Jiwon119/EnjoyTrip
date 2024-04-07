<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<div class="container p-5">
		<h3 class="text-center">로그인 / 로그아웃 / 비밀번호 찾기</h3>
		<br><br>
		
		<h4 class="text-center">로그인</h4>
		<form action="/Member" method="post">
			<input type="hidden" name="action" value="login">
			<div class="mb-3">
				<label for="id" class="form-label">아이디</label> <input type="text"
					class="form-control" name="id">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">비밀번호</label> <input
					type="password" class="form-control" name="password">
			</div>
			<br> <br> <button class="btn btn-outline-primary" type="submit">로그인</button>
			<a href="/member/searchpass.jsp"style="margin-left:50px;">비밀번호 찾기</a>
		</form>

		<!-- 	<input type="hidden" name="action" value="login">
	<br>아이디
	<input type="text" name="id">
	<br>
	<br>비밀번호
	<input type="password" name="password">
	<br>
	<br>
	<input type="submit" value="로그인">
	<br>
	<a href="/member/searchpass.jsp">비밀번호 찾기</a>
	 -->
	</div>
	<%@ include file="/include/footer.jsp"%>