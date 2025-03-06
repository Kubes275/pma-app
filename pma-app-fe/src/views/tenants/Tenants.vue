<script setup lang="ts">
import { ref, onMounted } from 'vue'
import Tenant from '../../types/Tenant.ts'
import dataService from '../../api/services/DataService.ts'

const fields = [
	{ title: 'Meno', key: 'firstname' },
	{ title: 'Priezvisko', key: 'surname' },
	{ title: 'Telefón', key: 'phone' },
	{ title: 'Email', key: 'email' }
]
const myTenants = ref<Tenant[]>([])
onMounted(() => {
	dataService.getTenants().then((data) => {
		myTenants.value = data
	})
})
</script>
<template>
	<v-container>
        <div class="text-h4 font-weight-thin text-uppercase text-center pa-3">Zoznam nájomníkov</div>
		<v-data-table
			:items="myTenants"
			:headers="fields"></v-data-table>
	</v-container>
</template>