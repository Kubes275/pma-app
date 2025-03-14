import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue()],
    resolve: {
        alias: {
            '@views': path.resolve(__dirname, 'src/views'),
        },
    },
    server: {
        port: 5000,
    },
})
