import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Admin from "../views/Admin.vue";
import Supervisor from "../views/Supervisor.vue";
import Staff from "../views/Staff.vue";
import Director from "../views/Director.vue";
import Error from "../views/Error.vue";
import Users from "@/components/admin/Users.vue";
import Roles from "@/components/admin/Roles.vue";
import HomeAdmin from "@/components/admin/HomeAdmin.vue";
import Employees from "@/components/director/Employees.vue";
import TravelRemovals from "@/components/director/TravelRemovals.vue";
import HomeDirector from "@/components/director/HomeDirector.vue";
import Employee from "@/components/supervisor/Employee.vue";
import HomeSupervisor from "@/components/supervisor/HomeSupervisor.vue";
import ApprovedTravelRemovals from "@/components/staff/ApprovedTravelRemovals.vue";
import HomeStaff from "@/components/staff/HomeStaff.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    components: { a: Home },
  },
  {
    path: "/error",
    name: "Error",
    components: { a: Error },
  },
  {
    path: "/admin/home",
    name: "Admin",
    components: { a: Admin },

    children: [
      {
        // A will be rendered in the second <router-view>
        // when /your-sidebar-url/a is matched
        path: "/admin/users",
        components: {
          admin: Users, //note that 'b' is the name of child router view
        },
        meta: {
          requiresAuth: true,
          supervisorAuth: false,
          adminAuth: true,
          staffAuth: false,
          directorAuth: false,
        },
      },
      {
        // B will be rendered in the second <router-view>
        // when /your-sidebar-url/b is matched
        path: "/admin/roles",
        components: {
          admin: Roles, //note that 'b' is the name of child router view
        },
        meta: {
          requiresAuth: true,
          supervisorAuth: false,
          adminAuth: true,
          staffAuth: false,
          directorAuth: false,
        },
      },
      {
        // B will be rendered in the second <router-view>
        // when /your-sidebar-url/b is matched
        path: "/admin/home",
        components: {
          admin: HomeAdmin, //note that 'b' is the name of child router view
        },
        meta: {
          requiresAuth: true,
          supervisorAuth: false,
          adminAuth: true,
          staffAuth: false,
          directorAuth: false,
        },
      },
    ],
  },
  {
    path: "/supervisor/home",
    name: "Supervisor",
    components: { a: Supervisor },

    children: [
      {
        path: "/supervisor/employee",
        components: {
          supervisor: Employee,
        },
        meta: {
          requiresAuth: true,
          supervisorAuth: true,
          adminAuth: false,
          staffAuth: false,
          directorAuth: false,
        },
      },
      {
        path: "/supervisor/home",
        components: {
          supervisor: HomeSupervisor,
        },
        meta: {
          requiresAuth: true,
          supervisorAuth: true,
          adminAuth: false,
          staffAuth: false,
          directorAuth: false,
        },
      },
    ],
  },
  {
    path: "/director/home",
    name: "Director",
    components: { a: Director },
    children: [
      {
        path: "/director/employees",
        components: {
          director: Employees,
        },
        meta: {
          requiresAuth: true,
          supervisorAuth: false,
          adminAuth: false,
          staffAuth: false,
          directorAuth: true,
        },
      },
      {
        path: "/director/travelRemovals",
        components: {
          director: TravelRemovals,
        },
        meta: {
          requiresAuth: true,
          supervisorAuth: false,
          adminAuth: false,
          staffAuth: false,
          directorAuth: true,
        },
      },
      {
        path: "/director/home",
        components: {
          director: HomeDirector,
        },
        meta: {
          requiresAuth: true,
          supervisorAuth: false,
          adminAuth: false,
          staffAuth: false,
          directorAuth: true,
        },
      },
    ],
  },
  {
    path: "/staff/home",
    name: "Staff",
    components: { a: Staff },

    children: [
      {
        path: "/staff/ApprovedTravelRemovals",
        components: {
          staff: ApprovedTravelRemovals,
        },
        meta: {
          requiresAuth: true,
          supervisorAuth: false,
          adminAuth: false,
          staffAuth: true,
          directorAuth: false,
        },
      },
      {
        path: "/staff/home",
        components: {
          staff: HomeStaff,
        },
        meta: {
          requiresAuth: true,
          supervisorAuth: false,
          adminAuth: false,
          staffAuth: true,
          directorAuth: false,
        },
      },
    ],
  },
  { path: "*", components: { a: Error } },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});
router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth) {
    console.log("ww");
    const authUser = JSON.parse(localStorage.getItem("user"));
    console.log(authUser);
    if (!authUser || !authUser.token) {
      next({ name: "Home" });
    } else if (to.meta.adminAuth) {
      const authUser = JSON.parse(localStorage.getItem("user"));
      console.log("edww");
      if (authUser.role === "ROLE_ADMIN") {
        console.log("apap2");
        next();
      } else {
        next({ name: "Error" });
      }
    } else if (to.meta.supervisorAuth) {
      const authUser = JSON.parse(localStorage.getItem("user"));
      if (authUser.role === "ROLE_SUPERVISOR") {
        console.log("apap");
        next();
      } else {
        console.log("error");
        next({ name: "Error" });
      }
    } else if (to.meta.staffAuth) {
      const authUser = JSON.parse(localStorage.getItem("user"));
      if (authUser.role === "ROLE_STAFF") {
        next();
      } else {
        next({ name: "Error" });
      }
    } else if (to.meta.directorAuth) {
      const authUser = JSON.parse(localStorage.getItem("user"));
      if (authUser.role === "ROLE_DIRECTOR") {
        next();
      } else {
        next({ name: "Error" });
      }
    }
  } else {
    next();
  }
});
export default router;
