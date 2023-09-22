<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp"%>
</head>
<style>
</style>
<body>
	<%@ include file="/include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container" id="index">
		<!-- section -->
		<div class="container-fluid pt-3">
			<div class="row justify-content-around">
				<!-- 메인 좌측 (여행지 선택) -->
				<div
					class="col-10 col-lg-7 position-relative overflow-hidden p-3 m-1 text-center">
					<div class="col-md-8 mx-auto my-5">
						<h1>여행지를 선택하세요</h1>
						<div class="mt-5 text-center">
							<img style="width: 300px" src="./assets/undraw_trip_re_f724.svg"/>
						</div>
						<form action="" method="post">
							<input type="hidden" value="indexToMap"/>
							<!-- 지역 선택 -->
							<div class="input-group m-3" style="min-width: 200px">
								<span class="input-group-text"
									style="width: 50px; background-color: #001e3d"> <i
									class="bi bi-geo-alt-fill m-auto" style="color: white"></i>
								</span> <select name="index-search-area" id="index-search-area" class="form-select me-2"
									aria-label="Default select example"
									style="background-color: #e6e6e6">
									<option value="0" selected>검색 할 지역 선택</option>
								</select>
							</div>
							
							<!-- 관광지 유형 선택 -->
							<div class="input-group m-3" style="min-width: 200px">
								<span class="input-group-text"
									style="width: 50px; background-color: #001e3d"> <i
									class="bi bi-geo-alt-fill m-auto" style="color: white"></i>
								</span> 
								<select name="index-search-content" id="index-search-content-id" class="form-select me-2"
									style="background-color: #e6e6e6">
									<option value="0" selected>관광지 유형</option>
									<option value="12" title="관광지">관광지</option>
									<option value="14">문화시설</option>
									<option value="15">축제공연행사</option>
									<option value="25">여행코스</option>
									<option value="28">레포츠</option>
									<option value="32">숙박</option>
									<option value="38">쇼핑</option>
									<option value="39">음식점</option>
								</select>
							</div>
							
							<!-- 검색어 입력-->
							<div class="input-group m-3" style="min-width: 200px">
								<span class="input-group-text"
									style="width: 50px; background-color: #001e3d"> <i
									class="bi bi-geo-alt-fill m-auto" style="color: white"></i>
								</span> 
								<input name="index-search-keyword" id="index-search-keyword" class="form-control me-2"
									style="background-color: #e6e6e6" type="search"
									placeholder="검색어" aria-label="검색어" />
							</div>

							<button class="btn btn-outline-dark mx-auto mt-3" type="button"
								id="index-search-btn">
								<i class="bi bi-search"></i> 검색
							</button>
						</form>
					</div>
				</div>
				<%-- 로그인 부분
				<!-- 회원 정보 (로그인 전) -->
				<div
					class="col-2 position-relative overflow-hidden text-center pt-3 m-1"
					style="min-width: 500px; display: block" id="login-form">
					<div class="row p-5 m-2">
						<form>
							<h1 class="h3 mb-3 fw-normal">로그인</h1>
							<div class="form-floating mb-3">
								<input type="text" class="form-control" id="login-id"
									placeholder="ID" /> <label for="floatingInput">ID</label>
							</div>
							<div class="form-floating">
								<input type="password" class="form-control" id="login-password"
									placeholder="Password" /> <label for="floatingPassword">Password</label>
							</div>

							<div class="form-check text-start my-3">
								<input class="form-check-input" type="checkbox"
									value="remember-me" id="flexCheckDefault" /> <label
									class="form-check-label" for="flexCheckDefault">
									Remember me </label>
							</div>

							<button class="btn btn-outline-dark w-100 py-2 mb-3"
								type="button" onclick="login()">로그인</button>

							<button type="button"
								class="btn btn-outline-dark w-100 py-2 mb-3"
								data-bs-toggle="modal" data-bs-target="#signUp"
								data-bs-whatever="@mdo">회원가입</button>

							<button type="button" class="btn btn-outline-dark w-100 py-2"
								data-bs-toggle="modal" data-bs-target="#findPW"
								data-bs-whatever="@mdo">비밀번호 찾기</button>

							<!-- 회원가입 모달창 -->
							<div class="modal fade" id="signUp" tabindex="-1"
								aria-labelledby="signUpLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h1 class="modal-title fs-5" id="signUpLabel">회원가입</h1>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
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
											<button type="button" class="btn btn-primary"
												onclick="regist()">Join</button>
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
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
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
											<button type="button" class="btn btn-primary"
												onclick="findPW()">입력</button>
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
--%>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		document.querySelector("#index-search-btn").addEventListener("click", () =>  {
			location.href="./enjoyTrip?action=map";
		});
	</script>
	<%@ include file="/include/footer.jsp"%>