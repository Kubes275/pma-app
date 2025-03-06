<template>
	<div>
		<div class="container mt-4">
			<div class="row">
				<div class="col text-left">
					<h1>{{ propertyData?.name }}</h1>
				</div>
				<div v-if="propertyData" class="property-container">
					<div class="property-header">
						<p class="property-type">Type: {{ propertyData.propType }}</p>
					</div>
					<div class="property-info">
						<h6>{{ propertyDisplayName }} ({{ propertyRegionDisplayName }})</h6>
						<p><strong>Description:</strong> {{ propertyData.description }}</p>
						<p><strong>Rooms:</strong> {{ propertyData.roomsNumber }}</p>
						<p><strong>Living Area:</strong> {{ propertyData.livingArea }} m²</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script setup lang="ts">
import { onMounted, ref, computed } from 'vue'
import { useRoute } from 'vue-router'
import Property from '../../types/Property.ts'
import dataService from '../../api/services/DataService.ts'

const route = useRoute()
const propertyId = route.params.id as string
const propertyData = ref<Property | null>(null)

onMounted(() => {
	console.log(propertyId)
	try {
		dataService.getProperty(parseInt(propertyId)).then((data) => {
			propertyData.value = data
		})
	} catch (error) {
		console.error('Error fetching data: ', error)
	}
})

const propertyDisplayName = computed(() => {
	const { street, streetNumber, city } = propertyData.value || {}
	return `${street || ''} ${streetNumber || ''}, ${city || ''}`
})

const propertyRegionDisplayName = computed(() => {
	const { region, country } = propertyData.value || {}
	return `${region || ''}, ${country || ''} `
})
</script>


<!--
<template>
	<Layout>
		<h1>Property Details</h1>
		<div v-if="property" class="property-container">
			<div class="property-header">
				<h2>{{ property.name }}</h2>
				<p class="property-type">Type: {{ property.propType }}</p>
			</div>
			<div class="property-info">
				<p><strong>Description:</strong> {{ property.description }}</p>
				<p><strong>Location:</strong> {{ property.street }} {{ property.streetNumber }}, {{ property.city }}, {{ property.region }}, {{ property.country }}</p>
				<p><strong>Rooms:</strong> {{ property.roomsNumber }}</p>
				<p><strong>Living Area:</strong> {{ property.livingArea }} m²</p>
			</div>
		</div>
	</Layout>
</template>

<script>
import Layout from '@/components/Layout.vue';
import DataService from '@/services/DataService.ts';
export default {
	components: { Layout },
	props: ['id'],
	data() {
		return {
			property: null
		};
	},
	async mounted() {
		this.property = await DataService.getPropertyById(this.id);
	}
};
</script>

-->
<style scoped>
.property-container {
	padding: 20px;
	border: 1px solid #ddd;
	border-radius: 8px;
	background: #f9f9f9;
}
.property-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	border-bottom: 2px solid #ddd;
	padding-bottom: 10px;
	margin-bottom: 10px;
}
.property-type {
	font-style: italic;
	color: #555;
}
.property-info p {
	margin: 5px 0;
}
</style>