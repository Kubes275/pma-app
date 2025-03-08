import { createApp } from 'vue'
import './assets/style.scss'
import App from './App.vue'
import router from './router/index'
import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'

import '@mdi/font/css/materialdesignicons.css'

const vuetify = createVuetify({
	components,
	directives,
	icons: {
		defaultSet: 'mdi'
	},
})

createApp(App)
	.use(vuetify)
	.use(router)
	.mount('#app')
