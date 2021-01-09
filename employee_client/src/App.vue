<template>
  <v-app>
    <router-view name="a"/>
    <v-footer dark padless>
        <v-card flat tile class="indigo white--text text-center">
          <v-card-text>
            <v-btn
              v-for="icon in icons"
              :key="icon"
              class="mx-4 white--text"
              icon
            >
              <v-icon size="24px">
                {{ icon }}
              </v-icon>
            </v-btn>
          </v-card-text>

          <v-card-text class="white--text pt-0">
            An employee will apply for a travel permit to and from his
            workplace. His boss will validate the travel permit. The travel
            permit can be daily, weekly or extraordinary. The Personnel
            Department will look at approved applications. The application will
            contain his personal data, travel hours, home address, etc. The
            manager will see an overall picture, e.g. How many employees move
            each day.
          </v-card-text>

          <v-divider></v-divider>

          <v-card-text class="white--text">
            {{ new Date().getFullYear() }} —
            <strong>Staff Relocation Certificates System</strong>
          </v-card-text>
        </v-card>
      </v-footer>
  </v-app>

</template>

<script>

export default {
  name: 'App',


  data: () => ({
    //
  }),
};
</script>
<style>
#app {

  text-align: center;
}

</style>