import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import Home from '../components/Home.vue'
import Welcome from '../components/Welcome.vue'
import Tab885 from '../components/tab/Tab_885.vue'
import Tab376 from '../components/tab/Tab_376.vue'
import Tab774 from '../components/tab/Tab_774.vue'
import Tab4349 from '../components/tab/Tab_4349.vue'

Vue.use(VueRouter)

const routes = [
  { path: '/', redirect: '/login' },
  { path: '/login', component: Login },
  { path: '/home', component: Home, redirect: '/welcome', children: [{ path: '/welcome', component: Welcome }, { path: '/tab_885', component: Tab885 }, { path: '/tab_376', component: Tab376 }, { path: '/tab_774', component: Tab774 }, { path: '/tab_4349', component: Tab4349 }] }
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
