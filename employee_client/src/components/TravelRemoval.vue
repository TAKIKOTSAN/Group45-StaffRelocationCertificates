<template>
  <div>
    <v-alert
      dense
      border="left"
      type="warning"
      color="red lighten-2"
      dark
      v-if="message"
      dismissible
    >
      {{ message }}
    </v-alert>
    <v-container>
      <br />
      <br />
      <v-card class="mx-auto">
        <v-card-title class="indigo lighten-1 white--text text-right">
          <v-icon class="white--text">mdi-ticket-percent</v-icon> My Travel
          Removal
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col>
                <v-text-field
                  readonly
                  label="Date"
                  v-model="travelRemoval.removalHour"
                ></v-text-field>
              </v-col>
              <v-col>
                <v-text-field
                  readonly
                  label="Duration"
                  v-model="travelRemoval.removal_duration"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <v-text-field
                  readonly
                  label="Is from work place"
                  v-model="travelRemoval.from_work_place"
                ></v-text-field>
              </v-col>
              <v-col>
                <v-text-field
                  readonly
                  label="Approved"
                  v-model="travelRemoval.approved"
                ></v-text-field>
              </v-col>
            </v-row>
          </v-container>
        </v-card-text>
      </v-card>
    </v-container>
  </div>
</template>
<script>
import EmployeeService from "../services/employee.service";
//import TravelRemoval from "../models/travelRemoval";

export default {
  name: "TravelRemoval",
  data() {
    return {
      travelRemoval: "",
      message: "",
    };
  },
  mounted: function() {
    EmployeeService.getMyTravelRemoval().then(
      (res) => {
        this.travelRemoval = res;
      },
      (error) => {
        this.message = error.response.data.message;
      }
    );
  },
};
</script>
