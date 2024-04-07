
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.member.model.mapper.MemberDto"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
		<%
			MemberDto searchResult = (MemberDto) request.getAttribute("searchPass");
		%>
		<%
				if (searchResult != null) {
			%>
		<form action="/Member" method="post">
			<input type="hidden" name="action" value="modify"> <br>아이디<input
				type="text" name="id" value="<%=searchResult.getId()%>" readonly><br>
			<br>비밀번호<input type="password" name="password"
				placeholder="변경할 비밀번호를 입력하세요."><br> <br>나이<input
				type="number" name="age" value="<%=searchResult.getAge()%>"><br>
			<br>이메일<input type="email" name="email"
				value="<%=searchResult.getEmail()%>"><br> <br>주소<input
				type="text" name="address" value="<%=searchResult.getAddress()%>"><br>
			<br> <input type="submit" value="수정">
		</form>
		<%
			} else {
		%>
		<h1>비밀번호 찾기 를 실패하였습니다.</h1>
		<%
			}
		%>
		<a href="/">홈으로</a>

	</div>

	<%@ include file="/include/footer.jsp"%>