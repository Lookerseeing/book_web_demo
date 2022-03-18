<template>
  <div class="body">
    <LoginMode />
  </div>
</template>
<script>
  import LoginMode from '@/components/LoginComponents.vue';
  export default {
    name: 'index',
    components: {LoginMode},
    data() {
      return {

      };
    },
    methods: {

    }
  }
</script>

<style scoped>
  .body {
    background: url("../assets/images/a.png");
    width: 100%;
    height: 100%;
    position: fixed;
    background-size: 100% 100%;
  }
</style>
