import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
    { path: '/', name: 'Dashboard', component: () => import('@views/Dashboard.vue') },
    { path: '/properties', name: 'Properties', component: () => import('@views/properties/Properties.vue') },
    { path: '/properties/:id', name: 'PropertyDetails', component: () => import('@views/properties/PropertyDetails.vue'), props: true },
    { path: '/tenants', name: 'Tenants', component: () => import('@views/tenants/Tenants.vue') },
    // { path: '/tenants/:id', component: () => import('@views/tenants/TenantDetails.vue'), props: true },
    { path: '/contracts', name: 'Contracts', component: () => import('@views/contracts/Contracts.vue') },
    { path: '/payments', name: 'Payments', component: () => import('@views/payments/Payments.vue') },
    // { path: '/expenses', component: () => import('@views/payments/Expenses.vue') },
    { path: '/reports', name: 'Reports', component: () => import('@views/Reports.vue') },
    // { path: '/maintenance', component: () => import('@views/maintenance/MaintenanceRequests.vue') },
    // { path: '/vendors', component: () => import('@views/maintenance/Vendors.vue') },
    // { path: '/notifications', component: () => import('@views/Notifications.vue') },
    // { path: '/settings', component: () => import('@views/Settings.vue') },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;