<template>
    <div class=main>
      <el-table :data="tableData" style="width: 100%">
        <el-table-column fixed prop="id" label="id" width="100" />
        <el-table-column prop="userName" label="Name" width="120" />
        <el-table-column prop="nickName" label="nickName" width="120" />
        <el-table-column prop="sex" label="sex" width="120" />
        <el-table-column prop="age" label="age" width="120" />
        <el-table-column prop="tel" label="tel" width="120" />
        <el-table-column prop="address" label="Address" width="600" />
        <el-table-column fixed="right" label="Operations" width="120">
          <template #default>
            <el-popconfirm
              title="您确定要删除吗?"
              @confirm="del">
              <template #reference>
                <el-button type="text" size="small">删除</el-button>
              </template>
            </el-popconfirm>
            <el-button type="text" size="small" @click="openDig(id)">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-dialog v-model="dialogFormVisible" title="修改">
        <el-form :model="tableData">
          <el-form-item label="userName" :label-width="formLabelWidth">
            <el-input v-model="tableData.userName" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="nickName" :label-width="formLabelWidth">
            <el-input v-model="tableData.nickName" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="age" :label-width="formLabelWidth">
            <el-input v-model.number="tableData.age" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="tel" :label-width="formLabelWidth">
            <el-input v-model.number="tableData.tel" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="sex" :label-width="formLabelWidth">
            <el-select v-model="tableData.sex" placeholder="性别">
              <el-option label="男" value="男"></el-option>
              <el-option label="女" value="女"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button  @click="openDig()">取消</el-button>
        <el-button type="primary"
                   @click="openDig()">确认</el-button>
      </span>
        </template>
      </el-dialog>
    </div>
</template>

<script>
  import request from "@/utils/request";
  export default {
    data(){
      return{
        tableData : [{
          id:'',
          userName:'',
          nickName:'',
          sex:'',
          age:'',
          tel:'',
          address:''
        }],
        dialogFormVisible:false,
        activeIndex : '1',
        formLabelWidth:'120px',
      }
    },
    created() {
      this.getUser()
    },
    methods:{
      getUser(){
        request.get("/login/all").then(res=>{
          if (res.code===20041){
            this.tableData=res.data
            for (let i = 0; i <this.tableData.length ; i++) {
              this.tableData[i].sex === 1 ?
                this.tableData[i].sex = '男' :
                this.tableData[i].sex = '女'
            }
          }

        }).catch(err=>{
          console.log(err)
        })
      },
      openDig(id){
        //this.getUser();
        this.closeDig()
      },
      closeDig(){
        this.dialogFormVisible = !this.dialogFormVisible
      },
      handleSelect(key, keyPath){
        console.log(key, keyPath)
      },
      handleClick(){

      },
      del() {

      }

    }
  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
