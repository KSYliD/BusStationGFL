import {createRouter, createWebHistory} from 'vue-router/dist/vue-router.esm-bundler'
import Home from '@/pages/HomePage.vue'
import LoginComponent from "@/components/auth/LoginComponent.vue";
import RegisterComponent from "@/components/auth/RegisterComponent.vue";
import LogoutComponent from "@/components/auth/LogoutComponent.vue";
import RouteEditorPage from "@/components/routes/RouteEditorPage.vue";
import RouteListPage from "@/components/routes/RouteListPage.vue";
import JourneyList from "@/components/journeys/JourneyList.vue";
import JourneyEditorPage from "@/components/journeys/JourneyEditorPage.vue";
import BuyTicket from "@/components/tickets/operations/SubmitBuyTicket.vue";
import MyJourneys from "@/components/tickets/MyTickets.vue";
import DownloadTicketPage from "@/components/tickets/operations/DownloadTicketPage.vue";
import ReturnTicketPage from "@/components/tickets/operations/ReturnTicketPage.vue";
import BusListPage from "@/components/buses/BusListPage.vue";
import BusEditorPage from "@/components/buses/BusEditorPage.vue";
import MinibusPage from "@/components/buses/types/MinibusPage.vue";
import MotorCoachPage from "@/components/buses/types/MotorCoachPage.vue";
import DoubleDeckerPage from "@/components/buses/types/DoubleDeckerPage.vue";

const routes = [
    {
        path: '/',
        component: Home
    },
    {
        path: '/login',
        component: LoginComponent
    },
    {
        path: '/register',
        component: RegisterComponent
    },
    {
        path: '/logout',
        component: LogoutComponent
    },
    {
        path: '/routes-editor',
        component: RouteEditorPage
    },
    {
        path: '/routes',
        component: RouteListPage
    },
    {
        path: '/journeys',
        component: JourneyList
    },
    {
        path: '/journeys-editor',
        component: JourneyEditorPage
    },
    {
        path: '/Minibus/:id',
        component: MinibusPage
    },
    {
        path: '/MotorCoach/:id',
        component: MotorCoachPage
    },
    {
        path: '/DoubleDecker/:id',
        component: DoubleDeckerPage
    },
    {
        path: '/submit-ticket/:seatId:id',
        component: BuyTicket
    },
    {
        path: '/my-journeys',
        component: MyJourneys
    },
    {
        path: '/download-ticket/:id',
        component: DownloadTicketPage
    },
    {
        path: '/return-ticket/:seatId:id',
        component: ReturnTicketPage
    },
    {
        path: '/buses',
        component: BusListPage
    },
    {
        path: '/buses-editor',
        component: BusEditorPage
    },

]

export default () => createRouter({
    history: createWebHistory(),
    routes: routes
})