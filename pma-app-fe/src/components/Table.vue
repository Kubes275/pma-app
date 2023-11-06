<template>
  <h1>TEST</h1>
  <ul>
    <li v-for="item in data" :key="item.id">
      {{ item.name }}
    </li>

    <table class="table table-striped">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">First</th>
          <th scope="col">Last</th>
          <th scope="col">Handle</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="property in data" :key="property.id">
          <th scope="row">{{ property.id }}</th>
          <td>{{ property.name }}</td>
          <td>{{ property.propertyType.typeName }}</td>
          <td>{{ property.street }}</td>
        </tr>
      </tbody>
    </table>
  </ul>
  <iframe
    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2606.685666466907!2d18.734035677506448!3d49.20652227614317!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47145eb613856309%3A0xa86aab9d32d60f2a!2zUnXFvm92w6EgMTYzOC80MiwgMDEwIDAxIMW9aWxpbmE!5e0!3m2!1ssk!2ssk!4v1699133517178!5m2!1ssk!2ssk"
    width="800"
    height="600"
    style="border: 0"
    allowfullscreen=""
    loading="lazy"
    referrerpolicy="no-referrer-when-downgrade"
  ></iframe>
</template>

<script setup lang="ts">
import { ref, onMounted } from "vue";
import PmaAPI from "../api/resources/PmaAPI";
import { APISettings } from "../api/config";
import axios from "axios";
const studentData = [
  {
    ID: "01",
    Name: "Abiola Esther",
    Course: "Computer Science",
    Gender: "Female",
    Age: "17",
  },
  {
    ID: "02",
    Name: "Robert V. Kratz",
    Course: "Philosophy",
    Gender: "Male",
    Age: "19",
  },
  {
    ID: "03",
    Name: "Kristen Anderson",
    Course: "Economics",
    Gender: "Female",
    Age: "20",
  },
  {
    ID: "04",
    Name: "Adam Simon",
    Course: "Food science",
    Gender: "Male",
    Age: "21",
  },
  {
    ID: "05",
    Name: "Daisy Katherine",
    Course: "Business studies",
    Gender: "Female",
    Age: "22",
  },
];
const fields = ["ID", "Name", "Course", "Gender", "Age"];
const data = ref({});
onMounted(() => {
  axios.get(APISettings.baseUrl + "/properties").then((response) => {
    //console.log(response)
    data.value = response.data;
    console.log(data.value);
  });
});
</script>

<style scoped></style>
