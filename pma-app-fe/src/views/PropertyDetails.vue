<template>
    <div>
        <div class="container mt-4">
            <div class="row">
                <div class="col text-left">
                    <h1>{{ propertyDisplayName }}</h1>
                    <h6>{{ propertyRegionDisplayName }}</h6>
                    <hr class="my-4" />
                </div>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
import { onMounted, ref, computed } from 'vue'
import { useRoute } from 'vue-router'
import { APISettings } from '../api/config'
import Property from '../types/Property'
import axios from 'axios'

const route = useRoute()
const propertyId = route.params.id
const propertyData = ref<Property | null>(null)

onMounted(() => {
    console.log(propertyId)
    try {
        axios
            .get(APISettings.baseUrl + '/properties/' + propertyId)
            .then((response) => {
                //console.log(response.data)
                propertyData.value = response.data
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
<style scoped>
.wrapper {
    margin: 50px;
}
</style>
