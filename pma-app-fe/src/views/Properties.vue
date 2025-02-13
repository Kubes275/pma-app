<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { RouterLink } from 'vue-router'
import Property from '../types/Property'
import dataService from '../api/services/DataService.ts'
const fields = [
    'ID',
    'Typ',
    'Meno',
    'Mesto',
    'Adresa',
    'Počet izieb',
    'Rozloha',
]
const myProperties = ref<Property[]>([])
// computedProps
function getStreetNameNumberString(item: Property): string {
    return item.street + ' ' + item.streetNumber
}

function getIconBasedOnPropertyType(type: string): string {
    switch (type) {
        case 'House':
            return 'bi-house-fill'
        case 'Apartment':
            return 'bi bi-buildings-fill'
        case 'Garage':
            return 'bi bi-p-circle'
        default:
            return 'bi bi-shop'
    }
}
// lifecycle methods
onMounted(() => {
    dataService.getProperties().then((data) => {
        myProperties.value = data
    })
})
</script>

<template>
    <div>
        <h1>Zoznam nehnuteľností</h1>
        <table class="table table-striped table-sm table-bordered">
            <thead>
                <tr>
                    <th scope="col" v-for="field in fields">{{ field }}</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="property in myProperties" :key="property.id">
                    <th scope="row" class="id-col">{{ property.id }}</th>
                    <td>
                        <div class="icon-element text-primary">
                            <i :class="getIconBasedOnPropertyType(
                                property.propType
                            )
                                "></i>
                        </div>
                    </td>
                    <td>{{ property.name }}</td>
                    <td>{{ property.city }}</td>
                    <td>{{ getStreetNameNumberString(property) }}</td>
                    <td>{{ property.roomsNumber }}</td>
                    <td>{{ property.livingArea }} m²</td>
                    <td>
                        <router-link :to="{
                            name: 'PropertyDetails',
                            params: { id: property.id },
                        }">
                            <button type="button" class="btn btn-outline-primary btn-sm">
                                Detail
                            </button>
                        </router-link>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped lang="scss">
@import '../assets/style.scss';

.read-the-docs {
    color: #888;
}

h1 {
    text-align: left;
}

.id-col {
    width: $id-column-width;
}

.icon-element {
    //margin: $icon-text-margin;
    font-size: 18px;
}
</style>
