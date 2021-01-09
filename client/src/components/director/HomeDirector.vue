<template>
  <div class="homeAdmin">
    <br />
    <br />
    <v-jumbotron>
      <v-container fill-height>
        <v-layout align-center>
          <v-flex>
            <h3 class="display-3">Welcome Director</h3>

            <span class="subheading"
              >Welcome to Staff Relocation Certificates System !
              Director can add supervisor to employee and edit their details.You can also find Trvel Removals by date.
              </span
            >

            <v-divider class="my-3"></v-divider>

            <div class="title mb-3">View Employees</div>
            <v-btn color="teal">
            <router-link to="/director/employees"  class="white--text" large>
              go to Employees
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
  name: "HomeDirector",
};
</script>