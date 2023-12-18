<template>
  <div>
  <form @submit="saveRoute()"
        class="login">
    <label for="routeNum">Route Num</label>
    <input type="text" v-model="data.number" required>
    <small id="nameErrors"
           class="error"
           v-if="errors.routeNum.length>0">
      {{ errors.routeNum.reduce((prev, curr) => prev + ", " + curr) }} </small>

    <br>
    <br>

    <form @submit.prevent="addBusStop()" class="login">

      <ul>
        <li v-for="busStop in data.stops" :key="busStop.id">
          <span>City: {{ busStop.city.name }};</span>
          <span> Address: {{ busStop.address }}; </span>
          <span> Time: {{ busStop.time }}</span>
        </li>
      </ul>
      <select v-model="data.city.name">
        <option disabled value="">City</option>
        <option v-for="city in data.cities">{{ city.name }}</option>
      </select>
      <label for="address">Address</label>
      <input type="text" v-model="data.address" required><br>
      <label for="time">Time</label>
      <input type="text" v-model="data.time" required><br>
      <button class="button" type="submit">Add bus stop</button>

    </form>

    <button class="button" type="submit">Create route</button>
        <small id="apiErrors" class="error" v-if="errors.api.length>0">
          {{ errors.api.reduce((prev, curr) => prev + ", " + curr) }}</small>
  </form>
  </div>
</template>

<script>
import axios from 'axios';
import {mask} from 'vue-the-mask'


export default {
  name: "RouteEditorComponent",
  directives: {mask},
  data() {
    return {
      errors: {
        routeNum: [],
        busStops: [],
        api: []
      },
      data: {
        number: '',
        stops: [],
        city: {
          id: 0,
          name: ''
        },
        address: '',
        time: '',
        cities: []

      }
    }
  },
  beforeMount() {
    this.getAllCities();
  },
  methods: {
    addBusStop() {
      this.data.stops.push(
          {city: {name: this.data.city.name}, address: this.data.address, time: this.data.time}
      );
      console.log(this.data.stops)
    },
    async saveRoute() {
      const item = localStorage.getItem("token");
      const route = {
        number: this.data.number,
        stops: this.data.stops
      };
      let data = JSON.stringify(route);
      console.log(data)
      const axiosResponse = await axios.post('http://localhost:8080/routes', data, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      });
      if (axiosResponse.status === 200) {
        this.$router.push('/routes');
      }
    },
    async getAllCities() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get('http://localhost:8080/cities', {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.data.cities = axiosResponse.data;
      console.log(this.data.cities)
    }
    ,
    validate() {

    }
  }
}
</script>
<style scoped>
div {
  display: flex;
  justify-content: center;
}

input {
  border: 1px solid #ddd;
  padding: 5px;

}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 5%;
  width: 50%;
  padding: 20px;
  background-color: white;
  border: 2px solid royalblue;


}

.button {
  display: inline-block;
  padding: 15px 25px;
  margin: 3% 5% 1% 5%;
  font-size: 15px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: royalblue;
  border: none;
  border-radius: 20px;
  box-shadow: 0 9px #999;
}

.button:hover {
  background-color: skyblue
}

.button:active {
  background-color: royalblue;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
</style>