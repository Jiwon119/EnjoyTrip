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
	<!-- 중앙 center content end -->
	<div class="col-8 mx-auto" onload="a()">
		<div class="display-6 m-5 mb-5 text-center" role="alert">전국 관광지
			정보</div>

		<!-- 관광지 검색 start -->
		<form class="ms-5 me-5 d-flex" onsubmit="return false;" role="search">
			<select id="search-area" class="form-select me-2"
				aria-label="Default select example">
				<option value="0" selected>검색 할 지역 선택</option>
			</select>
			<!-- <select id="search-content-id" class="form-select me-2">
        <option value="0" selected>관광지 유형</option>
        <option value="12">관광지</option>
        <option value="14">문화시설</option>
        <option value="15">축제공연행사</option>
        <option value="25">여행코스</option>
        <option value="28">레포츠</option>
        <option value="32">숙박</option>
        <option value="38">쇼핑</option>
        <option value="39">음식점</option>
      </select> -->

			<input id="search-keyword" class="form-control me-2" type="search"
				placeholder="검색어" aria-label="검색어" />
			<button id="btn-search" class="btn btn-outline-success text-nowrap"
				type="button">검색</button>

		</form>

		<!-- kakao map start -->
		<div class="d-flex ">
			<div id="map" class="col-10 mx-auto mt-3 rounded-3"
				style="height: 500px;"></div>
			<div class="mt-3 ms-3" style="min-width: 120px;">
				<div class="btn-group-vertical bg" role="group">
					<input type="checkbox" class="btn-check" id="search-1" value="12"
						onchange="checkBox(this)"> <label
						class="btn btn-outline-success" for="search-1">관광지</label> <input
						type="checkbox" class="btn-check" id="search-2" value="14"
						onchange="checkBox(this)"> <label
						class="btn btn-outline-success" for="search-2">문화시설</label> <input
						type="checkbox" class="btn-check" id="search-3" value="15"
						onchange="checkBox(this)"> <label
						class="btn btn-outline-success" for="search-3">축제공연행사</label> <input
						type="checkbox" class="btn-check" id="search-4" value="25"
						onchange="checkBox(this)"> <label
						class="btn btn-outline-success" for="search-4">여행코스</label> <input
						type="checkbox" class="btn-check" id="search-5" value="28"
						onchange="checkBox(this)"> <label
						class="btn btn-outline-success" for="search-5">레포츠</label> <input
						type="checkbox" class="btn-check" id="search-6" value="32"
						onchange="checkBox(this)"> <label
						class="btn btn-outline-success" for="search-6">숙박</label> <input
						type="checkbox" class="btn-check" id="search-7" value="38"
						onchange="checkBox(this)"> <label
						class="btn btn-outline-success" for="search-7">쇼핑</label> <input
						type="checkbox" class="btn-check" id="search-8" value="39"
						onchange="checkBox(this)"> <label
						class="btn btn-outline-success" for="search-8">음식점</label>
				</div>
			</div>
		</div>

		<!-- kakao map end -->
		<div class="row">
			<table class="table table-striped m-3 mx-auto" style="display: none;">
				<thead>
					<tr>
						<th>대표이미지</th>
						<th>관광지명</th>
						<th>주소</th>
						<th>위도</th>
						<th>경도</th>
					</tr>
				</thead>
				<tbody id="trip-list"></tbody>
			</table>
			<!-- 관광지 검색 end -->
		</div>
	</div>
	<%@ include file="/include/footer.jsp"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bf4175c7edc823e48a143d011d870bbc&libraries=services,clusterer,drawing"></script>
	<script src="./js/jj.js"></script>
	<script>
			document.getElementById("btn-search").addEventListener("click", () => {

	          let queryString = `serviceKey=uWOp5xSY8MADHRhdxsJyE5eWdsFd0dwa6yv1MsYE1le%2BZsyFhIHakIrK%2FZr%2FEAq1%2BIqpDu%2FwAl3sgiqlW609hA%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A`;
	          let areaCode = document.getElementById("search-area").value;
	          let contentTypeId = document.getElementById("search-content-id").value;
	          let keyword = document.getElementById("search-keyword").value;

	          callApi(queryString, areaCode, contentTypeId, keyword);
	        });
	      
	      // 검색 버튼을 누르면..
	      // 지역, 유형, 검색어 얻기.
	      // 위 데이터를 가지고 공공데이터에 요청.
	      // 받은 데이터를 이용하여 화면 구성.
	      document.getElementById("btn-search").addEventListener("click", () => {
	        callApi();
	      });
	      // 카카오지도
	      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
	        mapOption = {
	          center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
	          level: 5, // 지도의 확대 레벨
	        };

	      // 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
	      var map = new kakao.maps.Map(mapContainer, mapOption);

	      function displayMarker() {
	        // 마커 이미지의 이미지 주소입니다
	        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

	        for (var i = 0; i < positions.length; i++) {
	          // 마커 이미지의 이미지 크기 입니다
	          var imageSize = new kakao.maps.Size(24, 35);

	          // 마커 이미지를 생성합니다
	          var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

	          // 마커를 생성합니다
	          var marker = new kakao.maps.Marker({
	            map: map, // 마커를 표시할 지도
	            position: positions[i].latlng, // 마커를 표시할 위치
	            title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
	            image: markerImage, // 마커 이미지
	          });
	        }

	        // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
	        map.setCenter(positions[0].latlng);
	      }
		</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>