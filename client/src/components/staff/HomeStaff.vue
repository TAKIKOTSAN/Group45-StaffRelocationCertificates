<template>
  <div class="homeAdmin">
    <br />
    <br />
    <v-jumbotron>
      <v-container fill-height>
        <v-layout align-center>
          <v-flex>
            <h3 class="display-3">Welcome Staff</h3>

            <span class="subheading"
              >Welcome to Staff Relocation Certificates System ! Staff can see
              all approved Travel Removals.
            </span>

            <v-divider class="my-3"></v-divider>

            <div class="title mb-3">View Travel Removals</div>
            <v-btn color="teal">
              <router-link
                to="/staff/ApprovedTravelRemovals"
                class="white--text"
                large
              >
                go to removals
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
  name: "HomeStaff",
};
</script>
