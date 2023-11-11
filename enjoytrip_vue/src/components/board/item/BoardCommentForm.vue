<script setup>
import { ref } from "vue";
import { writeComment } from "@/api/board";
import { useRoute, useRouter } from "vue-router";

const router = useRouter();
const route = useRoute();

let { articleno } = route.params;

const newComment = ref({
  articleNo: articleno,
  content: "",
  writer: ""
})

function writeArticle() {
  console.log(newComment.value, "새로운 댓글 추가");
  // API 호출
  writeComment(newComment.value, (response) => {
    console.log(response);
  },
    (error) => {
      console.log(error);
    })
}

</script>

<template>
  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="아이디" v-model="newComment.writer"> <br />
    <input type="text" class="form-control" placeholder="댓글 입력" v-model="newComment.content">
    <button class="btn btn-outline-secondary" type="button" @click="writeArticle">등록</button>
  </div>
</template>

<style scoped></style>
