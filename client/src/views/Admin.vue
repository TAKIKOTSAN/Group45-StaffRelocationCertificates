<template>
  <v-app>
    <v-card class="mx-auto overflow-hidden elevation-0" height="600" width="2000">
      <v-app-bar color="teal darken-2" dark>
        <v-app-bar-nav-icon @click="drawer = true"></v-app-bar-nav-icon>

        <v-toolbar-title>Welcome Admin</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-btn text @click="logOut">
          <v-icon>mdi-export</v-icon><span>Logout</span>
        </v-btn>
      </v-app-bar>

      <v-navigation-drawer v-model="drawer" absolute temporary>
        <v-list nav dense>
          <v-list-item-group v-model="model" mandatory color="indigo">
            <v-list-item
              v-for="item in menuItems"
              :key="item.title"
              :to="item.path"
              @click="drawer = false"

            >
              <v-list-item-icon>
                <v-icon>{{ item.icon }}</v-icon>
              </v-list-item-icon>
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-navigation-drawer>
      <router-view name="admin" />
    </v-card>
  </v-app>
</template>

<script>
//import Users from "@/components/admin/Users.vue";
//import Roles from "@/components/admin/Roles.vue";
//import HomeAdmin from "@/components/admin/HomeAdmin.vue";

export default {
  name: "Admin",

  data: () => ({
    drawer: false,
    group: null,
    model:1,
    menuItems: [
      { title: "Home", path: "/admin/home", icon: "mdi-home" },
      { title: "Users", path: "/admin/users", icon: "mdi-account-group" },
      { title: "Roles", path: "/admin/roles", icon: "mdi-account-child" },
    ],
  }),
  methods: {
    logOut() {
      this.$store.dispatch("auth/logout");
      this.$router.push("/");
    },
  },
};
</script>
<style></style>
