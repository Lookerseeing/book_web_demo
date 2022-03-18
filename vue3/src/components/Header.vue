<template>
  <el-affix :offset="0">
  <el-row>
    <el-col :span="70">
      <el-container>
        <el-menu
          :default-active="activeIndex"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          style="width: 1200px;
                z-index:0"
        >
          <el-menu-item index="1">首页</el-menu-item>
          <el-menu-item index="2">图书</el-menu-item>
          <el-menu-item index="3" disabled>关于</el-menu-item>
          <el-menu-item index="4" >更多</el-menu-item>
        </el-menu>

          <el-popover
            placement="bottom"
            title="Title"
            :width="200"
            trigger="hover"
            content="this is content, this is content, this is content"
          >
            <template #reference >
              <el-avatar :size="50" :src="url" style="z-index: 1;position: absolute;right: 100px" />
            </template>
          </el-popover>
      </el-container>
    </el-col>
  </el-row>
  </el-affix>


</template>

<script setup>
  import { ref } from 'vue'
  const url='https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg';
  const activeIndex = ref('1')

  const handleSelect = (key, keyPath) => {
    console.log(key, keyPath)
  }
</script>
<script>
    export default {
        name: 'header',
        data() {
            return {
                msg: ''
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
