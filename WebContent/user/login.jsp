<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<!-- 회원 정보 (로그인 전) -->
	<div class="col-6 mx-auto">
		<div class="display-6 m-5 mb-5 text-center" role="alert">로그인</div>
			<form>
				<div class="form-floating mb-3">
					<input type="text" class="form-control" id="login-id"
						placeholder="ID" /> <label for="floatingInput">ID</label>
				</div>
				<div class="form-floating">
					<input type="password" class="form-control" id="login-password"
						placeholder="Password" /> <label for="floatingPassword">Password</label>
				</div>

				<div class="form-check text-start my-3">
					<input class="form-check-input" type="checkbox" value="remember-me"
						id="flexCheckDefault" /> <label class="form-check-label"
						for="flexCheckDefault"> Remember me </label>
				</div>

				<button class="btn btn-outline-dark w-100 py-2 mb-3" type="button"
					onclick="login()">로그인</button>

				<button type="button" class="btn btn-outline-dark w-100 py-2 mb-3"
					data-bs-toggle="modal" data-bs-target="#signUp"
					data-bs-whatever="@mdo">회원가입</button>

				<button type="button" class="btn btn-outline-dark w-100 py-2"
					data-bs-toggle="modal" data-bs-target="#findPW"
					data-bs-whatever="@mdo">비밀번호 찾기</button>
			</form>
		</div>


		<div class="row p-5 m-2">
			<form>
				<!-- 회원가입 모달창 -->
				<div class="modal fade" id="signUp" tabindex="-1"
					aria-labelledby="signUpLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h1 class="modal-title fs-5" id="signUpLabel">회원가입</h1>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<form>
									<div class="mb-4">
										<input type="text" class="form-control" id="id"
											placeholder="아이디" required />
									</div>
									<div class="mb-4">
										<input type="email" class="form-control" id="email"
											placeholder="이메일" required />
									</div>
									<div class="mb-4">
										<input type="text" class="form-control" id="nickname"
											placeholder="닉네임" required />
									</div>
									<div class="mb-4">
										<input type="password" class="form-control" id="password"
											placeholder="비밀번호" required />
									</div>
									<div class="mb-4">
										<input type="password" class="form-control"
											id="password-check" placeholder="비밀번호 확인" required />
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary" onclick="regist()">Join</button>
							</div>
						</div>
					</div>
				</div>

				<!-- 비밀번호 수정 -->
				<div class="modal fade" id="findPW" tabindex="-1"
					aria-labelledby="findPWLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h1 class="modal-title fs-5" id="findPWLabel">비밀번호 찾기</h1>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<form>
									<div class="mb-4">
										<input type="text" class="form-control" id="find_id"
											placeholder="아이디" required />
									</div>
									<div class="mb-4">
										<input type="email" class="form-control" id="find_email"
											placeholder="이메일" required />
									</div>
								</form>
							</div>
							<div id="find_btn" class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">닫기</button>
								<button type="button" class="btn btn-primary" onclick="findPW()">입력</button>
							</div>

							<!-- 수정 부분 -->
							<div id="updateID" style="display: none">
								<div class="modal-body">
									<div class="mb-4">
										<input type="password" class="form-control"
											id="update-password" placeholder="비밀번호" required />
									</div>
									<div class="mb-4">
										<input type="password" class="form-control"
											id="update-password-check" placeholder="비밀번호 확인" required />
									</div>
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">닫기</button>
									<button type="button" class="btn btn-primary"
										onclick="updatePW()">수정</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<hr />
	</div>

	<!-- 회원 정보 (로그인 후) -->
	<div id="info-form"
		class="col-2 position-relative overflow-hidden text-center pt-3 m-1"
		style="min-width: 500px; display: none">
		<div class="row p-5 m-2">
			<h3 class="mb-3 fw-normal" id="hello-user"></h3>
			<button class="btn btn-outline-dark w-100 py-2 mb-3"
				onClick="location.href='mypage.html'">내 정보</button>

			<button type="button" class="btn btn-outline-dark w-100 py-2"
				data-bs-toggle="modal" data-bs-target="#exampleModal"
				data-bs-whatever="@mdo" onclick="logout()">로그아웃</button>
		</div>
		<hr />
	</div>

	<%@ include file="/include/footer.jsp"%>