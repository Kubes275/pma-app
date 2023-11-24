<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { RouterLink } from 'vue-router'
import { APISettings } from '../api/config'
import Property from '../types/Property'
import axios from 'axios'
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
    console.log('TEST')
    return item.street + ' ' + item.streetNumber
}

function getIconBasedOnPropertyType(type: string): string {
    console.log('Icon', type)
    console.log(type)
    switch (type) {
        case 'Dom':
            return 'bi-house-fill'
        case 'Byt':
            return 'bi bi-buildings-fill'
        case 'Garáž':
            return 'bi bi-p-circle'
        default:
            return 'bi bi-shop'
    }
}
// lifecycle methods
onMounted(() => {
    axios.get(APISettings.baseUrl + '/properties').then((response) => {
        if (Array.isArray(response.data)) {
            console.log(response.data)
            myProperties.value = response.data.map((propItem) => ({
                ...propItem,
                propType: propItem.propertyType.name,
                roomsNumber: propItem.roomsNum,
            }))
        }
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
                            <i
                                :class="
                                    getIconBasedOnPropertyType(
                                        property.propType
                                    )
                                "
                            ></i>
                        </div>
                    </td>
                    <td>{{ property.name }}</td>
                    <td>{{ property.city }}</td>
                    <td>{{ getStreetNameNumberString(property) }}</td>
                    <td>{{ property.roomsNumber }}</td>
                    <td>{{ property.livingArea }} m²</td>
                    <td>
                        <router-link
                            :to="{
                                name: 'PropertyDetails',
                                params: { id: property.id },
                            }"
                        >
                            <button
                                type="button"
                                class="btn btn-outline-primary btn-sm"
                                href=""
                            >
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
