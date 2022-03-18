<template>
  <div style="width: 100%">
    <div class=loginmode>
      <el-container style="width: 300px;">
        <el-main>
          <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane style="color: darkgray " label="登录" name="first">
              <LoginC/>
            </el-tab-pane>
            <el-tab-pane style="color: darkgray " label="注册" name="second">
              <ResgisterC/>
            </el-tab-pane>
          </el-tabs>
        </el-main>
      </el-container>
      <div>

      </div>
    </div>
  </div>
</template>

<script>
  import LoginC from '@/components/login/Login.vue';
  import ResgisterC from '@/components/login/Register.vue';

  export default {
    name: 'loginMode',
    components: {LoginC, ResgisterC},
    data() {
      return {
        activeName: 'first'
      };
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .loginmode {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 300px;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
</style>
