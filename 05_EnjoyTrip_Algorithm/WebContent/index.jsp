<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY ENJOY TRIP</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<!-- 상단 haeder start -->
	<%@ include file="include/header.jsp"%>
	<!-- 상단 header end -->
	<!-- 중앙 content start -->
	<div class="container">
		<img src="${root}/assets/img/main_bg.png" class="img-fluid" />
	</div>
	<!-- 중앙 content end -->
	<!-- 하단 footer start -->	
	<%@ include file="include/footer.jsp"%>
	<!-- 하단 footer end -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>