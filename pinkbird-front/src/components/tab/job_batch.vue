<template>
  <div>
    <!-- 面包屑导航区域 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>作业列表</el-breadcrumb-item>
      <el-breadcrumb-item>JAR任务</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 卡片试图区域 -->
    <el-card>
      <!-- 搜索与添加区域 -->
      <el-row :gutter="20">
        <el-col :span="9">
          <el-input placeholder="请输入内容" v-model="queryInfo.query">
            <el-button slot="append" icon="el-icon-search" @click="getBatchJobList"></el-button>
          </el-input>
        </el-col>
        <el-col :span="4">
          <el-button type="primary" @click="addDialogVisible = true">新增任务</el-button>
        </el-col>
      </el-row>
      <!-- 作业列表区域 -->
      <el-table :data="batchJobList" border stripe>
        <el-table-column label="#" type="index"></el-table-column>
        <el-table-column label="ID" prop="jobId" width="300px"></el-table-column>
        <el-table-column label="名称" prop="jobName" width="300px"></el-table-column>
        <el-table-column label="状态">
          <template slot-scope="scope">
            <el-switch v-model="scope.row.jobStatus" :active-value="1" :inactive-value="0"
            @change="jobStatusChange(scope.row)">
            </el-switch>
          </template>
        </el-table-column>
        <el-table-column label="启动时间" prop="startTime"></el-table-column>
        <el-table-column label="并行度" prop="parallelism"></el-table-column>
        <el-table-column label="操作" width="200px">
          <template slot-scope="scope">
            <!-- 修改按钮 -->
            <el-button type="primary" icon="el-icon-edit" size="mini" @click="showEditDialog(scope.row.id)"></el-button>
            <!-- 删除按钮 -->
            <el-button type="danger" icon="el-icon-delete" size="mini"></el-button>
            <!-- 重置状态 -->
            <el-tooltip effect="dark" content="重置状态" placement="top" :enterable="false">
              <el-button type="warning" icon="el-icon-setting" size="mini"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页区域 -->
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="queryInfo.pageNum"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="queryInfo.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </el-card>
    <!-- 添加作业的对话框 -->
    <el-dialog
      title="添加作业" :visible.sync="addDialogVisible" width="50%" @close="addDialogClosed">
      <!-- 内容主体区域 -->
      <el-form :model="addForm" :rules="addFormRules" ref="addFormRef" label-width="100px">
        <el-form-item label="作业名称" prop="jobName">
          <el-input v-model="addForm.jobName"></el-input>
        </el-form-item>
        <el-form-item label="JAR路径" prop="pathJar">
          <el-input v-model="addForm.pathJar"></el-input>
        </el-form-item>
        <el-form-item label="主类全类名" prop="className">
          <el-input v-model="addForm.className"></el-input>
        </el-form-item>
        <el-form-item label="作业参数" prop="classArgs">
          <el-input v-model="addForm.classArgs"></el-input>
        </el-form-item>
        <el-form-item label="并行度" prop="parallelism">
          <el-input v-model="addForm.parallelism"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="addDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addBatchJob">确 定</el-button>
      </span>
    </el-dialog>
    <!-- 修改作业的对话框 -->
    <el-dialog
      title="修改作业" :visible.sync="editDialogVisible" width="50%">
      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="editDialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        // 获取job列表的参数对象
        queryInfo: {
          query: '',
          pageNum: 1,
          pageSize: 10
        },
        batchJobList: [],
        total: 0,
        // 控制添加对话框的显示与隐藏
        addDialogVisible: false,
        // 添加用户的表单数据
        addForm: {
          jobName: '',
          pathJar: '',
          className: '',
          classArgs: '',
          parallelism: ''
        },
        // 添加表单验证规则对象
        addFormRules: {
          jobName: [
            { required: true, message: '请输入作业名称', trigger: 'blue' },
            { min: 5, max: 30, message: '作业名称的长度在5～30个字符之间', trigger: 'blur' }
          ],
          pathJar: [
            { required: true, message: '请输入jar路径', trigger: 'blue' }
          ],
          className: [
            { required: true, message: '请输入主类名', trigger: 'blue' }
          ],
          classArgs: [
            { required: true, message: '请输入作业参数', trigger: 'blue' }
          ]
        },
        // 控制修改用户对话框的显示与隐藏
        editDialogVisible: false
      }
    },
    created () {
      this.getBatchJobList()
    },
    methods: {
      async getBatchJobList () {
        const { data: res } = await this.$http.get('jobConfig/list', {
          params: this.queryInfo
        })
        if (res.code !== 200) {
          return this.$message.error('获取作业列表失败！')
        }
        this.batchJobList = res.data.records
        this.total = res.data.total
      },
      // 监听pagesize改变的事件
      handleSizeChange (newSize) {
        console.log(newSize)
        this.queryInfo.pageSize = newSize
        this.getBatchJobList()
      },
      // 监听页码值改变的事件
      handleCurrentChange (newPage) {
        console.log(newPage)
        this.queryInfo.pageNum = newPage
        this.getBatchJobList()
      },
      // 监听switch开关的状态变化
      async jobStatusChange (jobInfo) {
        console.log(jobInfo)
        const { data: res } = await this.$http.put(`jobConfig/${jobInfo.jobId}/status/${jobInfo.jobStatus}`)
        if (res.code !== 200) {
          return this.$message.error('更新状态失败')
        }
        this.$message.success('更新成功')
      },
      // 监听添加作业对话框的关闭事件
      addDialogClosed () {
        this.$refs.addFormRef.resetFields()
      },
      // 点击按钮添加作业
      addBatchJob () {
        this.$refs.addFormRef.validate(async valid => {
          if (!valid) return
          // 可以发起添加作业的网络请求
          const { data: res } = await this.$http.post('jobConfig/addJob', this.qs.stringify(this.addForm))
          if (res.code !== 200) {
            this.$message.error('添加作业失败')
          }
          this.$message.success('添加作业成功')
          // 隐藏对话框
          this.addDialogVisible = false
          // 重新获取用户列表
          this.getBatchJobList()
        })
      },
      // 展示编辑作业的对话框
      showEditDialog (id) {
        console.log(id)
        this.editDialogVisible = true
      }
    }
  }
</script>

<style lang="less" scoped>
</style>
