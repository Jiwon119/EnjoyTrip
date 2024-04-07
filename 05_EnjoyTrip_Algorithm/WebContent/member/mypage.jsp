<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY PAGE</title>
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
					<h1>마이페이지</h1>
				</div>
				<form id="form-update" method="post">
					<input type="hidden" name="action" value="update">
					<div class="mb-3">
						<label for="user_name" class="form-label">이름</label> 
						<input type="text" class="form-control" id="user_name" name="userName"
							   value="${loginUser.getUserName()}" maxlength="20">
					</div>
					<div class="mb-3">
						<label for="user_email" class="form-label">이메일</label>
						<input type="text" class="form-control" id="user_email" name="userEmail"
							   value="${loginUser.getUserEmail()}" maxlength="40">
					</div>
					<button type="button" class="btn btn-primary" id="btn-update">정보 수정</button>
					<button type="button" class="btn btn-danger" id="btn-remove">회원 탈퇴</button>
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
</body>
<script>
	document.querySelector("#btn-update").addEventListener("click", function() {
		if (!document.querySelector("#user_name").value) {
			alert("이름 입력!!");
			return;
		} else if (!document.querySelector("#user_email").value) {
			alert("이메일 입력!!");
			return;
		} else {
			let form = document.querySelector("#form-update");
			form.setAttribute("action", "${root}/member");
			form.submit();
		}
	});
	
	document.querySelector("#btn-remove").addEventListener("click", function() {
		
		if(confirm("회원 정보가 영구히 삭제됩니다. 회원 탈퇴 하시겠습니까?")){
			location.href="${root}/member?action=remove";
		}
		
	});
</script>
</html>