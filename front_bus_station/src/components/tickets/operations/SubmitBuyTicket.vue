<script>
import RoutePage from "@/components/routes/RoutePage.vue";
import axios from "axios";

export default {
  name: "BuyTicket",
  components: {RoutePage},
  data() {
    return {
      ticket: {
        user: {
          id: ''
        },
        journey: {
          id: ''
        }
      },
      user: {
        id: '',
        firstName: '',
        secondName: '',

      }

    }
  },
  beforeMount() {
    console.log(this.$route.params.seatId)
    console.log(this.$route.params.id)
  },
  methods: {
    async buyTicket() {
      const item = localStorage.getItem("token");
      this.user.id = localStorage.getItem('user');
      const axiosResponse = await axios.get(`http://localhost:8080/journeys/${this.$route.params.id}`, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      let journey = axiosResponse.data;

      const ticketsData = {
        journey: journey,
        userSeats: this.$route.params.seatId
      };
      let data = JSON.stringify(ticketsData);
      console.log(data)
      const apiResponse = await axios.post(`http://localhost:8080/tickets`, data, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      });
      console.log(apiResponse.request)

      let buysData = {
        journeyId: this.$route.params.id,
        number: this.$route.params.seatId
      }
      let theData = JSON.stringify(buysData)
      await axios.post(`http://localhost:8080/seats/buy`, theData, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      });

      if (apiResponse.status === 200) {
        this.$router.push('/');
      }

    }


  }
}

</script>

<template>
  <div>
    <h3>You buy a seat number: {{ this.$route.params.seatId }}</h3>
    <form @submit.prevent="buyTicket()">
      <button class="button" type="submit">Submit</button>
    </form>
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