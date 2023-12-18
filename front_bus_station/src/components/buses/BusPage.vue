<script>

export default {
  name: "Bus",
  props: {
    bus: {
      driver: {
        firstName: ''
      },
      licensePlate: '',

    },
  },


};
</script>

<template>
  <div class="route">
    <h3>{{ bus.licensePlate }}</h3>
    <p>{{bus.busType}}</p><br>
    <p>Driver: {{ bus.driver.firstName }} {{bus.driver.secondName}}</p>
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