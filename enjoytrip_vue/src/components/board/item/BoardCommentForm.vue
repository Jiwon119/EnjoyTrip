<script setup>
import { ref } from "vue";
import { writeComment } from "@/api/board";
import { useRoute } from "vue-router";

const route = useRoute();

let { articleno } = route.params;

const newComment = ref({
  articleNo: articleno,
  content: "",
  writer: ""
})

const emit = defineEmits(["commentWrite"]);

function writeNewComment() {
  console.log(newComment.value, "새로운 댓글 추가");
  // API 호출
  writeComment(newComment.value, (response) => {
    console.log(response);
    emit("commentWrite")
  },
    (error) => {
      console.log(error);
    })
  newComment.value.content = ""
}

</script>

<template>
  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="아이디" v-model="newComment.writer"> <br />
    <input type="text" class="form-control" placeholder="댓글 입력" v-model="newComment.content">
    <button class="btn btn-outline-secondary" type="button" @click="writeNewComment">등록</button>
  </div>
</template>

<style scoped></style>
