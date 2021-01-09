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
      <v-card>
        <v-card-title>
          <v-text-field
            v-model="search"
            append-icon="mdi-magnify"
            label="Search"
            single-line
            hide-details
          ></v-text-field>

        </v-card-title>
        <v-data-table
          :items="travelRemovals"
          :headers="headers"
          :items-per-page="5"
          :search="search"
        >
        </v-data-table>
      </v-card>
    </v-container>
  </div>
</template>
<script>
import StaffService from "@/services/staff.service";

export default {
  name: "Employees",
  data() {
    return {
      search: "",
      travelRemovals: [],
      message: "",
      headers: [
        { text: "Fullname", value: "fullname" },
        { text: "Phone", value: "phone" },
        { text: "Address", value: "address" },
        { text: "Workplace", value: "workplace" },
        { text: "Duration", value: "removal_duration" },
        { text: "Is from work place", value: "from_work_place" },
        { text: "Date", value: "removalHour" },
      ],
    };
  },
  mounted: function() {
    StaffService.getApprovedTravelRemovals().then(
      (res) => {
        this.travelRemovals = res;
      },
      (error) => {
        this.message = error.response.data.message;
      }
    );
  },
};
</script>
