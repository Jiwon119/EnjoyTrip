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

		<form action="${root }/member" method="post">
			<input type="hidden" name="action" value="update">

			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="info_id" name="info_id"
					placeholder="ID" value="${user.userId }" readonly /> <label
					for="floatingInput">ID</label>
			</div>

			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="info_email"
					name="info_email" placeholder="E-mail" value="${user.userEmail }" />
				<label for="floatingInput">E-mail</label>
			</div>

			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="info_name"
					name="info_name" placeholder="Name" value="${user.userName }" /> <label
					for="floatingInput">Name</label>
			</div>

			<div class="form-floating mb-3">
				<input type="password" class="form-control" id="info_password"
					name="info_password" placeholder="Password"
					value="${user.userPass }" /> <label for="floatingPassword">Password</label>
			</div>

			<div class="form-floating mb-3">
				<input type="password" class="form-control" id="info_password_check"
					name="info_password_check" placeholder="Password"
					value="${user.userPass }" /> <label for="floatingPassword">Password
					Check</label>
			</div>

			<div class="form-floating mb-3">
				<input type="date" class="form-control" id="info_birthday"
					name="info_birthday" placeholder="Birthday"
					value="${user.userBirth }" /> <label for="floatingInput">Birthday</label>
			</div>

			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="info_phone_number"
					name="info_phone_number" placeholder="PhoneNumber"
					value="${user.userPhone }" /> <label for="floatingInput">Phone
					Number</label>
			</div>

			<button class="btn btn-outline-dark w-100 py-2 mb-3" type="submit">수정</button>
			<button class="btn btn-outline-dark w-100 py-2 mb-3" type="button"
				onclick="location.href='../index.jsp'">취소</button>
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