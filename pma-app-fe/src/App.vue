<script setup lang="ts">
import { ref } from 'vue'

const theme = ref('light')

function onClick() {
    theme.value = theme.value === 'light' ? 'dark' : 'light'
}


const appTitle = 'PMA'
const menuItems = [
    { title: 'Dashboard', name: 'Dashboard', icon: 'mdi-view-dashboard' },
    { title: 'Properties', name: 'Properties', icon: 'mdi-home-city' },
    { title: 'Tenants', name: 'Tenants', icon: 'mdi-account-group' },
    { title: 'Contracts', name: 'Contracts', icon: 'mdi-file-document' },
    { title: 'Payments', name: 'Payments', icon: 'mdi-cash' },
    { title: 'Reports', name: 'Reports', icon: 'mdi-file-chart' },
]            
</script>

<template>
    <v-app :theme="theme">
            <v-toolbar app color="variant" mode="shift">
                <v-toolbar-title>
                    <router-link to="/" tag="span" style="cursor: pointer">
                        {{ appTitle }}
                    </router-link>
                </v-toolbar-title>
                <v-spacer></v-spacer>
                <v-toolbar-items class="hidden-xs-only">
                    <v-btn flat v-for="item in menuItems" :prepend-icon="item.icon" :text="item.title" :to="item.name"
                        class="nav-link" aria-current="page" key="item.name">
                    </v-btn>
                </v-toolbar-items>
                <v-spacer />
                <v-btn :prepend-icon="theme === 'light' ? 'mdi-weather-sunny' : 'mdi-weather-night'" text="Toggle Theme"
                    slim @click="onClick"></v-btn>
            </v-toolbar>
            <v-content>
                <router-view />
            </v-content>
            <Footer />
    </v-app>


    <!-- <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">PMA</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px">
                    <li class="nav-item">
                        <RouterLink :to="{ name: 'Dashboard' }" class="nav-link active" aria-current="page">
                            Dashboard
                        </RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink :to="{ name: 'Properties' }" class="nav-link" aria-current="page">
                            Properties
                        </RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink :to="{ name: 'Tenants' }" class="nav-link" aria-current="page">
                            Tenants
                        </RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink :to="{ name: 'Payments' }" class="nav-link" aria-current="page">
                            Payments
                        </RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink :to="{ name: 'Reports' }" class="nav-link" aria-current="page">
                            Reports
                        </RouterLink>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                    <button class="btn btn-outline-success" type="submit">
                        Search
                    </button>
                </form>
            </div>
        </div>
    </nav>
    <RouterView /> -->
</template>

<style scoped>
.logo {
    height: 6em;
    padding: 1.5em;
    will-change: filter;
    transition: filter 300ms;
}

.logo:hover {
    filter: drop-shadow(0 0 2em #646cffaa);
}

.logo.vue:hover {
    filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
