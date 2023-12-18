<template>
  <div v-if="role('Admin')">
    <JourneyEditorComponent/>
  </div>
  <div class="route-list">
    <JourneyDetails v-for="journey in journeyList" v-bind:key="journey.id" :journey="journey"/>
  </div>
</template>
<script>
import JourneyDetails from "@/components/journeys/JourneyDetails.vue";
import axios from "axios";
import JourneyEditorComponent from "@/components/journeys/JourneyEditorPage.vue";

import {role} from "@/role.js"


export default {
  name: "JourneyList",
  components: {JourneyEditorComponent, JourneyDetails},
  data() {
    return {
      journeyList: Array
    }
  },
  beforeMount() {
    this.getRoutes()
  },
  methods: {
    async getRoutes() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get('http://localhost:8080/journeys', {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.journeyList = axiosResponse.data;
      console.log(this.journeyList)
    },
    role
  }
}
</script>

<style scoped>
.route-list {
  min-height: 680px;
}
</style>