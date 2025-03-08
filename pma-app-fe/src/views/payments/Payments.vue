<script setup lang="ts">
import { ref, onMounted } from 'vue'

const fields = [
    'ID',
    'Typ',
    'Meno',
    'Mesto',
    'Adresa',
    'Počet izieb',
    'Rozloha',
]
const payments = ref<any>([])
</script>
<template>
	<div class="container mt-4">
		<h1>Zoznam platieb</h1>
		<table class="table table-striped table-sm table-bordered">
			<thead>
				<tr>
					<th scope="col" v-for="field in fields">{{ field }}</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="tenant in payments" :key="tenant.id">
					<th scope="row" class="id-col">{{ tenant.id }}</th>
					<td>{{ tenant.name }}</td>
					<td>{{ tenant.surname }}</td>
					<td>{{ tenant.email }}</td>
					<td>{{ tenant.phone }}</td>
					<td>{{ tenant.birthDate }}</td>
				</tr>
			</tbody>
		</table>
	</div>
</template>