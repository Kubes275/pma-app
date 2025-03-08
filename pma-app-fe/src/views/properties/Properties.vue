<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { RouterLink } from 'vue-router'
import Property from '../../types/Property.ts'
import dataService from '../../api/services/DataService.ts'
const fields = [
    'ID',
    'Typ',
    'Meno',
    'Mesto',
    'Adresa',
    'Počet izieb',
    'Rozloha',
]
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
const myProperties = ref<Property[]>([])
// lifecycle methods
onMounted(() => {
    dataService.getProperties().then((data) => {
        myProperties.value = data
    })
})
</script>

<template>
    <v-container>
        <div class="text-h4 font-weight-thin text-uppercase text-center pa-3">Zoznam nehnuteľností</div>
        <v-row v-if="myProperties">
            <v-col v-for="property in myProperties" :key="property.id" cols="12" md="4">
                <v-card class="mb-auto" color="flat">
                    <v-card-title>
                        <v-icon>{{ getIconBasedOnPropertyType(property.propType) }}</v-icon>
                        <span>{{ property.name }}</span>
                    </v-card-title>
                    <v-card-text>
                        <p>{{ property.city }}</p>
                        <p>{{ getStreetNameNumberString(property) }}</p>
                        <p>{{ property.roomsNumber }}</p>
                        <p>{{ property.livingArea }} m²</p>
                    </v-card-text>
                    <v-card-actions>
                        <RouterLink :to="{ name: 'PropertyDetails', params: { id: property.id }, }">
                            <v-btn color="primary">Detail</v-btn>
                        </RouterLink>
                    </v-card-actions>
                </v-card>
            </v-col>
        </v-row>
        <v-row v-else class="text-center">
            <v-progress-circular
                color="primary"
                indeterminate
              ></v-progress-circular>
        </v-row>
    </v-container>
</template>

<style scoped lang="scss">
@import '../../assets/style.scss';

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