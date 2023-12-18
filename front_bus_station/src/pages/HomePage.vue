<template>

  <JourneyFilter/>

  <div class="journeys">
    <JourneyList :journey-list="journeyList"/>
    <PaginationComponent
        @pagination_cruise_ship_page_changed="(page, resultPerPage)=>getAllJourneys(page, resultPerPage)"
        :current-page="currentPage"
        :total-pages="totalPages"
        :max-visible-buttons="3"/>
  </div>
</template>

<script>
import JourneyList from "@/components/journeys/JourneyList.vue";
import {jwtDecode} from "jwt-decode";
import PaginationComponent from "@/components/layouts/Pagination.vue";
import axios from "axios";
import JourneyFilter from "@/components/journeys/JourneyFilter.vue";

export default {
  name: "HomePage",
  components: {JourneyFilter, PaginationComponent, JourneyList},
  data() {
    return {
      journeyList: [],
      currentPage: 1,
      totalPages: 1,
      resultsPerPage: 8,
      token: ''
    };
  },
  beforeCreate() {
    this.token = localStorage.getItem('token');
    if (!this.token) {
      this.$router.push('/login');
      localStorage.setItem('error', 'You need to log in first');
    } else {
      const jwtPayload = jwtDecode(this.token);
      new Date().getTime() / 1000 < jwtPayload.exp
          ? console.log("Token is valid")
          : this.$router.push('/login') && localStorage.setItem('error', 'You need to log in first');
    }
  },
  beforeMount() {
    this.getAllJourneys();
  },
  methods: {
    async getAllJourneys(pageNumber, resultPerPage) {
      const item = localStorage.getItem("token");
      if (pageNumber) {
        this.currentPage = pageNumber;
      }
      if (resultPerPage) {
        this.resultsPerPage = resultPerPage;
      }
      const axiosResponse = await axios.get("http://localhost:8080/routes", {
            headers: {
              'Authorization': `Bearer ${item}`
            },
            params: {
              page: this.currentPage - 1,
              size: this.resultsPerPage
            }
          }
      );
      // this.currentPage = axiosResponse.data.pageable.pageNumber + 1;
      this.totalPages = axiosResponse.data.totalPages;
      this.journeyList = axiosResponse.data;

    }
  }
};
</script>

<style scoped>
div.journeys {
  display: flex;
  flex-direction: column;
}
</style>