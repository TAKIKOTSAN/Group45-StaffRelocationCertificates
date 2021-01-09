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
    <v-alert
      dense
      border="left"
      type="success"
      color="green lighten-2"
      dark
      v-if="message1"
      dismissible
    >
      {{ message1 }}
    </v-alert>
    <v-container>
      <br />
      <br />
      <v-card class="mx-auto">
        <v-card-title class="teal white--text text-right">
          <v-icon class="white--text">mdi-account-tie</v-icon> My employee
        </v-card-title>
        <v-card-text>
          <v-row>
            <v-col>
              <v-text-field
                readonly
                v-model="employee.username"
                label="Username"
              ></v-text-field>
            </v-col>
            <v-col>
              <v-text-field
                readonly
                v-model="employee.fullname"
                label="Fullname"
              ></v-text-field>
            </v-col>
          </v-row>
          <v-row>
            <v-col>
              <v-text-field
                readonly
                v-model="employee.phone"
                label="Phone"
              ></v-text-field>
            </v-col>
            <v-col>
              <v-text-field
                readonly
                v-model="employee.workplace"
                label="Workplace"
              ></v-text-field>
            </v-col>
          </v-row>
          <v-text-field
            readonly
            v-model="employee.address"
            label="Address"
          ></v-text-field>
        </v-card-text>
        <v-card-actions>
          <v-btn color="teal" @click="getTravelRemoval">
            Get Travel Removal
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-container>
    <v-dialog v-model="dialog" hide-overlay persistent max-width="600px">
      <v-card
        ><v-card-title>
          <span class="headline"> Travel Removal </span>
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
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="dialog = false">
            Close
          </v-btn>
          <v-btn color="blue darken-1" text @click="approveTravelRemoval">
            Approve
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>
<script>
import SupervisorService from "@/services/supervisor.service";

export default {
  name: "Employee",
  data() {
    return {
      dialog: false,
      travelRemoval: "",
      message: "",
      message1: "",
      employee: "",
    };
  },
  mounted: function() {
    SupervisorService.getMyEmployee().then(
      (res) => {
        this.employee = res;
      },
      (error) => {
        this.message = error.response.data.message;
      }
    );
  },
  methods: {
    getTravelRemoval() {
      this.message = "";
      SupervisorService.getTravelRemoval(this.employee.id).then(
        (res) => {
          this.travelRemoval = res;
          this.dialog = true;
        },
        (error) => {
          this.message = error.response.data.message;
        }
      );
    },
    approveTravelRemoval() {
      this.dialog = false;
      this.message = "";
      this.message1 = "";
      SupervisorService.travelRemovalApprove(this.employee.id).then(
        (res) => {
          this.travelRemoval = res;
          this.message1 = "Travel removal approved !";
        },
        (error) => {
          this.message = error.response.data.message;
        }
      );
    },
  },
};
</script>
