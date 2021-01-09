<template>
  <div class="homeAdmin">
    <br />
    <br />
    <v-jumbotron>
      <v-container fill-height>
        <v-layout align-center>
          <v-flex>
            <h3 class="display-3">Welcome Employee</h3>

            <span class="subheading"
              >Welcome to Staff Relocation Certificates System !
              Employee can create new Travel removal.You can also see ur travel Removal.
              </span
            >

            <v-divider class="my-3"></v-divider>

            <div class="title mb-3">New Travel Removal</div>
            <v-btn color="indigo">
            <router-link to="/employee/newTravelremoval"  class="white--text" large>
              go to form
            </router-link>
            </v-btn>
          </v-flex>
        </v-layout>
      </v-container>
    </v-jumbotron>
  </div>
</template>

<script>
export default {
  name: "HomeEmployee",
};
</script>