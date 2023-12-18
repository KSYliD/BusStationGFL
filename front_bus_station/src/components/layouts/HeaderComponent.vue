<template>
  <header v-if="token!=null">
    <img src="@/assets/images/logo.png" width="50" height="50" alt="">
    <router-link to="/">Home</router-link>
    <router-link to="/my-journeys">My tickets</router-link>
<!--    <router-link to="/journeys-editor" v-if="role('Admin')"  >Journeys editor</router-link>-->
    <router-link to="/journeys">Journeys</router-link>
<!--    <router-link to="/routes-editor" v-if="role('Admin')"  >Routes editor</router-link>-->
    <router-link to="/buses">Buses</router-link>
<!--    <router-link to="/buses-editor" v-if="role('Admin')" >Buses editor</router-link>-->
    <router-link to="/routes" v-if="role('Admin')"  >Routes</router-link>
    <router-link to="/logout">Logout</router-link>
  </header>
  <header v-else>
    <img src="@/assets/images/logo.png" width="50" height="50" alt="">
    <router-link to="/">Home</router-link>
    <router-link to="/login">Login</router-link>
    <router-link to="/register">Register</router-link>
  </header>
</template>
<script>
import {role} from "@/role.js"

export default {
  name: "HeaderComponent",
  props: {
    token: {
      type: String,
      required: true
    }
  },
  methods: {
    role,
  },
}
</script>

<style scoped>
header {
  display: flex;
  width: 100%;
  height: 50px;
  color: black;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
  background-color: dodgerblue;
}

</style>