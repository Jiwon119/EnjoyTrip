<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<%@ include file="/include/head.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-5">
		<h1 class="text-center">회원가입</h1>
		
		<form action="/Member" method="post">
			<input type="hidden" name="action" value="regist">

			<div class="mb-3">
				<label id="id" class="form-label">아이디</label>
				<input type="text" class="form-control" name="id" placeholder="아이디를 입력하세요..">
			</div>
			<div class="mb-3">
				<label id="password" class="form-label">비밀번호</label>
				<input type="password" class="form-control" name="password" placeholder="패스워드를 입력하세요..">
			</div>
			<div class="mb-3">
				<label id="age" class="form-label">나이</label>
				<input type="number" class="form-control" name="age" placeholder="나이를 입력하세요..">
			</div>
			<div class="mb-3">
				<label id="email" class="form-label">이메일</label>
				<input type="email" class="form-control" name="email" placeholder="이메일을 입력하세요..">
			</div>
			<div class="mb-3">
				<label id="address" class="form-label">주소</label>
				<input type="text" class="form-control" name="address" placeholder="아이디를 입력하세요..">
			</div>

			<br> <br> <button class="btn btn-outline-primary " type="submit">회원가입</button>
		</form>
	</div>
	<%@ include file="/include/footer.jsp"%>