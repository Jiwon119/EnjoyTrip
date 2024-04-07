<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { detailArticle, deleteArticle } from "@/api/board";
import BoardComment from "./item/BoardComment.vue";

const route = useRoute();
const router = useRouter();

// const articleno = ref(route.params.articleno);
const { articleno } = route.params;

const articles = ref({});
const comments = ref([]);

onMounted(() => {
  getArticle();
});

const getArticle = () => {
  console.log(articleno + "번글 얻으러 가자!!!");
  // API 호출
  detailArticle(articleno, ({ data }) => {
    console.log(data);
    articles.value = data.article;
    comments.value = data.comment;
  },
    (error) => {
      console.log(error);
    })
};

function moveList() {
  router.push({ name: "article-list" });
}

function moveModify() {
  router.push({ name: "article-modify", params: { articleno } });
}

function onDeleteArticle() {
  // API 호출
  deleteArticle(articleno, ({ data }) => {
    console.log(data);
  },
    (error) => {
      console.log(error);
    })
  router.push({ name: "article-list" });
}

</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10 text-start">
        <div class="row my-2">
          <!-- <h2 class="text-secondary px-5">{{ article.articleNo }}. {{ article.subject }}</h2> -->
          <h2 class="text-secondary">{{ articles.subject }}</h2>
        </div>
        <div class="row">
          <div class="col-md-8">
            <div class="clearfix align-content-center">
              <p>
                <span class="fw-bold">{{ articles.userName }}</span> <br />
                <span class="text-secondary fw-light">
                  {{ articles.registerTime }}1 조회 : {{ articles.hit }}
                </span>
              </p>
            </div>
          </div>
          <div class="col-md-4 align-self-center text-end">댓글 : {{ comments.length }}</div>
          <div class="divider mb-3"></div>
          <div class="text-secondary">
            {{ articles.content }}
          </div>

          <div class="divider mt-3 mb-3"></div>
          <div class="d-flex justify-content-end">
            <button type="button" class="btn btn-outline-secondary mb-3" @click="moveList">
              글목록
            </button>
            <button type="button" class="btn btn-outline-secondary mb-3 ms-1" @click="moveModify">
              글수정
            </button>
            <button type="button" class="btn btn-outline-secondary mb-3 ms-1" @click="onDeleteArticle">
              글삭제
            </button>
          </div>

          <BoardComment />

        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
