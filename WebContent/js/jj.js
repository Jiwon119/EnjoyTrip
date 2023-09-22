// index page 로딩 후 전국의 시도 설정.
		let contentList = [];
		let areaUrl =
			"https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
			"f%2Fsa%2FHw%2FRzRUtzZORMTk%2BL099DB20zyk7rha1CUyGYCAtxXn3Wppmjam9AeA5O0KZ%2BWRsLrrM%2FiiAVwz7qxUaA%3D%3D" +
			"&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";
		function a(){
			// fetch(areaUrl, { method: "GET" }).then(function (response) {
			// return
			// response.json() }).then(function (data) { makeOption(data); });
			fetch(areaUrl, { method: "GET" })
			.then((response) => response.json())
			.then((data) => makeOption(data));
			
		}      

      function makeOption(data) {
        let areas = data.response.body.items.item;
        // console.log(areas);
        let sel = document.getElementById("search-area");
        areas.forEach((area) => {
          let opt = document.createElement("option");
          opt.setAttribute("value", area.code);
          opt.appendChild(document.createTextNode(area.name));

          sel.appendChild(opt);
        });


        // 로컬 스토리지에 값이 있으면
        // 지도 띄우기
        const searchInfo = localStorage.getItem("map");
        if (searchInfo != null) {
          const obj = JSON.parse(searchInfo);

          let areaCode = document.getElementById("search-area");
          let contentTypeId = document.querySelectorAll(".btn-check");
          let keyword = document.getElementById("search-keyword");

          for (var i = 0; i < areaCode.options.length; i++) {
            option = areaCode.options[i];
            if (option.value == obj.area) {
              option.selected = true;
              break;
            }
          }

          console.log(obj.contentId);
          console.log("Dd : ", contentTypeId);
          for (var i = 0; i < contentTypeId.length; i++) {
            console.log(contentTypeId[i]);
            if (contentTypeId[i].value == obj.contentId) {
              document.getElementById(contentTypeId[i].id).checked = true;
              break;
            }
          }
          contentList.push(obj.contentId);
          keyword.value = obj.keyword;

          callApi();
          window.localStorage.removeItem("map");
        }

      }

      function checkBox(checked) {
        var value = checked.getAttribute("value");
        if (checked.checked == true) {
          contentList.push(value);
          console.log(contentList + "체크");
        } else {
          let filtered = contentList.filter((element) => element !== value);
          contentList = filtered;
          console.log(contentList);
        }
        callApi();
      }

      // function callApi(queryString, areaCode, contentTypeId, keyword) {
      function callApi() {
        document.getElementById("trip-list").innerHTML = '';

        let queryString = `serviceKey=uWOp5xSY8MADHRhdxsJyE5eWdsFd0dwa6yv1MsYE1le%2BZsyFhIHakIrK%2FZr%2FEAq1%2BIqpDu%2FwAl3sgiqlW609hA%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A`;
        let areaCode = document.getElementById("search-area").value;

        let contentTypeId = contentList.length;
        let keyword = document.getElementById("search-keyword").value;

        let baseUrl = `https://apis.data.go.kr/B551011/KorService1/`;

        if (parseInt(areaCode)) queryString += `&areaCode=${areaCode}`;

        let service = ``;
        if (keyword || keyword != "") {
          service = `searchKeyword1`;
          queryString += `&keyword=${keyword}`;
        } else {
          service = `areaBasedList1`;
        }

        var dataList = [];
        var tempQueryString = queryString;

        document.querySelector("table").setAttribute("style", "display: ; border-radius: 6px; overflow: hidden;");
        let tripList = ``;
        positions = [];

        console.log("contentList : " + contentList);
        if (contentList.length == 0) {
          let searchUrl = baseUrl + service + "?" + tempQueryString;
          fetch(searchUrl)
            .then((response) => response.json())
            .then((data) => {
              dataList.push(data);
              makeList(dataList)
            });
        } else {
          contentList.forEach(element => {
            tempQueryString += `&contentTypeId=${element}`;
            let searchUrl = baseUrl + service + "?" + tempQueryString;
            fetch(searchUrl)
              .then((response) => response.json())
              .then((data) => {
                makeList(data, tripList, positions);
              });
            tempQueryString = queryString;
          });
        }

        // fetch(searchUrl)
        // .then((response) => response.json())
        // .then((data) => dataList += data);
      }

      let positions; // marker 배열.
      function makeList(data, tripList, positions) {
        let trips = data.response.body.items.item;
        console.log(trips);
        trips.forEach((area) => {
          var firstimage;
          if (area.firstimage == '') firstimage = "../images/basic.png";
          else firstimage = area.firstimage;
          tripList += `
              <tr onclick="moveCenter(${area.mapy}, ${area.mapx});">
                <td><img src="${firstimage}" width="100px"></td>
                <td>${area.title}</td>
                <td>${area.addr1} ${area.addr2}</td>
                <td>${Number(area.mapy).toFixed(3)}</td>
                <td>${Number(area.mapx).toFixed(3)}</td>
              </tr>
              `;

          let markerInfo = {
            title: area.title,
            latlng: new kakao.maps.LatLng(area.mapy, area.mapx),
          };
          positions.push(markerInfo);
        });

        document.getElementById("trip-list").innerHTML += tripList;
        displayMarker();
      }

      function moveCenter(lat, lng) {
        map.setCenter(new kakao.maps.LatLng(lat, lng));
      }