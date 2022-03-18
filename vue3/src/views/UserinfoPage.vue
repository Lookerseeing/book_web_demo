<template>
  <div class="box">
    <el-container>
      <el-aside width="300px" style="margin-top: 50px">
        <el-row>
          <el-col :span="30">
        <el-card :body-style="{ padding: '0px' }" style="flex-wrap: wrap;">
          <img
            src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"
            class="image"
            style="height: 300px;
                    width: 100%;
                    flex-wrap: nowrap;"
          />
          <div style="padding: 14px">
            <span>Yummy hamburger</span>
            <div class="bottom">
              <time class="time">{{ currentDate }}</time>
              <el-button type="text" class="button">Operating</el-button>
            </div>
          </div>
        </el-card>
          </el-col>
        </el-row>
      </el-aside>
      <el-main>


      </el-main>
    </el-container>
  </div>
</template>

<script setup>
  import {ref} from 'vue'


  const currentDate = ref(new Date())
</script>
<script>
  export default {
    name: '',
    data() {
      return {
        msg: ''
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.bottom{
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.time {
  font-size: 13px;
  color: #999;
}
.button {
  padding: 0;
  min-height: auto;
}
</style>
