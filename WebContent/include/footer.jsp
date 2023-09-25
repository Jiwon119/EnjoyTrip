<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 부트스트랩 사용을 위한 코드 --%>
<!-- JavaScript Bundle with Popper -->
<footer class="container py-5">
	<div class="row">
		<div class="col-12 col-md">
			<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
				fill="none" stroke="currentColor" stroke-linecap="round"
				stroke-linejoin="round" stroke-width="2" class="d-block mb-2"
				role="img" viewBox="0 0 24 24">
            <title>Product</title>
            <circle cx="12" cy="12" r="10" />
            <path
					d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94" />
          </svg>
			<small class="d-block mb-3 text-body-secondary">&copy;
				2017–2023</small>
		</div>
		<div class="col-6 col-md">
			<h5>Features</h5>
			<ul class="list-unstyled text-small">
				<li><a class="link-secondary text-decoration-none" href="#">Cool
						stuff</a></li>
				<li><a class="link-secondary text-decoration-none" href="#">Random
						feature</a></li>
				<li><a class="link-secondary text-decoration-none" href="#">Team
						feature</a></li>
				<li><a class="link-secondary text-decoration-none" href="#">Stuff
						for developers</a></li>
				<li><a class="link-secondary text-decoration-none" href="#">Another
						one</a></li>
				<li><a class="link-secondary text-decoration-none" href="#">Last
						time</a></li>
			</ul>
		</div>
		<div class="col-6 col-md">
			<h5>Resources</h5>
			<ul class="list-unstyled text-small">
				<li><a class="link-secondary text-decoration-none" href="#">Resource
						name</a></li>
				<li><a class="link-secondary text-decoration-none" href="#">Resource</a>
				</li>
				<li><a class="link-secondary text-decoration-none" href="#">Another
						resource</a></li>
				<li><a class="link-secondary text-decoration-none" href="#">Final
						resource</a></li>
			</ul>
		</div>
		<div class="col-6 col-md">
			<h5>Resources</h5>
			<ul class="list-unstyled text-small">
				<li><a class="link-secondary text-decoration-none" href="#">Business</a>
				</li>
				<li><a class="link-secondary text-decoration-none" href="#">Education</a>
				</li>
				<li><a class="link-secondary text-decoration-none" href="#">Government</a>
				</li>
				<li><a class="link-secondary text-decoration-none" href="#">Gaming</a>
				</li>
			</ul>
		</div>
		<div class="col-6 col-md">
			<h5>About</h5>
			<ul class="list-unstyled text-small">
				<li><a class="link-secondary text-decoration-none" href="#">Team</a>
				</li>
				<li><a class="link-secondary text-decoration-none" href="#">Locations</a>
				</li>
				<li><a class="link-secondary text-decoration-none" href="#">Privacy</a>
				</li>
				<li><a class="link-secondary text-decoration-none" href="#">Terms</a>
				</li>
			</ul>
		</div>
	</div>
</footer>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<!--main.js-->
<script src="./js/main.js"></script>
<!--kakao api-->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=87c9546ca7e332f072680d8f464022a2&libraries=services,clusterer,drawing"></script>

<script>
	const loginUser = localStorage.getItem("loginUser");
	if (loginUser != null) {
		const obj = JSON.parse(loginUser);

		document.getElementById("login-form").style.display = "none";
		document.getElementById("info-form").style.display = "block";
		document.getElementById("hello-user").innerHTML = `안녕하세요, ${obj.nickname}님`;
	}
</script>

</html>