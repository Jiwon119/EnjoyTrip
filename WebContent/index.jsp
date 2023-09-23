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
							<img style="width: 300px" src="./assets/undraw_trip_re_f724.svg" />
						</div>
						<form action="" method="post">
							<input type="hidden" value="indexToMap" />
							<!-- 지역 선택 -->
							<div class="input-group m-3" style="min-width: 200px">
								<span class="input-group-text"
									style="width: 50px; background-color: #001e3d"> <i
									class="bi bi-geo-alt-fill m-auto" style="color: white"></i>
								</span> <select name="index-search-area" id="index-search-area"
									class="form-select me-2" aria-label="Default select example"
									style="background-color: #e6e6e6">
									<option value="0" selected>검색 할 지역 선택</option>
								</select>
							</div>

							<!-- 관광지 유형 선택 -->
							<div class="input-group m-3" style="min-width: 200px">
								<span class="input-group-text"
									style="width: 50px; background-color: #001e3d"> <i
									class="bi bi-geo-alt-fill m-auto" style="color: white"></i>
								</span> <select name="index-search-content"
									id="index-search-content-id" class="form-select me-2"
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
								</span> <input name="index-search-keyword" id="index-search-keyword"
									class="form-control me-2" style="background-color: #e6e6e6"
									type="search" placeholder="검색어" aria-label="검색어" />
							</div>

							<button class="btn btn-outline-dark mx-auto mt-3" type="button"
								id="index-search-btn">
								<i class="bi bi-search"></i> 검색
							</button>
						</form>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	<script type="text/javascript">
		document.querySelector("#index-search-btn").addEventListener("click", () =>  {
			location.href="./enjoyTrip?action=map";
		}); 

       fetch("/04_EnjoyTrip_Back/region?action=sido", { method: "GET" })
          .then(function(response) { 
        	  return response.json()})
          .then(function(data) { 
        	  makeOption(data)});
       
       function makeOption(data){
    	   console.log("data");
			console.log("in make option");
    	   let areas = data;
    	   let sel = document.getElementById("index-search-area");
			areas.forEach(function (area){
			let opt = document.createElement("option");
			opt.setAttribute("value", area["sidoCode"]);
			opt.appendChild(document.createTextNode(area["sidoName"]));
			sel.appendChild(opt);
		});
       }

       /*
	    function makeOption(data) {
			console.log("in make option");
			//let areas = data.response.body.items.item;
			let areas = data;
			console.log(areas);
			let sel = document.getElementById("index-search-area");
			areas.forEach(function (area){
				let opt = document.createElement("option");
				opt.setAttribute("value", area.code);
				opt.appendChild(document.createTextNode(area.name));
				sel.appendChild(opt);
			});
	    }
       */
	</script>
	<%@ include file="/include/footer.jsp"%>