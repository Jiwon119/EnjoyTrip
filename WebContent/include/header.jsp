<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:if test="${not empty msg }">
	<script>
		alert("${msg}")
	</script>
</c:if>
<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light shadow">
		<div class="container">
			<a class="navbar-brand text-primary fw-bold" href="${root}/index.jsp"> <img
				src="${root}/assets/img/logo.png" alt="" width="120"/>
			</a>
			<div class="collapse navbar-collapse justify-content-end"
				id="navbarSupportedContent">
				<ul class="navbar-nav mb-2 me-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="trip.html">지역별관광지</a></li>
				</ul>
				<!-- 로그인 전 -->
				<c:if test="${empty loginUser }">
					<div id="befLogin" class="navbar-nav mb-2 me-2 mb-lg-0">
						<div class="nav-item">
							<a class="nav-link" href="${root}/member?action=registForm">회원가입</a>
						</div>
						<div class="nav-item">
							<a class="nav-link" href="${root}/member?action=loginForm">로그인</a>
						</div>
					</div>
				</c:if>

				<!-- 로그인 후 -->
				<c:if test="${not empty loginUser }">
					<div id="aftLogin" class="navbar-nav mb-2 me-2 mb-lg-0">
						<div class="nav-item">
							<a class="nav-link" href="${root}/member?action=logout">로그아웃</a>
						</div>
						<div class="nav-item">
							<a class="nav-link" href="${root}/member?action=mypage">마이페이지</a>
						</div>
					</div>
				</c:if>

			</div>
		</div>
	</nav>
</header>