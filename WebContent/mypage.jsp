<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">

  <style>
    body {
      font-family: 'Gowun Dodum', sans-serif;
    }

    .bi {
      vertical-align: -.125em;
      fill: currentColor;
    }
  </style>
</head>

<body>
  <nav class="navbar navbar-expand-md bg-dark sticky-top border-bottom" data-bs-theme="dark">
    <div class="container">
      <a class="navbar-brand d-md-none" href="index.html">
        <svg class="bi" width="24" height="24">
          <use xlink:href="#aperture" />
        </svg>
        Aperture
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvas"
        aria-controls="#offcanvas" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="offcanvas offcanvas-end" tabindex="-1" id="#offcanvas" aria-labelledby="#offcanvasLabel">
        <div class="offcanvas-header">
          <h5 class="offcanvas-title" id="#offcanvasLabel">Aperture</h5>
          <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
          <a class="navbar-brand" href="index.html">Enjoy Trip</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <ul class="navbar-nav flex-grow-1 justify-content-between">
            <li class="nav-item">
              <a class="nav-link" href="#">
                <svg class="bi" width="24" height="24">
                  <use xlink:href="#aperture" />
                </svg>
              </a>
            </li>
            <li class="nav-item"><a class="nav-link" href="./map.html">지도</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Product</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Features</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Enterprise</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Support</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Pricing</a></li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <svg class="bi" width="24" height="24">
                  <use xlink:href="#cart" />
                </svg>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </nav>

  <!-- 중앙 center content end -->
  <div class="col-6 mx-auto">
    <div class="display-6 m-5 mb-5 text-center" role="alert">내 정보</div>

    <form>
        <div class="form-floating mb-3">
          <input type="text" class="form-control" id="info-id" placeholder="ID" readonly/>
          <label for="floatingInput">ID</label>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="info-email" placeholder="E-mail" />
            <label for="floatingInput">E-mail</label>
          </div>

          <div class="form-floating mb-3">
            <input type="text" class="form-control" id="info-nickname" placeholder="Nickname" />
            <label for="floatingInput">Nickname</label>
          </div>

        
        <div class="form-floating mb-3">
          <input
            type="password"
            class="form-control"
            id="info-password"
            placeholder="Password"
          />
          <label for="floatingPassword">Password</label>
        </div>

        <div class="form-floating mb-3">
            <input
              type="password"
              class="form-control"
              id="info-password-check"
              placeholder="Password"
            />
            <label for="floatingPassword">Password Check</label>
          </div>


        <button
          class="btn btn-outline-dark w-100 py-2 mb-3"
          type="button"
          onclick="update()"
        >
          수정
        </button>
        <button
          class="btn btn-outline-dark w-100 py-2 mb-3"
          type="button"
          onclick="location.href='index.html'"
        >
          취소
        </button>

        
      </form>

      <script>
          const user = JSON.parse(window.localStorage.getItem("user"));
          document.getElementById("info-id").value = user.id;
          document.getElementById("info-email").value = user.email;
          document.getElementById("info-nickname").value = user.nickname;

      </script>
    <script src="./js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>