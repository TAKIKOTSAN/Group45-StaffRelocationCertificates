<template>
  <v-app>
    <v-card class="mx-auto overflow-hidden elevation-0" height="600" width="2000">
      <v-app-bar color="teal darken-2" dark>
        <v-app-bar-nav-icon @click="drawer = true"></v-app-bar-nav-icon>

        <v-toolbar-title>Welcome Staff</v-toolbar-title>
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
      <router-view name="staff" />
    </v-card>
  </v-app>
</template>

<script>


export default {
  name: "Supervisor",

  data: () => ({
    drawer: false,
    group: null,
    model:1,
    menuItems: [
      { title: "Home", path: "/staff/home", icon: "mdi-home" },
      { title: "Approved Travel Removals", path: "/staff/ApprovedTravelRemovals", icon: "mdi-ticket-percent" },
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
