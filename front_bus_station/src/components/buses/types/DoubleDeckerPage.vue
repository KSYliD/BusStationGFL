<script>
import RoutePage from "@/components/routes/RoutePage.vue";
import axios from "axios";

export default {
  name: "DoubleDecker",
  components: {RoutePage},
  data() {
    return {
      seats: Array,
      journey: {
        route: {},
        bus: {
          id: '',
        },
      },
    }
  },
  beforeMount() {
    this.findSeatsByBusId();
    this.findJourneyById()
  },
  methods: {
    async findSeatsByBusId() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get(`http://localhost:8080/seats/${this.journey.bus.id}`, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.seats = axiosResponse.data;
      console.log(this.seats)
    },
    async findJourneyById() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get(`http://localhost:8080/journeys/${this.$route.params.id}`, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.journey = axiosResponse.data;
      console.log(this.journey)
    },
  }
}
</script>

<template>
  <h1>Select your seat</h1>
  <h2 style="top: 15%; left: 35%;">Ground Floor</h2>
  <div class="ground" style="top: 0;">
    <router-link class="seat" style="top: 10%; left: 10%;" :to="`/submit-ticket/${1}${this.$route.params.id}`">1
    </router-link>
    <router-link class="seat" style="top: 10%; left: 25%;" :to="`/submit-ticket/${2}${this.$route.params.id}`">2
    </router-link>
    <router-link class="seat" style="top: 10%; left: 40%;" :to="`/submit-ticket/${3}${this.$route.params.id}`">3
    </router-link>
    <router-link class="seat" style="top: 10%; left: 55%;" :to="`/submit-ticket/${4}${this.$route.params.id}`">4
    </router-link>
    <router-link class="seat" style="top: 10%; left: 70%;" :to="`/submit-ticket/${5}${this.$route.params.id}`">5
    </router-link>
    <router-link class="seat" style="top: 10%; left: 85%;" :to="`/submit-ticket/${6}${this.$route.params.id}`">6
    </router-link>
    <router-link class="seat" style="top: 65%; left: 10%;;" :to="`/submit-ticket/${7}${this.$route.params.id}`">7
    </router-link>
    <router-link class="seat" style="top: 65%; left: 25%;" :to="`/submit-ticket/${8}${this.$route.params.id}`">8
    </router-link>
    <router-link class="seat" style="top: 65%; left: 40%;" :to="`/submit-ticket/${9}${this.$route.params.id}`">9
    </router-link>
    <router-link class="seat" style="top: 65%; left: 55%;" :to="`/submit-ticket/${10}${this.$route.params.id}`">10
    </router-link>
    <router-link class="seat" style="top: 65%; left: 70%;" :to="`/submit-ticket/${11}${this.$route.params.id}`">11
    </router-link>
    <router-link class="seat" style="top: 65%; left: 85%;" :to="`/submit-ticket/${12}${this.$route.params.id}`">12
    </router-link>
  </div>
  <h2 style="top: 55%; left: 35%;">First Floor</h2>
  <div class="first" style="top: 40%;">
    <router-link class="seat" style="top: 10%; left: 10%;" :to="`/submit-ticket/${13}${this.$route.params.id}`">13
    </router-link>
    <router-link class="seat" style="top: 10%; left: 25%;" :to="`/submit-ticket/${14}${this.$route.params.id}`">14
    </router-link>
    <router-link class="seat" style="top: 10%; left: 40%;" :to="`/submit-ticket/${15}${this.$route.params.id}`">15
    </router-link>
    <router-link class="seat" style="top: 10%; left: 55%;" :to="`/submit-ticket/${16}${this.$route.params.id}`">16
    </router-link>
    <router-link class="seat" style="top: 10%; left: 70%;" :to="`/submit-ticket/${17}${this.$route.params.id}`">17
    </router-link>
    <router-link class="seat" style="top: 10%; left: 85%;" :to="`/submit-ticket/${18}${this.$route.params.id}`">18
    </router-link>
    <router-link class="seat" style="top: 65%; left: 10%;;" :to="`/submit-ticket/${19}${this.$route.params.id}`">19
    </router-link>
    <router-link class="seat" style="top: 65%; left: 25%;" :to="`/submit-ticket/${20}${this.$route.params.id}`">20
    </router-link>
    <router-link class="seat" style="top: 65%; left: 40%;" :to="`/submit-ticket/${21}${this.$route.params.id}`">21
    </router-link>
    <router-link class="seat" style="top: 65%; left: 55%;" :to="`/submit-ticket/${22}${this.$route.params.id}`">22
    </router-link>
    <router-link class="seat" style="top: 65%; left: 70%;" :to="`/submit-ticket/${23}${this.$route.params.id}`">23
    </router-link>
    <router-link class="seat" style="top: 65%; left: 85%;" :to="`/submit-ticket/${24}${this.$route.params.id}`">24
    </router-link>
  </div>

</template>

<style scoped>

h1 {
  display: flex;
  justify-content: center;
}

h2 {
  position: absolute;
}

.ground {
  background-color: white;
  margin: 15%;
  height: 40ex;
  width: 80ex;
  position: absolute;
  border-radius: 70px;
  border: 2px solid royalblue;
}

.first {
  background-color: white;
  margin: 15%;
  height: 40ex;
  width: 80ex;
  position: absolute;
  border-radius: 70px;
  border: 2px solid royalblue;
}

.seat {
  background-color: royalblue;
  height: 20%;
  width: 10%;
  border-radius: 50%;
  position: absolute;
  display: flex;
  justify-content: center;
  align-items: center;
  color: white;
}

</style>