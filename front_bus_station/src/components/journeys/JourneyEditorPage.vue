<template>
  <div>
  <form @submit="saveJourney()"
        class="login">


    <select v-model="data.route.number">
      <option disabled value="">Route</option>
      <option v-for="route in data.routes">{{ route.number }}</option>
    </select><br>

    <select v-model="data.bus.licensePlate">
      <option disabled value=""> Bus</option>
      <option v-for="bus in data.buses">{{ bus.licensePlate }}</option>
    </select><br>

    <input type="text" v-model="journey.date" placeholder="Date: day-month-year"  required>
    <button class="button" type="submit">Create journey</button>
  </form>
  </div>
</template>

<script>
import axios from 'axios';
import {mask} from 'vue-the-mask'


export default {
  name: "JourneyEditorComponent",
  directives: {mask},
  data() {
    return {
      errors: {
        routeNum: [],
        busStops: [],
        api: []
      },
      data: {
        routes: [],
        buses: [],
        route: {
          number: ''
        },
        bus: {
          licensePlate: ''
        }
      },
      journey:{
        date: '',
      },

    }
  },
  beforeMount() {
    this.getAllRoutes();
    this.getAllBuses();
  },
  methods: {
    async getAllRoutes() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get('http://localhost:8080/routes', {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.data.routes = axiosResponse.data;
    }
    ,
    async getAllBuses() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get('http://localhost:8080/buses', {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.data.buses = axiosResponse.data;
    },
    async saveJourney() {
      const item = localStorage.getItem("token");
      let theRoute;
      let theBus;
      for (let i = 0; i < this.data.routes.length; i++) {
        if (this.data.routes[i].number === this.data.route.number) {
          theRoute = this.data.routes[i]
        }
      }
      for (let i = 0; i < this.data.buses.length; i++) {
        if (this.data.buses[i].licensePlate === this.data.bus.licensePlate) {
          theBus = this.data.buses[i]
        }
      }
      const journey = {
        route: theRoute,
        bus: theBus
      };
      let data = JSON.stringify(journey);
      console.log(data)
      const journeyResponse = await axios.post('http://localhost:8080/journeys', data, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      });

      const generateSeatsRequestDto = {
        date: this.journey.date,
        bus: theBus,
        journeyDto: journeyResponse.data
      };
      let theData = JSON.stringify(generateSeatsRequestDto);
      console.log(theData)
      const axiosResponse = await axios.post('http://localhost:8080/seats/generateSeats', theData, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      });
      console.log(axiosResponse.data)
    },
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