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
        <el-col :span="8">
          <el-input placeholder="请输入内容">
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </el-col>
        <el-col :span="4">
          <el-button type="primary">新增任务</el-button>
        </el-col>
      </el-row>
      <!-- 作业列表区域 -->
      <el-table :data="batchJobList" border stripe>
        <el-table-column label="#" type="index"></el-table-column>
        <el-table-column label="ID" prop="jobId" width="300px"></el-table-column>
        <el-table-column label="名称" prop="jobName"></el-table-column>
        <el-table-column label="状态">
          <template slot-scope="scope">
            <el-switch v-model="scope.row.jobStatus" :active-value="1" :inactive-value="0"></el-switch>
          </template>
        </el-table-column>
        <el-table-column label="启动时间" prop="startTime"></el-table-column>
        <el-table-column label="并行度" prop="parallelism"></el-table-column>
        <el-table-column label="操作" width="150px">
          <template>
            <!-- 修改按钮 -->
            <el-button type="primary" icon="el-icon-edit" size="mini"></el-button>
            <!-- 删除按钮 -->
            <el-button type="danger" icon="el-icon-delete" size="mini"></el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
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
          pageSize: 2
        },
        batchJobList: [],
        total: 0
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
        this.batchJobList = res.data
      }
    }
  }
</script>

<style lang="less" scoped>
</style>
