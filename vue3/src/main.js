import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import zhCn from 'element-plus/es/locale/lang/zh-cn'

import global from './assets/css/global.css'



const app = createApp(App)
app.use(store)
app.use(router)
app.use(global)

app.use(ElementPlus, {
  locale: zhCn,
})

app.mount('#app')
