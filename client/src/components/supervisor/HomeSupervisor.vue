<template>
  <div class="homeAdmin">
    <br />
    <br />
    <v-jumbotron>
      <v-container fill-height>
        <v-layout align-center>
          <v-flex>
            <h3 class="display-3">Welcome Supervisor</h3>

            <span class="subheading"
              >Welcome to Staff Relocation Certificates System ! Supervisor can see
              his employee and approve employee's Travel Removal.
            </span>

            <v-divider class="my-3"></v-divider>

            <div class="title mb-3">View My Employee</div>
            <v-btn color="teal">
              <router-link
                to="/supervisor/employee"
                class="white--text"
                large
              >
                go to my employee
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
  name: "HomeSupervisor",
};
</script>