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
      >{{ message1 }}
    </v-alert>
    <v-container>
      <br />
      <br />
      <v-card
        ><v-card-title class="indigo lighten-1  white--text">
          <span class="headline"> New Travel Removal </span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-form ref="form" lazy-validation v-model="valid">
              <v-row>
                <v-col>
                  <v-menu
                    v-model="menu2"
                    :close-on-content-click="false"
                    :nudge-right="40"
                    transition="scale-transition"
                    offset-y
                    min-width="290px"
                  >
                    <template v-slot:activator="{ on, attrs }">
                      <v-text-field
                        v-model="removalHour"
                        label="Date"
                        prepend-icon="mdi-calendar"
                        readonly
                        v-bind="attrs"
                        v-on="on"
                      ></v-text-field>
                    </template>
                    <v-date-picker
                      v-model="removalHour"
                      @input="menu2 = false"
                    ></v-date-picker>
                  </v-menu>
                </v-col>
                <v-col>
                  <v-select
                    v-model="removal_duration"
                    :items="['DAILY', 'WEEKLY', 'EXTRAORDINARY']"
                    :rules="[(v) => !!v || 'Item is required']"
                    label="Duration"
                    required
                  ></v-select>
                </v-col>
              </v-row>
              <v-row>
                <v-col>
                  <v-checkbox
                    v-model="from_work_place"
                    label="Is from workplace"
                  ></v-checkbox>
                </v-col>
              </v-row>
            </v-form>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="newTravelRemoval">
            create
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-container>
  </div>
</template>
<script>
import EmployeeService from "../services/employee.service";
import TravelRemoval from "../models/travelRemoval";

export default {
  name: "NewTravelRemoval",
  data() {
    return {
      removal_duration: "",
      valid: true,
      removalHour: new Date().toISOString().substr(0, 10),
      from_work_place: false,
      message: "",
      message1: "",
      travelRemoval: "",
      menu2: false,
    };
  },
  methods: {
    newTravelRemoval() {
      if (!this.$refs.form.validate()) return false;
      this.message = "";
      this.message1 = "";
      this.travelRemoval = new TravelRemoval(
        this.removalHour,
        this.removal_duration,
        this.from_work_place
      );
      console.log(this.travelRemoval);
      EmployeeService.newTravelRemoval(this.travelRemoval).then(
        () => {
          this.message1 = "Trave removal created !";
        },
        (error) => {
          this.message = error.response.data.message;
        }
      );
    },
  },
};
</script>
