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
        <v-data-table :items="employees" :headers="headers" :items-per-page="5" :search="search">
          <template v-slot:[`item.actions`]="{ item }">
                <v-btn
                  class="ma-2"
                  fab
                  outlined
                  small
                  color="teal"
                  @click="getEmployee(item)"
                >
                  <v-icon>
                    mdi-account-edit
                  </v-icon>
                </v-btn>
          </template>
        </v-data-table>
      </v-card>
      <v-dialog v-model="dialog" hide-overlay persistent max-width="600px">
        <v-card
          ><v-card-title>
            <span class="headline"> Edit Employee </span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-form ref="form" lazy-validation>
                <v-col cols="12">
                  <v-text-field
                    label="Address*"
                    v-model="employee.address"
                    :rules="addressRules"
                    type="text"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    label="Phone*"
                    :rules="phoneRules"
                    v-model="employee.phone"
                    type="text"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    label="Workplace*"
                    v-model="employee.workplace"
                    :rules="workplaceRules"
                    type="text"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-select
                    v-model="employee.supervisor"
                    :items="supervisors"
                    :rules="[(v) => !!v || 'Item is required']"
                    label="Supervisor"
                    required
                  ></v-select>
                </v-col>
              </v-form>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="dialog = false">
              Close
            </v-btn>
            <v-btn color="blue darken-1" text @click="editEmployee">
              Save
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-container>
  </div>
</template>
<script>
import DirectorService from "@/services/director.service";

export default {
  name: "Employees",
  data() {
    return {
      search: '',
      dialog: false,
      message: "",
      employee: "",
      employees: [],
      supervisors: [],
      addressRules: [(v) => !!v || "Address is required"],
      workplaceRules: [(b) => !!b || "Workplace is required"],
      phoneRules: [
        (v) => !!v || "Phone is required",
        (v) => /^\d+$/.test(v)||'Phone must have only numbers',
        (v) => (v && v.length == 10) || 'Phone must have 10 numbers'
      ],
      headers: [
        { text: "Username",value: "username",},
        { text: "Fullname", value: "fullname" },
        { text: "Phone", value: "phone" },
        { text: "Address", value: "address" },
        { text: "Workplace", value: "workplace" },
        { text: "Supervisor", value: "supervisor" },
        { text: "Actions", value: "actions",sortable:false },
      ],
    };
  },
  mounted: function() {
    DirectorService.getSupervisors().then(
      (res) => {
        this.supervisors = res.map((a) => a.username);
        console.log(this.supervisors);
      },
      (error) => {
        this.message = error.response.data.message;
      }
    );
    DirectorService.getEmployees().then(
      (res) => {
        this.employees = res;
      },
      (error) => {
        this.message = error.response.data.message;
      }
    );
  },
  methods: {
    editEmployee() {
      if (!this.$refs.form.validate()) return false;
      this.dialog = false;
      this.message = "";
      DirectorService.editEmployee(this.employee.id, this.employee).then(
        (res) => {
          let index = this.employees.findIndex((r) => r.id == res.id);
          this.$set(this.employees, index, res);
        },
        (error) => {
          this.message = error.response.data.message;
        }
      );
    },
    getEmployee(employee) {
      this.dialog = true;
      this.employee = employee;
    },
  },
};
</script>
