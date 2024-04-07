<script setup>
import { RouterView } from "vue-router";
import TheHeadingNavbar from "@/components/layout/TheHeadingNavbar.vue";
import TheFooter from "@/components/layout/TheFooter.vue";
</script>

<template>
  <div class="body bg-body-tertiary">
    <TheHeadingNavbar style="width: 100%"></TheHeadingNavbar>
    <div class="box">
      <router-view></router-view>
    </div>
    <TheFooter></TheFooter>
  </div>
</template>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap");



.body {
  font-family: "Gowun Dodum", sans-serif;
  height: 100%;

  display: flex;
  flex-direction: column;

  text-align: center;
  margin: 0;
}

.box {
  flex: 1;
  background-color: cornflowerblue;
  margin: 30px 15% 30px 15%;
  background-color: white;
  border-radius: 30px;
  box-shadow: -10px -10px 15px rgba(212, 212, 212, 0.12),
    10px 10px 15px rgba(186, 186, 186, 0.12);
}
</style>
