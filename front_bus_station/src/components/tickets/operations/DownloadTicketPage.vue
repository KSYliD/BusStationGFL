<script>
import axios from "axios";
import TicketPage from "@/components/tickets/TicketPage.vue";

export default {
  name: "DownloadTicketPage",
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
        seatDto: {
          date: '',
        }
      },

    }
  },
  beforeMount() {
    this.getJourneys()
  },
  methods: {
    async getJourneys() {
      const item = localStorage.getItem("token");
      const axiosResponse = await axios.get(`http://localhost:8080/tickets/id/${this.$route.params.id}`, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${item}`,
        }
      })
      this.ticket = axiosResponse.data;
    },

    async printFacture() {
      let pdf = new jsPDF();
      let element = document.getElementById('facture');
      let width = element.style.width;
      let height = element.style.height;
      html2canvas(element).then(canvas => {
        let image = canvas.toDataURL('image/png');
        pdf.addImage(image, 'JPEG', 15, 40, width, height);
        pdf.save('facture' + moment(this.facture.date_debut).format('LL') + '_' + moment(this.facture.date_fin).format('LL') + '.pdf')
      });
    },
    async downloadPDF() {
      const doc = new jsPDF('p', 'pt', 'a4');
      doc.html(this.$refs.content.innerHTML, {
        callback: function (doc) {
          doc.save('op.pdf');
        },
        x: 10,
        y: 10,

      });
      console.log(doc)

    }
  }
}
</script>

<template>
  <h1>Download</h1>
  <div>
    <h3>Ticket on {{ ticket.seatDto.date }}</h3>
    <p v-for="busStop in ticket.journey.route.stops">{{ busStop.city.name }} - {{ busStop.address }} :
      {{ busStop.time }}</p>
    <p>Driver: {{ ticket.journey.bus.driver.firstName }} {{ ticket.journey.bus.driver.secondName }} :
      {{ ticket.journey.bus.driver.phoneNumber }}</p>
    <p>Bus: {{ ticket.journey.bus.licensePlate }} Seat: {{ ticket.seatDto.number }}</p>
    <button @click=""></button>
  </div>
</template>

<style scoped>

</style>