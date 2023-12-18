<script>
import RoutePage from "@/components/routes/RoutePage.vue";
import axios from "axios";

export default {
  name: "Minibus",
  components: {RoutePage},
  data() {
    return {
      seats: Array,
      journey: {
        id: '',
        route: {},
        bus: {
          id: '',
        },
      },
      bus: {
        id: ''
      },

    }
  },
  beforeMount() {
    this.findJourneyById()
  },
  methods: {
    async findSeatsByBusId() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get(`http://localhost:8080/seats/${this.journey.bus.id}/${this.journey.id}`, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.seats = axiosResponse.data;
      console.log('seats' + this.seats)

      console.log('seats[0]' + this.seats[0].status)

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
      console.log('journey ' + this.journey.bus.id)
      await this.findSeatsByBusId()

    },
  }
}
</script>

<template>
  <h2>Select your seat</h2>
  <div class="bus">
    <router-link class="seat" v-if="this.seats[0].status==='FREE'" style="top: 10%; left: 10%;"
                 :to="`/submit-ticket/${1}${this.$route.params.id}`">1
    </router-link>
    <div class="soldSeat" v-if="this.seats[0].status==='SOLD'" style="top: 10%; left: 10%;">1
    </div>
    <router-link class="seat" v-if="this.seats[1].status==='FREE'" style="top: 10%; left: 30%;"
                 :to="`/submit-ticket/${2}${this.$route.params.id}`">2
    </router-link>
    <div class="soldSeat" v-if="this.seats[1].status==='SOLD'" style="top: 10%; left: 30%;">2
    </div>
    <router-link class="seat" v-if="this.seats[2].status==='FREE'" style="top: 10%; left: 50%;"
                 :to="`/submit-ticket/${3}${this.$route.params.id}`">3
    </router-link>
    <div class="soldSeat" v-if="this.seats[2].status==='SOLD'" style="top: 10%; left: 50%;">3
    </div>
    <router-link class="seat" v-if="this.seats[3].status==='FREE'" style="top: 10%; left: 70%;"
                 :to="`/submit-ticket/${4}${this.$route.params.id}`">4
    </router-link>
    <div class="soldSeat" v-if="this.seats[3].status==='SOLD'" style="top: 10%; left: 70%;">4
    </div>
    <router-link class="seat" v-if="this.seats[4].status==='FREE'" style="top: 65%; left: 10%;"
                 :to="`/submit-ticket/${5}${this.$route.params.id}`">5
    </router-link>
    <div class="soldSeat" v-if="this.seats[4].status==='SOLD'" style="top: 65%; left: 10%;">5
    </div>
    <router-link class="seat" v-if="this.seats[5].status==='FREE'" style="top: 65%; left: 30%;"
                 :to="`/submit-ticket/${6}${this.$route.params.id}`">6
    </router-link>
    <div class="soldSeat" v-if="this.seats[5].status==='SOLD'" style="top: 65%; left: 30%;">6
    </div>
    <router-link class="seat" v-if="this.seats[6].status==='FREE'" style="top: 65%; left: 50%;"
                 :to="`/submit-ticket/${7}${this.$route.params.id}`">7
    </router-link>
    <div class="soldSeat" v-if="this.seats[6].status==='SOLD'" style="top: 65%; left: 50%;">7
    </div>
    <router-link class="seat" v-if="this.seats[7].status==='FREE'" style="top: 65%; left: 70%;"
                 :to="`/submit-ticket/${8}${this.$route.params.id}`">8
    </router-link>
    <div class="soldSeat" v-if="this.seats[7].status==='SOLD'" style="top: 65%; left: 70%;">8
    </div>
  </div>
</template>

<style scoped>
h2 {
  display: flex;
  justify-content: center;
}

.bus {
  background-color: white;
  margin: 25%;
  height: 40ex;
  width: 80ex;
  position: absolute;
  top: 0;
  left: 0;
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

.soldSeat {
  background-color: white;
  border: 2px solid royalblue;
  height: 20%;
  width: 10%;
  border-radius: 50%;
  position: absolute;
  display: flex;
  justify-content: center;
  align-items: center;
  color: royalblue;
}

</style>