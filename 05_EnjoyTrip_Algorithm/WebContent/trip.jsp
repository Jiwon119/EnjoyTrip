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
	<div class="container col-md-9">
		<div class="text-center m-4">
			<h2>전국 관광지 정보</h2>
		</div>

		<!-- 관광지 검색 start -->
		<form class="d-flex my-3" onsubmit="return false;" role="search">
			<select id="search-area" class="form-select me-2">
				<option value="0" selected>검색 할 지역 선택</option>
			</select> <select id="search-content-id" class="form-select me-2">
				<option value="0" selected>관광지 유형</option>
				<option value="12">관광지</option>
				<option value="14">문화시설</option>
				<option value="15">축제공연행사</option>
				<option value="25">여행코스</option>
				<option value="28">레포츠</option>
				<option value="32">숙박</option>
				<option value="38">쇼핑</option>
				<option value="39">음식점</option>
			</select> <input id="search-keyword" class="form-control me-2" type="search"
				placeholder="검색어" aria-label="검색어" />
			<button id="btn-search" class="btn btn-outline-success" type="button">검색</button>
		</form>
		<!-- kakao map start -->
		<div id="map" class="mt-3" style="width: 100%; height: 400px"></div>
		<!-- kakao map end -->
		<div class="row">
			<table class="table table-striped" style="display: none">
				<thead>
					<tr>
						<th>대표이미지</th>
						<th onClick={sortTable("title")}>관광지명</th>
						<th onClick={sortTable("addr")}>주소</th>
						<th onClick={sortTable("latitude")}>위도</th>
						<th onClick={sortTable("longitude")}>경도</th>
					</tr>
				</thead>
				<tbody id="trip-list"></tbody>
			</table>
		</div>
		<!-- 관광지 검색 end -->
	</div>


	<!-- 중앙 content end -->


	<!-- 하단 footer start -->
	<%@ include file="include/footer.jsp"%>
	<!-- 하단 footer end -->
	<script src="./assets/js/key.js"></script>
	<script>var root = "${root}"</script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4639e1c71dad008774ce0ab3f6dbae1f&libraries=services,clusterer,drawing"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script src="./assets/js/map.js"></script>
	
</body>
</html>