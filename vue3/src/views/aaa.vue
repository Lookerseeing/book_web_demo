<template>
  <h1>{{ msg }}</h1>
  <button @click="inc">点击新增</button>
</template>

<script setup>
  //  $emits使用 defineEmits 来代替了
  import {defineEmits} from 'vue'

  const emits = defineEmits(["onSubmit", "onExport"]);
  const inc=()=>{
    emits("onExport",'11111111');
  }



</script>
