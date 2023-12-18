<script>

export default {
  name: "Route",
  props: {
    route: {
      number: '',
      stops: [
        {
          city: {
            name: ''
          },
          address: '',
          time: ''
        },
      ],
    },
  },


};
</script>

<template>
  <div class="route">
    <h3>{{ route.number }}</h3>
    <p v-for="stop in route.stops">{{stop.city.name}}</p>
  </div>
</template>

<style scoped>
.route {
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

.route p {
  margin: 0;

}

</style>