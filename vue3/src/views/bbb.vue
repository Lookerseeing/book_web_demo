<template>
  <aaa @onExport="clickadd"  msg="Hello Vue 3.0 + Vite  传过来的" />
</template>

<script setup>
  //值计入引入就可以了
  import aaa from "@/views/aaa"

  const clickadd=(e)=>{
    console.log('index---addd',e)
  }
</script>
