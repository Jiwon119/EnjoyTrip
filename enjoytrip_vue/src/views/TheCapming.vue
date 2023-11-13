<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";

// const url = import.meta.env.VITE_VUE_API_URL;
// const servicekey = import.meta.env.VITE_ELECTRIC_CHARGING_STATION_URL;
const { VITE_OPEN_API_SERVICE_KEY, VITE_CAMP_API_URL } = import.meta.env;

const campingData = ref([]);

// 들어오자마자 실행되는 함수
onMounted(() => {
  getCampInfo();
});

const getCampInfo = () => {
  axios
    .get(VITE_CAMP_API_URL, {
      params: {
        serviceKey: VITE_OPEN_API_SERVICE_KEY,
        pageNo: 1,
        numOfRows: 20,
        MobileOS: 'WIN',
        MobileApp: 'AppTest',
        _type: 'json'
      }, 
    })
    .then(({data}) => {
      console.log("data : ",data);
      console.log(data.response.body.items);
      campingData.value = data.response.body.items.item;
      console.log(campingData.value);
      console.log(campingData.value);
    })
    .catch((error) => {
      console.log(error);
    });
};
</script>

<template>
  <div class="container text-center mt-3">
    <div class="alert alert-success" role="alert">캠핑장 정보</div>
    <table class="table table-hover">
      <thead>
        <tr class="text-center">
          <th scope="col">캠핑장 이름</th>
          <!-- <th scope="col">소개</th> -->
          <th scope="col">캠핑장 소개</th>
          <th scope="col">위치</th>
          <th scope="col">시설</th>
          <th scope="col">이미지</th>
        </tr>
      </thead>
      <tbody>
        <tr class="text-center" v-for="camp in campingData" :key="camp.contentId">
          <td>{{ camp.facltNm }}</td>
          <!-- <td>{{ camp.lineIntro }}</td> -->
          <td v-if="camp.featureNm == ''">{{ camp.lineIntro }}</td>
          <td v-else>{{ camp.featureNm }}</td>
          <td>{{ camp.addr1 }}</td>
          <td>{{ camp.sbrsEtc }}</td>
          <td><img :src="camp.firstImageUrl" style="width: 180px;"> </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style></style>
