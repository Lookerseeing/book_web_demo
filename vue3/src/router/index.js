import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import { CookEditor, createCookEditorState} from "vue-cook"
import "vue-cook/dist/style.css"

const cookEditorState = createCookEditorState() // 创建编辑器全局状态

const routes = [
  {
    path: '/vue3',
    name: 'vue3',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/',
    name: 'index',
    component: () => import('../views/Index.vue')
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('../views/Home.vue')
  },
  {
    path: '/c',
    name: '123',
    component: () => import('../views/UserinfoPage.vue')
  },{
    path: '/a',
    name: '3',
    component: () => import('../views/aaa.vue')
  },{
    path: '/b',
    name: '12',
    component: () => import('../views/bbb.vue')
  },
  {
    path: '/vue-cook', // 自定义的地址
    component: CookEditor,
    props: route => ({
      state: cookEditorState,  // 传入状态
      preview: route.query.preview // 是否预览
    })
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
