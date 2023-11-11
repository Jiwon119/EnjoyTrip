<script setup>
defineProps({ comment: Object });
</script>

<template>
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

<style scoped>
td {
  padding: 5px 20px;
}

table {
  border-top: 1px solid rgb(192, 192, 192);
  margin-bottom: 10px;
  padding: 10px;
}
</style>
