<template>
  <div class="filter-left">
    <div class="filter">
      <h3>Filter</h3>
      <div class="filter-item">
        <label for="city">City</label>
        <input type="text" id="city" name="city" placeholder="City">
      </div>
      <div class="filter-item">
        <label for="route">Route</label>
        <input type="text" id="route" name="route" placeholder="Route">
      </div>
      <div class="filter-item">
        <label for="company">Company</label>
        <input type="text" id="company" name="company" placeholder="Company">
      </div>
      <div class="filter-item">
        <label for="from">From</label>
        <input type="text" id="from" name="from" placeholder="From">
      </div>
      <div class="filter-item">
        <label for="to">To</label>
        <input type="text" id="to" name="to" placeholder="To">
      </div>

      <button>Filter</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "CruiseShipFilter"
}
</script>

<style scoped>
.filter-left {
  position: sticky;
  left: 0;
  top: 0;
  width: 20%;
  height: 100vh;
  background-color: white;
  border: 3px solid cornflowerblue;
  float: left;
}

.filter>div{
  display: flex;
  flex-direction: column;
}

.filter-item{
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin: 10px;
}

.filter-item>label{
  margin-right: 10px;
}

.filter-item>input{
  width: 100%;
}

.filter>button{
  margin: 10px;
  width: 90%;
  height: 40px;
  background-color: royalblue;
  border: 1px solid cornflowerblue;
  border-radius: 5px;
  font-size: 20px;
  font-weight: bold;
  cursor: pointer;
}

.filter>button:hover{
  background-color: cornflowerblue;
  border: 1px solid royalblue;
  border-radius: 5px;
  font-size: 20px;
  font-weight: bold;
  cursor: pointer;
}

.filter>button:active{
  background-color: royalblue;
  border: 1px solid royalblue;
  border-radius: 5px;
  font-size: 20px;
  font-weight: bold;
  cursor: pointer;
}

.filter>h3{
  margin: 10px;
  font-size: 30px;
  font-weight: bold;
  text-align: center;
}
</style>