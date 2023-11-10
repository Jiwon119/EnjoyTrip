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
		<h1>회원 정보 수정</h1>
		<div>
			<%
				MemberDto myInfo = (MemberDto) session.getAttribute("mypage");
			%>
			<%
				if (myInfo != null) {
			%>
			<form action="/Member" method="post">
				<input type="hidden" name="action" value="update"> <br>아이디<input
					type="text" name="id" value="<%=myInfo.getId()%>" readonly><br>
				<br>비밀번호<input type="password" name="password"
					placeholder="변경할 비밀번호를 입력하세요."><br> <br>나이<input
					type="number" name="age" value="<%=myInfo.getAge()%>"><br>
				<br>이메일<input type="email" name="email"
					value="<%=myInfo.getEmail()%>"><br> <br>주소<input
					type="text" name="address" value="<%=myInfo.getAddress()%>"><br>
				<br>
				<input type="submit" value="수정">
			</form>
			<%
				}
			%>
		</div>

	</div>

	<%@ include file="/include/footer.jsp"%>