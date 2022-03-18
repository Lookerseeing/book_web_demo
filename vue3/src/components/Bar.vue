<template>
  <el-row>
    <el-col :span="24"><div class="aaa" /></el-col>
  </el-row>
  <el-affix :offset="0">
  <section class="et-hero-tabs">
<!--    <h1>粘性滑块导航</h1>-->
    <div class="et-hero-tabs-container">
      <a class="et-hero-tab" href="#">ES6</a>
      <a class="et-hero-tab" href="#">Flexbox</a>
      <a class="et-hero-tab" href="#">React</a>
      <a class="et-hero-tab" href="#">Angular</a>
      <a class="et-hero-tab" href="#">Other</a>
      <span class="et-hero-tab-slider"></span>
    </div>
  </section>
  </el-affix>

</template>

<script setup>


</script>
<script>
    export default {
        name: 'bar',
      created() {

      },
      data() {
            return {
                msg: ''
            }
        },
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
