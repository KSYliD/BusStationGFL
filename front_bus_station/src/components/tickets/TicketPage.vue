<script>
import myJourneys from "@/components/tickets/MyTickets.vue";

export default {
  name: "TicketPage",
  props: {
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
  },
  computed: {
    myJourneys() {
      return myJourneys
    },
  },
};
</script>

<template>
  <div class="journey">
    <h3>{{ ticket.journey.route.number }}</h3>
    <p v-for="stop in ticket.journey.route.stops">{{ stop.city.name }} : {{ stop.time }}</p>
    <div class="buttons">
    <router-link class="button" :to="`/download-ticket/${ticket.id}`">Download ticket</router-link>
    <router-link class="button" :to="`/return-ticket/${ticket.seatDto.number}${ticket.journey.id}`">Return ticket</router-link>
    </div>
  </div>
</template>

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

.buttons{
display: flex;
}

.button {
  display: inline-block;
  margin: 40% 5% 10% 5%;
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

.button:hover {
  background-color: skyblue
}

.button:active {
  background-color: royalblue;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
</style>