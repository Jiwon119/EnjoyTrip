<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="text-center">
		<h1 >비밀번호 찾기</h1>
		<form action="/Member" method="get">
			<input type="hidden" name="action" value="searchPass"> <br> 아이디 <input
				type="text" name="id" placeholder="아이디를 입력하세요.."><br> <br> 이메일 <input
				type="email" name="email" placeholder="이메일을 입력하세요."><br>
			<br>
			<input type="submit" value="비밀번호 찾기">
		</form>
		<a href="/member/login.jsp">뒤로</a>

	</div>

	<%@ include file="/include/footer.jsp"%>