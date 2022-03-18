<template>
  <el-affix :offset="70">
    <div class=aside>
      <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
       @select="handleSelect"
      style="height: 600px">
        <el-submenu index="1">
          <el-menu-item-group title="账号设置">
            <el-menu-item index="1">个人资料</el-menu-item>
            <el-menu-item index="2">账号设置</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="记录">
          <el-submenu index="3">
            <el-menu-item index="3">我的收藏</el-menu-item>
          </el-submenu>
          <el-submenu index="4">
            <el-menu-item index="4">历史记录</el-menu-item>
          </el-submenu>
          </el-menu-item-group>
          <el-menu-item-group title="其他">
          <el-submenu index="5">
            <el-menu-item index="5" @click="drawer = true">关于我们</el-menu-item>
          </el-submenu>
          <el-submenu index="6">
            <el-menu-item index="6" @click="drawer = true">联系我们</el-menu-item>
          </el-submenu>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </div>
  </el-affix>
  <el-drawer v-model="drawer" title="I am the title" :with-header="false">
    <span>Hi there!</span>
  </el-drawer>
</template>

<script setup='props,context'>
  import {ref} from "vue";
  import { defineProps, defineEmits,} from "vue"


  // 注册事件
  const emits = defineEmits(["myClick"])


  let drawer = ref(false)
  const handleSelect = (key) => {
   // console.log(key)
    emits("myClick", key)
  }
</script>
<script>
    export default {
        name: 'aside',
        data() {
            return {
                msg: ''
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.aside{
  margin-top: 15px;
  height: 600px;
}
</style>
