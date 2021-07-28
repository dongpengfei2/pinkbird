<template>
    <el-container class="home-container">
        <!-- 页面头部 -->
        <el-header>
            <div>
                <img src="../assets/yellowbird.png" alt="" height="60px">
                <span>Hadoop作业管理平台</span>
            </div>
             <el-button type='info' @click="logout">退出</el-button>
        </el-header>
        <!-- 页面主体区域 -->
        <el-container>
            <!-- 侧边栏菜单区 -->
            <el-aside :width="isCollapse ? '64px' : '200px'">
                <div class="toggle-button" @click="toggleCollapse">|||</div>
                <!-- 侧边栏菜单区域 -->
                <el-menu background-color="#333744" text-color="#fff" active-text-color="#409EFF" unique-opened :collapse="isCollapse" :collapse-transition="false" router>
                <!-- 一级菜单 -->
                <el-submenu :index="item.id + ''" v-for="item in menuList" :key="item.id">
                    <!-- 一级菜单模板区 -->
                    <template slot="title">
                        <!-- 图标 -->
                        <i :class="item.icon"></i>
                        <!-- 文本 -->
                        <span>{{item.name}}</span>
                    </template>
                    <!-- 二级菜单 -->
                    <el-menu-item :index="subItem.url" v-for="subItem in item.nodes" :key="subItem.id">
                        <!-- 二级菜单模板区 -->
                        <template slot="title">
                            <!-- 图标 -->
                            <i class="el-icon-menu"></i>
                            <!-- 文本 -->
                            <span>{{subItem.name}}</span>
                        </template>
                    </el-menu-item>
                </el-submenu>
                </el-menu>
            </el-aside>
            <el-main>
                <!-- 路由占位符 -->
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
export default {
    data () {
        return {
            // 左侧菜单数据
            menuList: [{
                id: 1,
                name: '作业列表',
                icon: 'iconfont icon-hexin',
                url: '/flink/job',
                nodes: [{
                        id: 11,
                        name: 'JAR任务',
                        url: '/job/batch'
                    },
                    {
                        id: 12,
                        name: 'SQL任务',
                        url: '/job/stream'
                    }
                ]
            },
            {
                id: 2,
                name: '系统管理',
                icon: 'iconfont icon-yunwei',
                url: '/sys/config',
                nodes: [{
                        id: 21,
                        name: '系统设置',
                        url: '/config/user'
                    },
                    {
                        id: 22,
                        name: '操作日志',
                        url: '/config/log'
                    }
                ]
            }
            ],
            // 是否折叠
            isCollapse: false
        }
    },
    created () {
    },
    methods: {
        logout () {
            window.sessionStorage.clear()
            this.$router.push('/login')
        },
        // 点击按钮，切换菜单的折叠与展开
        toggleCollapse () {
            this.isCollapse = !this.isCollapse
        }
    }
}
</script>

<style lang='less' scoped>
.home-container {
    height: 100%;
}
.el-header {
    background-color: #373d41;
    display: flex;
    justify-content: space-between;
    padding-left: 0;
    align-items: center;
    color: #fff;
    font-size: 20px;
    > div {
        display: flex;
        align-items: center;
        span {
            margin-left: 15px;
        }
    }
}
.el-aside {
    background-color: #333744;
    .el-menu {
        border-right: none;
    }
}
.el-main {
    background-color: #eaedf1;
}
.iconfont {
    margin-right: 10px;
}
.toggle-button {
    background-color: #4a5064;
    font-size: 10px;
    line-height: 24px;
    color: #fff;
    text-align: center;
    letter-spacing: 0.2em;
    cursor: pointer;
}
</style>
