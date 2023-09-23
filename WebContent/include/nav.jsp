<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-dark sticky-top border-bottom"
	data-bs-theme="dark">
	<div class="container">
		<a class="navbar-brand" href="${root}/index.jsp">Enjoy Trip</a>
		<div class="offcanvas offcanvas-end" tabindex="-1" id="#offcanvas"
			aria-labelledby="#offcanvasLabel">
			<div class="offcanvas-body ms-5">
				<ul class="navbar-nav flex-grow-1 justify-content-between">
					<li class="nav-item ms-5"><a class="nav-link" href="${root}/enjoyTrip?action=map">지도</a></li>
					<li class="nav-item"><a class="nav-link" href="${root}/article?action=list">게시판</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Features</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Enterprise</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${root}/user/mypage.jsp">유저</a></li>
					<li class="nav-item"><a class="nav-link" href="${root}/user/login.jsp">로그인</a></li>
				</ul>
			</div>
		</div>
	</div>
</nav>