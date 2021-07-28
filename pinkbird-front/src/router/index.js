import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import Home from '../components/Home.vue'
import Welcome from '../components/Welcome.vue'
import BatchJob from '../components/tab/job_batch.vue'
import StreamJob from '../components/tab/job_stream.vue'
import UserConfig from '../components/tab/conf_user.vue'
import LogConfig from '../components/tab/conf_log.vue'

Vue.use(VueRouter)

const routes = [
  { path: '/', redirect: '/login' },
  { path: '/login', component: Login },
  { path: '/home', component: Home, redirect: '/welcome', children: [{ path: '/welcome', component: Welcome }, { path: '/job/batch', component: BatchJob }, { path: '/job/stream', component: StreamJob }, { path: '/config/user', component: UserConfig }, { path: '/config/log', component: LogConfig }] }
]

const router = new VueRouter({
  routes
})
// 挂载路由导航守卫
router.beforeEach((to, from, next) => {
  // to将要访问的路径
  // from 代表从哪个路径而来
  // next 是一个函数，表示放行
  // next（）放行，next('/login')强制跳转
  if (to.path === '/login') return next()
  // 获得token
  const tokenStr = window.sessionStorage.getItem('token')
  if (!tokenStr) return next('/login')
  next()
})

export default router
