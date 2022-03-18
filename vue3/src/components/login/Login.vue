<template>
  <div>
    <body id="poster">
    <el-form class="login-container" label-position="left"
             label-width="0px">
      <h3 class="login_title">登录</h3>
      <el-form-item>
        <el-input type="text"  v-model="loginForm.username"
                  auto-complete="off" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" v-model="loginForm.password"
                  auto-complete="off" show-password placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="login">登录</el-button>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="tohome">游客模式</el-button>
      </el-form-item>
    </el-form>
    </body>
    <div></div>
  </div>
</template>
<script>
  import request from "@/utils/request";

  export default {
    name: "Login",
    data() {
      return {
        loginForm:{
          username:'root',
          password:'root'
        }
      }
    },
    methods: {
      login(){
        var _this = this
        request.post("/user/login",{
          username:this.loginForm.username,
          password:this.loginForm.password,
        })
          .then(res => {
            // console.log(response.data.status)
            if(res.data != null){
              _this.$message({
                message: '登录成功',
                type: 'success'
              })
              _this.$store.commit('login',res.data.object)
              _this.$router.push('/home')
              // var path = _this.$route.query.redirect;
              // console.log(res)
              // _this.$router.replace({path:path === undefined ? '/' : path})
            }
            else {
              // alert("账号或密码错误")
              _this.$message({
                message: '账号或密码错误',
                type: 'error'
              })
              console.log(res)
            }
          })
          .catch(function (error) {
            console.log(error)
          })
      },
      tohome(){
        this.$router.push('/home')
      }
    }
  }
</script>


<style>




</style>
