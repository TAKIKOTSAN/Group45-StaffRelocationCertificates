import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Employee from "../views/Employee.vue";
import Error from "../views/Error.vue";
import HomeEmployee from "../components/HomeEmployee.vue";
import TravelRemoval from "../components/TravelRemoval.vue";
import NewTravelRemoval from "../components/NewTravelRemoval.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    components: { a: Home },
  },
  {
    path: "/employee/home",
    name: "Employee",
    components: {
      a: Employee,
    },
    children: [
      {
        path: "/employee/home",
        components: {
          employee: HomeEmployee,
        },
      },
      {
        path: "/employee/myTravelRemoval",
        components: {
          employee: TravelRemoval,
        },
      },
      {
        path: "/employee/newTravelRemoval",
        components: {
          employee: NewTravelRemoval,
        },
      },
    ],
  },

  {
    path: "/error",
    name: "Error",
    components: { a: Error },
  },
  { path: "*", components: { a: Error } },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
