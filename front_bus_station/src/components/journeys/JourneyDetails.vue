<template>
  <div v-if="theAvailableSeats > 0" class="journey">
    <h3>{{ journey.route.number }}</h3>
    <p v-for="stop in journey.route.stops">{{ stop.city.name }} : {{ stop.time }}</p><br>
    <p>Available seats: {{theAvailableSeats}}</p>
    <router-link class="button" :to="`/${journey.bus.busType}/` +journey.id" >Buy ticket</router-link>
  </div>
</template>

<script>
import journeyList from "./JourneyList.vue";
import axios from "axios";

export default {
  name: "Journey",
  props: {
    journey: {
      id: '',
      bus: {},
      route: {
        stops: []
      }
    },
  },
  data(){
    return{
      theAvailableSeats: ''
    }
  },
  computed: {
    journeyList() {
      return journeyList
    },
  },
  mounted() {
    this.availableSeats()
  }
  ,
  methods:{
    async availableSeats() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get(`http://localhost:8080/seats/FREE/${this.journey.bus.id}/${this.journey.id}` , {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.theAvailableSeats = axiosResponse.data;
    },
  }
};
</script>

<style scoped>
.journey {
  width: 20%;
  height: 300px;
  padding: 20px;
  background-color: white;
  border: 2px solid royalblue;
  float: left;
  margin: 10px;
  font-size: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
  align-items: center;

}

.journey p {
  margin: 0;

}

.button {
  display: inline-block;
  margin: 20%;
  padding: 15px 25px;
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

.button:hover {background-color: skyblue}

.button:active {
  background-color: royalblue;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
</style>