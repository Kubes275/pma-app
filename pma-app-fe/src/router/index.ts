import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        name: 'properties',
        component: () => import('@views/Properties.vue'),
    },
    {
        path: '/properties',
        name: 'properties2',
        component: () => import('@views/Properties.vue'),
    },
    {
        path: '/properties/:id',
        name: 'PropertyDetails',
        component: () => import('@views/PropertyDetails.vue'),
    },
]

const router = createRouter({
    routes,
    history: createWebHistory(),
})

export default router
