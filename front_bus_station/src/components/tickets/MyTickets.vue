<script>
import axios from "axios";
import TicketPage from "@/components/tickets/TicketPage.vue";

export default {
  name: "MyJourneys",
  components: {TicketPage},
  data() {
    return {
      ticket: {
        id: '',
        journey: {
          route: {
            number: '',
            stops: [],
          },
          bus: {
            driver: '',
            licensePlate: '',
          }
        },
        user: {
          firstName: '',
          secondName: '',
          phoneNumber: '',
          email: '',
        }
      },
      tickets: []
    }
  },
  beforeMount() {
    this.getJourneys()
  },
  methods: {
    async getJourneys() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get('http://localhost:8080/tickets/Actual'  ,{
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.tickets = axiosResponse.data;
      console.log(this.tickets)
    }
  }
}
</script>

<template>
  <h3>My tickets</h3>
  <div class="route-list">
    <TicketPage v-for="ticket in tickets" v-bind:key="ticket.id" :ticket="ticket"/>
  </div>
</template>

<style scoped>
h3{
  display: flex;
  justify-content: center;
}
</style>