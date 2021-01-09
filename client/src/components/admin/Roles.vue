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
          <v-btn
            class="mx-2 text--white"
            color="teal"
            dark
            @click="dialog = true"
            ><v-icon left>
              mdi-plus
            </v-icon>
            New Role
          </v-btn>
        </v-card-title>
        <v-simple-table>
          <thead class="grey lighten-4">
            <tr>
              <th class="text-center">
                ID
              </th>
              <th class="text-center">
                Name
              </th>
              <th class="text-center">
                Action
              </th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="role in roles" :key="role.authority">
              <td>{{ role.id }}</td>
              <td>{{ role.authority }}</td>
              <td>
                <v-btn
                  class="mx-2 text--white"
                  color="teal"
                  @click="deleteRole(role.id)"
                >
                  <v-icon left>
                    mdi-delete-outline
                  </v-icon>
                  Delete
                </v-btn>
              </td>
            </tr>
          </tbody>
        </v-simple-table>
      </v-card>
      <v-dialog v-model="dialog" hide-overlay persistent width="300">
        <v-card
          ><v-card-title>
            <span class="headline"> New Role </span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-form ref="form" lazy-validation v-model="valid">
                <v-select
                  v-model="role.roleName"
                  :items="[
                    'ROLE_SUPERVISOR',
                    'ROLE_DIRECTOR',
                    'ROLE_EMPLOYEE',
                    'ROLE_STAFF',
                  ]"
                  :rules="[(v) => !!v || 'Item is required']"
                  label="Role Name"
                  required
                ></v-select>
              </v-form>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="dialog = false">
              Close
            </v-btn>
            <v-btn color="blue darken-1" text @click="newRole">
              Save
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-container>
  </div>
</template>
<script>
import AdminService from "@/services/admin.service";
import Role from "@/models/role";

export default {
  name: "Roles",
  data() {
    return {
      valid:true,
      message: "",
      role: new Role(""),
      roles: [],
      dialog: false,
    };
  },

  mounted: function() {
    AdminService.getRoles().then(
      (res) => {
        console.log(res);
        this.roles = res;
        console.log(this.roles);
      },
      (error) => {
        this.message = error.response.data.message;
      }
    );
  },
  methods: {
    deleteRole(id) {
      (this.message = ""),
        AdminService.deleteRole(id).then(
          () => {
            this.roles = this.roles.filter((role) => role.id != id);
          },
          (error) => {
            this.message = error.response.data.message;
          }
        );
    },
    newRole() {
      if (!this.$refs.form.validate()) return false;
      this.message = "";
      this.dialog = false;
      AdminService.newRole(this.role).then(
        (res) => {
          this.roles.push(res);
        },
        (error) => {
          this.message = error.response.data.message;
        }
      );
    },
  },
};
</script>
