<template>
  <div class="container" style="min-height: 100%; padding-bottom: 100px;">
    <div div-lc-mark>
      <el-menu
        :default-active="activeIndex2"
        class="el-menu-demo"
        mode="horizontal"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
        @select="handleSelect"
      >
        <el-menu-item index="1">Processing Center</el-menu-item>
        <el-sub-menu index="2">
          <template #title>Workspace</template>
          <el-menu-item index="2-1">item one</el-menu-item>
          <el-menu-item index="2-2">item two</el-menu-item>
          <el-menu-item index="2-3">item three</el-menu-item>
          <el-sub-menu index="2-4">
            <template #title>item four</template>
            <el-menu-item index="2-4-1">item one</el-menu-item>
            <el-menu-item index="2-4-2">item two</el-menu-item>
            <el-menu-item index="2-4-3">item three</el-menu-item>
          </el-sub-menu>
        </el-sub-menu>
        <el-menu-item index="3" disabled>Info</el-menu-item>
        <el-menu-item index="4">Orders</el-menu-item>
        <el-avatar :size="50" :src="circleUrl">
          <el-dropdown>
            <span class="el-dropdown-link">下拉菜单</span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>黄金糕</el-dropdown-item>
                <el-dropdown-item>狮子头</el-dropdown-item>
                <el-dropdown-item>螺蛳粉</el-dropdown-item>
                <el-dropdown-item disabled>双皮奶</el-dropdown-item>
                <el-dropdown-item divided>蚵仔煎</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
          <a>W3School</a>
        </el-avatar>
      </el-menu>
    </div>
    <div div-lc-mark>
      <el-container>
        <el-aside width="200px">
          <el-collapse
            v-model="collapseActiveNames"
            @change="handleChange3"
          ></el-collapse>
        </el-aside>
        <el-main>
          <el-carousel height="150px">
            <el-carousel-item v-for="item in 4" :key="item">
              <h3 class="small">{{ item }}</h3>
            </el-carousel-item>
          </el-carousel>
        </el-main>
      </el-container>
    </div>
    <div div-lc-mark>
      <el-container>
        <el-main>Main</el-main>
      </el-container>
    </div>
    <div div-lc-mark>
      <el-container>
        <el-main>Main</el-main>
      </el-container>
    </div>
    <div div-lc-mark>
      <el-container>
        <el-main>Main</el-main>
      </el-container>
    </div>
  </div>
</template>

<script>
  export default {
    props: [],
    components: {},
    data() {
      return {
        activeIndex2: "1",
        circleUrl:
          "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
        collapseActiveNames: ["1"],
        item: "",
        showValue: "开启预览模式后,点击我显示预设逻辑",
        showText: "这里的值声明于预设JS代码",
      }
    },
    watch: {},
    computed: {},
    beforeCreate() {},
    created() {},
    beforeMount() {},
    mounted() {},
    beforeUpdate() {},
    updated() {},
    destoryed() {},
    methods: {
      request() {},
      handleChange3(val) {
        console.log(val)
      },
      handleSelect() {},
      hello() {
        alert("来自预设逻辑代码的问候")
      },
    },
    fillter: {},
  }
</script>

<style scoped>
  .el-dropdown-link{}
  .el-menu-demo{}
  .small{}
  .container {  }
</style>
