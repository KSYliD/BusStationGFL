<script>
import RoutePage from "@/components/routes/RoutePage.vue";
import axios from "axios";
import RouteEditorComponent from "@/components/routes/RouteEditorPage.vue";
import Bus from "@/components/buses/BusPage.vue";
import BusEditorComponent from "@/components/buses/BusEditorPage.vue";

import {role} from "@/role.js"


export default {
  name: "BusList",
  components: {BusEditorComponent, Bus, RouteEditorComponent, RoutePage},
  data() {
    return {
      busList: Array
    }
  },
  beforeMount() {
    this.getRoutes()
  },
  methods: {
    async getRoutes() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get('http://localhost:8080/buses', {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.busList = axiosResponse.data;
      console.log(this.busList)
    },
    role,
  }
}
</script>

<template>
  <div v-if="role('Admin')">
    <BusEditorComponent/>
  </div>
  <div class="route-list">
    <Bus v-for="bus in busList" v-bind:key="bus.id" :bus="bus"/>
  </div>
</template>

<style scoped>

</style>