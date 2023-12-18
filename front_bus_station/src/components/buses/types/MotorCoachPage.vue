<script>
import RoutePage from "@/components/routes/RoutePage.vue";

export default {
  name: "MotorCoach",
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
      bus: {
        id: ''
      }

    }
  },
}
</script>

<template>
  <h2>Select your seat</h2>
  <div class="bus">
    <router-link class="seat" style="top: 10%; left: 10%;" :to="`/submit-ticket/${1}${this.$route.params.id}`">1</router-link>
    <router-link class="seat" style="top: 10%; left: 25%;" :to="`/submit-ticket/${2}${this.$route.params.id}`">2</router-link>
    <router-link class="seat" style="top: 10%; left: 40%;" :to="`/submit-ticket/${3}${this.$route.params.id}`">3</router-link>
    <router-link class="seat" style="top: 10%; left: 55%;" :to="`/submit-ticket/${4}${this.$route.params.id}`">4</router-link>
    <router-link class="seat" style="top: 10%; left: 70%;" :to="`/submit-ticket/${5}${this.$route.params.id}`">5</router-link>
    <router-link class="seat" style="top: 10%; left: 85%;" :to="`/submit-ticket/${6}${this.$route.params.id}`">6</router-link>
    <router-link class="seat" style="top: 65%; left: 10%;;" :to="`/submit-ticket/${7}${this.$route.params.id}`">7</router-link>
    <router-link class="seat" style="top: 65%; left: 25%;" :to="`/submit-ticket/${8}${this.$route.params.id}`">8</router-link>
    <router-link class="seat" style="top: 65%; left: 40%;" :to="`/submit-ticket/${9}${this.$route.params.id}`">9</router-link>
    <router-link class="seat" style="top: 65%; left: 55%;" :to="`/submit-ticket/${10}${this.$route.params.id}`">10</router-link>
    <router-link class="seat" style="top: 65%; left: 70%;" :to="`/submit-ticket/${11}${this.$route.params.id}`">11</router-link>
    <router-link class="seat" style="top: 65%; left: 85%;" :to="`/submit-ticket/${12}${this.$route.params.id}`">12</router-link>
  </div>
</template>

<style scoped>
h2 {
  display: flex;
  justify-content: center;
}

.bus {
  background-color: white;
  margin: 20%;
  height: 40ex;
  width: 110ex;
  position: absolute;
  top: 0;
  left: 0;
  border-radius: 70px;
  border: 2px solid royalblue;

}

.seat {
  background-color: royalblue;
  height: 20%;
  width: 7%;
  border-radius: 50%;
  position: absolute;
  display: flex;
  justify-content: center;
  align-items: center;
  color: white;
}

</style>