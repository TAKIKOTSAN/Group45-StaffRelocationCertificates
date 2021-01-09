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
    <br />
    <br />
    <v-container fluid>
      <v-row>
        <v-col cols="4">
          <h4>Select the date you want to see travel removals:</h4>
          <v-date-picker
            v-model="date"
            width="290"
            color="teal"
            class="mt-4"
            @click:date="getTravelRemovals"
          ></v-date-picker>
        </v-col>
        <v-col cols="12" sm="12" md="8">
          <v-card>
            <v-overlay :absolute="absolute" :value="overlay">
              <v-progress-circular
                indeterminate
                size="64"
              ></v-progress-circular>
            </v-overlay>

            <v-simple-table height="400px">
              <thead class="grey lighten-4">
                <tr>
                  <th class="text-center">
                    Employee Fullname
                  </th>
                  <th class="text-center">
                    Employee Phone
                  </th>
                  <th class="text-center">
                    Employee Address
                  </th>
                  <th class="text-center">
                    Employee Workplace
                  </th>
                  <th class="text-center">
                    Removal Duration
                  </th>
                  <th class="text-center">
                    Is from work place
                  </th>
                  <th class="text-center">
                    Removal Date
                  </th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="tr in travelRemovals" :key="tr.phone">
                  <td>{{ tr.fullname }}</td>
                  <td>{{ tr.phone }}</td>
                  <td>{{ tr.address }}</td>
                  <td>{{ tr.workplace }}</td>
                  <td>{{ tr.removal_duration }}</td>
                  <td>{{ tr.from_work_place }}</td>
                  <td>{{ tr.removalHour }}</td>
                </tr>
              </tbody>
            </v-simple-table>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>
<script>
import DirectorService from "@/services/director.service";

export default {
  name: "Employees",
  data() {
    return {
      absolute: true,
      overlay: false,
      message: "",
      travelRemovals: [],
      date: new Date().toISOString().substr(0, 10),
    };
  },
  methods: {
    getTravelRemovals() {
      console.log(this.date);
      this.message = "";
      this.overlay = true;
      DirectorService.getTravelRemovalsByDate(this.date).then(
        (res) => {
          console.log(res);
          this.travelRemovals = res;
          this.overlay = false;
        },
        (error) => {
          this.message = error.response.data.message;
          this.overlay = false;
        }
      );
    },
  },
};
</script>
