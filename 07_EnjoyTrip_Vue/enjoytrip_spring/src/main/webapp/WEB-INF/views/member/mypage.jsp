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
		<h3>수정, 조회, 탈퇴</h3>
		<div>
			<%
				MemberDto myInfo = (MemberDto) session.getAttribute("mypage");
			%>
			<%
				if (myInfo != null) {
			%>
			<table class="table" border="1">
				<tr>
					<td>아이디 :</td>
					<td><%=myInfo.getId()%></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><%=myInfo.getAge()%></td>
				</tr>
				<tr>
					<td>이메</td>
					<td><%=myInfo.getEmail()%></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><%=myInfo.getAddress()%></td>
				</tr>
			</table>
			<%
				}
			%>
			<a href="/member/update.jsp">수정</a> <a href="/Member?action=delete">탈퇴</a>

		</div>

	</div>

	<%@ include file="/include/footer.jsp"%>