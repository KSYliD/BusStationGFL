<script>
import RoutePage from "@/components/routes/RoutePage.vue";
import axios from "axios";
import RouteEditorComponent from "@/components/routes/RouteEditorPage.vue";

import {role} from "@/role.js"


export default {
  name: "RouteList",
  components: {RouteEditorComponent, RoutePage},
  data() {
    return {
      routeList: Array
    }
  },
  beforeMount() {
    this.getRoutes()
  },
  methods: {
    async getRoutes() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get('http://localhost:8080/routes', {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.routeList = axiosResponse.data;
      console.log(this.routeList)
    },
    role
  }
}
</script>

<template>
  <div v-if="role('Admin')">
    <RouteEditorComponent/>
  </div>
  <div class="route-list">
    <RoutePage v-for="route in routeList" v-bind:key="route.id" :route="route"/>
  </div>
</template>

<style scoped>

</style>