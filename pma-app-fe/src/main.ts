import { createApp } from 'vue'
import './assets/style.scss'
import App from './App.vue'
import router from './router/index'

createApp(App).use(router).mount('#app')
