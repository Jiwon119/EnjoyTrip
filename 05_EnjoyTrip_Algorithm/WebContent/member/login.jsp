<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<!-- 상단 haeder start -->
	<%@ include file="/include/header.jsp"%>
	<!-- 상단 header end -->
	<!-- 중앙 content start -->
	<div class="container">
		<div class="row">
			<div class="col"></div>
			<div class="col-6">
				<div class="m-5">
				<h1>로그인</h1>
				</div>
				<form id="form-login" method="post">
					<input type="hidden" name="action" value="login">
					<div class="mb-3">
						<label for="userid" class="form-label">아이디</label>
						<input type="text" class="form-control" id="userid" name="userId">
					</div>
					<div class="mb-3">
						<label for="userpwd" class="form-label">비밀번호</label>
						<input type="password" class="form-control" id="userpwd" name="userPass">
					</div>
					<button type="button" class="btn btn-primary" id="btn-login">로그인</button>
				</form>
			</div>
			<div class="col"></div>
		</div>
	</div>
	<!-- 중앙 content end -->
	<!-- 하단 footer start -->
	<%@ include file="/include/footer.jsp"%>
	<!-- 하단 footer end -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
	<script>
		document.querySelector("#btn-login").addEventListener("click",
		function() {
			if (!document.querySelector("#userid").value) {
				alert("아이디 입력!!");
				return;
			} else if (!document.querySelector("#userpwd").value) {
				alert("비밀번호 입력!!");
				return;
			} else {
				let form = document.querySelector("#form-login");
				form.setAttribute("action", "${root}/member");
				form.submit();
			}
		});
	</script>
</body>
</html>