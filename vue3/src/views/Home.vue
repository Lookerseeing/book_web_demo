<template>
    <div class="common-layout">
      <el-container>
        <el-header style="line-height: 50px">
          <Header/>
        </el-header>
        <el-container>
          <el-aside width="200px">
          <Aside  @myClick="myClick"></Aside>
          </el-aside>
          <el-main >
           <Main v-if="open.arr[0]" ></Main>
            <UserinfoPage v-if="open.arr[1]"></UserinfoPage>
            <Usercollection v-if="open.arr[2]"></Usercollection>
            <UserHistory v-if="open.arr[3]"></UserHistory>
          </el-main>
        </el-container>
      </el-container>
    </div>

</template>

<script setup='props,context'>
  import Header from "@/components/Header";
  import Aside from "@/components/Aside";
  import Main from "@/components/Main";
  import UserinfoPage from "@/views/UserinfoPage";
  import {reactive,ref,onMounted} from 'vue'
  //侧边栏显示控制
  let open=reactive({
    arr : []
  })
  open.arr=[false,false,false,false]
  const num = ref('')

  //通过事件接收子组件传递的值
  const myClick = (e) => {
    for (let i = 0; i <open.arr.length ; i++) {
      if (e==i+1){
        open.arr[i]=true;
      }else{
        open.arr[i]=false
      }
    }
    //console.log(e)
  }

  // 获取子组件的值和方法
</script>

