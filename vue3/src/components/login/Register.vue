<template>
  <body id="paper">
  <el-form :model="registerForm" :rules="rules" ref="registerForm"
           class="login-container" label-position="left"
           label-width="0px" v-loading="loading">
    <h3 class="login_title">注册</h3>
    <el-form-item prop="username">
      <el-input type="text" v-model="registerForm.username"
                auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="registerForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item prop="passwordConfirm">
      <el-input type="password" v-model="registerForm.passwordConfirm"
                auto-complete="off" placeholder="确认密码"></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #505458;border: none;"
                 v-on:click="register('registerForm')">立即注册
      </el-button>
    </el-form-item>
  </el-form>
  </body>
</template>

<script>
  import request from "@/utils/request";

  export default {
    name: 'register',
    data() {
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.registerForm.passwordConfirm !== '') {
            this.$refs.registerForm.validateField('passwordConfirm');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.registerForm.password) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        rules: {
          username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
          password: [{validator: validatePass, trigger: 'blur'}],
          passwordConfirm: [{validator: validatePass2, trigger: 'blur'}]
        },
        checked: true,
        registerForm: {
          username: '',
          password: '',
          passwordConfirm: '',
        },
        loading: false
      }
    },
    methods: {
      register(formName) {
        var _this = this
        this.$refs[formName].validate((valid) => {
          if (valid) {
            request.post("/user/register", {
              userName: this.registerForm.username,
              pwd: this.registerForm.password,
              nickName:this.registerForm.username,
              sex:0,
              age:0
            })
              .then(res => {
                 console.log(res)
                if (res.data.code === 20011) {
                  alert("恭喜你，注册成功")
                  //   _this.$message({
                  //   message: '恭喜你，注册成功',
                  //   type: 'success'
                  // })
                  _this.$router.replace('/')
                } else {
                  _this.$message({
                    message: '该用户名已存在，请更换一个',
                    type: 'error'
                  })
                }
              })
              .catch(err => {
                console.log(err)
              })
          } else {
            _this.$message({
              message: '请检查是否输入正确',
              type: 'error'
            })
            return false;
          }
        });
      },
    }
  }
</script>

<style>
 .login-container{
   border-radius: 15px;
   margin: 10px 5px;
   width: 250px;
   overflow: hidden;
 }
</style>
