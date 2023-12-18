<template>
  <div>
    <form @submit.prevent="addBus()" class="login">

      <select v-model="data.driverParams.email">
        <option disabled value="">Driver</option>
        <option v-for="driver in data.drivers">{{ driver.email }}</option>
      </select><br>

      <label for="licensePlate">License plate</label>
      <input type="text" v-model="data.licensePlate" required><br>

      <select v-model="data.busType">
        <option disabled value="">Bus type</option>
        <option v-for="busType in data.busTypes">{{ busType }}</option>
      </select><br>

      <button class="button" type="submit">Add bus</button>

    </form>
  </div>
</template>

<script>
import axios from 'axios';
import {mask} from 'vue-the-mask'


export default {
  name: "BusEditorComponent",
  directives: {mask},
  data() {
    return {
      errors: {
        routeNum: [],
        busStops: [],
        api: []
      },
      data: {
        driver: {
          // id: '',
          // firstName: '',
          // secondName: '',
          // role: '',
          // phoneNumber: '',

        },
        licensePlate: '',
        drivers: [],
        busTypes: [],
        busType: '',
        driverParams: {
          email: ''
        }
      }
    }
  },
  beforeMount() {
    this.getDrivers();
    this.getAllBusTypes();
  },
  methods: {
    async addBus() {
      const item = localStorage.getItem("token");
      const axiosUserResponse = await axios.get(`http://localhost:8080/users/email/${this.data.driverParams.email}`, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.data.driver = axiosUserResponse.data;
      const bus = {
        driver: this.data.driver,
        licensePlate: this.data.licensePlate,
        busType: this.data.busType
      };
      let data = JSON.stringify(bus);
      console.log(data)
      const axiosResponse = await axios.post('http://localhost:8080/buses', data, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      });
      if (axiosResponse.status === 200) {
        this.$router.push('/buses');
      }
    },


    async getAllBusTypes() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get('http://localhost:8080/buses/types', {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.data.busTypes = axiosResponse.data;
    },


    async getUser() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get(`http://localhost:8080/users/email/${this.data.driverParams.email}`, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.data.driver = axiosResponse.data;
      console.log(this.data.driver)
      return axiosResponse.data;
    },


    async getDrivers() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get('http://localhost:8080/users/Driver', {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.data.drivers = axiosResponse.data;
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