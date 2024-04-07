<script setup>
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import { getComment, writeComment } from "@/api/board";

onMounted(() => {
  console.log(articleno);
  getComments();
});

const route = useRoute();
const { articleno } = route.params;
const comments = ref([]);
const newComment = ref({
  articleNo: articleno,
  content: "",
  writer: ""
})

const getComments = () => {
  // API 호출
  getComment(articleno, ({ data }) => {
    comments.value = data;
  },
    (error) => {
      console.log(error);
    })
};

function writeNewComment() {
  console.log(newComment.value, "새로운 댓글 추가");
  // API 호출
  writeComment(newComment.value, () => {
    getComments();
  },
    (error) => {
      console.log(error);
    });

  newComment.value.content = ""
}
</script>

<template>
  <div>
    <div class="input-group mb-3">
      <input type="text" class="form-control" placeholder="아이디" v-model="newComment.writer"> <br />
      <input type="text" class="form-control" placeholder="댓글 입력" v-model="newComment.content">
      <button class="btn btn-outline-secondary" type="button" @click="writeNewComment">등록</button>
    </div>

    <template v-for="comment in comments" :key="comment.articleno">
      <table>
        <tr>
          <td>{{ comment.writer }}</td>
          <td style="text-align: right;">{{ comment.createDate }}</td>
        </tr>
        <tr>
          <td colspan="2">{{ comment.content }}</td>
        </tr>
      </table>
    </template>
  </div>
</template>

<style scoped>
td {
  padding: 5px 20px;
}

table {
  width: 100%;
  border-top: 1px solid rgb(192, 192, 192);
  margin-bottom: 10px;
  padding: 10px;
}
</style>
