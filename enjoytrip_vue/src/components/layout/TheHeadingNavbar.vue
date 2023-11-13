<script setup></script>

<template>
  <div>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <router-link :to="{ name: 'main' }" class="navbar-brand" style="color: #7685b5">
          <img src="@/assets/logo1.png" style="width: 200px; margin-left: 30px" />
        </router-link>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor04"
          aria-controls="navbarColor04" aria-expanded="false" aria-label="Toggle navigation"
          style="margin: 0px 30px 0px 30px; color: #7685b5">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor04">
          <ul class="navbar-nav me-auto">
            <li class="nav-item">
              <router-link :to="{ name: 'board' }" class="nav-link">게시판</router-link>
            </li>
            <li class="nav-item">
              <router-link :to="{ name: 'estations' }" class="nav-link">전기차충전소</router-link>
            </li>
            <li class="nav-item">
              <router-link :to="{ name: 'camp' }" class="nav-link">camp</router-link>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                aria-expanded="false">Dropdown</a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Separated link</a>
              </div>
            </li>
          </ul>
          <form class="d-flex">
            <input class="form-control me-sm-2" type="search" placeholder="Search" />
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">
              Search
            </button>
          </form>
        </div>
      </div>
    </nav>
  </div>
</template>

<style scoped>
.nav-item * {
  color: #7685b5;
  margin-top: 15px;
}
</style>
