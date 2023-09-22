<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<div class="col-6 mx-auto">
		<div class="display-6 m-5 mb-5 text-center" role="alert">내 정보</div>

		<form>
			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="info-id"
					placeholder="ID" readonly /> <label for="floatingInput">ID</label>
			</div>

			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="info-email"
					placeholder="E-mail" /> <label for="floatingInput">E-mail</label>
			</div>

			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="info-nickname"
					placeholder="Nickname" /> <label for="floatingInput">Nickname</label>
			</div>


			<div class="form-floating mb-3">
				<input type="password" class="form-control" id="info-password"
					placeholder="Password" /> <label for="floatingPassword">Password</label>
			</div>

			<div class="form-floating mb-3">
				<input type="password" class="form-control" id="info-password-check"
					placeholder="Password" /> <label for="floatingPassword">Password
					Check</label>
			</div>


			<button class="btn btn-outline-dark w-100 py-2 mb-3" type="button"
				onclick="update()">수정</button>
			<button class="btn btn-outline-dark w-100 py-2 mb-3" type="button"
				onclick="location.href='index.html'">취소</button>
		</form>
	</div>
	<script>
		const user = JSON.parse(window.localStorage.getItem("user"));
		document.getElementById("info-id").value = user.id;
		document.getElementById("info-email").value = user.email;
		document.getElementById("info-nickname").value = user.nickname;
	</script>
	<script src="./js/main.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>


	<%@ include file="/include/footer.jsp"%>