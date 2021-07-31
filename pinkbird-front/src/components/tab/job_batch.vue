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
        <el-table-column label="名称" prop="jobName" width="300px"></el-table-column>
        <el-table-column label="状态">
          <template slot-scope="scope">
            <el-switch v-model="scope.row.jobStatus" :active-value="1" :inactive-value="0"></el-switch>
          </template>
        </el-table-column>
        <el-table-column label="启动时间" prop="startTime"></el-table-column>
        <el-table-column label="并行度" prop="parallelism"></el-table-column>
        <el-table-column label="操作" width="200px">
          <template>
            <!-- 修改按钮 -->
            <el-button type="primary" icon="el-icon-edit" size="mini"></el-button>
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
        :page-sizes="[5, 10, 15, 20]"
        :page-size="queryInfo.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
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
          pageSize: 5
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
      }
    }
  }
</script>

<style lang="less" scoped>
</style>
