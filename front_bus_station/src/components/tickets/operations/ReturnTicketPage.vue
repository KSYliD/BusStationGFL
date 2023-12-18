<script>
import axios from "axios";
import TicketPage from "@/components/tickets/TicketPage.vue";

export default {
  name: "ReturnTicketPage",
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
        },
        seat: {
          date: '',
        }
      },

    }
  },
  methods: {
    async returnTicket() {
      const item = localStorage.getItem("token");
      let data ={
        number: this.$route.params.seatId,
        journeyId: this.$route.params.id,
      }
      let theData = JSON.stringify(data)
      let apiResponse = await axios.post(`http://localhost:8080/seats/return`, theData , {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      });
      if (apiResponse.status === 200) {
        this.$router.push('/my-journeys');
      }
    }


  }
}
</script>

<template>
  <div>
    <h1>Return</h1>
    <button class="button" @click="returnTicket">Submit</button>
  </div>
</template>

<style scoped>
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
div {
  margin: 20%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>