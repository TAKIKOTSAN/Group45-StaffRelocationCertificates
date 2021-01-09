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
      <v-card>
        <v-card-title>
          <v-btn
            class="mx-2 text--white"
            color="teal"
            dark
            @click="dialog = true"
            ><v-icon left>
              mdi-account-plus
            </v-icon>
            New User
          </v-btn>
          <v-text-field
            v-model="search"
            append-icon="mdi-magnify"
            label="Search"
            single-line
            hide-details
          ></v-text-field>
        </v-card-title>
        <v-data-table
          :items="users"
          :headers="headers"
          :items-per-page="5"
          :search="search"
        >
          <template v-slot:[`item.actions`]="{ item }">
            <v-btn
              class="ma-2"
              fab
              outlined
              small
              color="teal"
              @click="deleteUser(item.id)"
            >
              <v-icon>
                mdi-account-minus
              </v-icon>
            </v-btn>
            <v-btn
              class="ma-2"
              fab
              outlined
              small
              color="teal"
              @click="getUser(item.id)"
            >
              <v-icon>
                mdi-account-edit
              </v-icon>
            </v-btn>
          </template>
        </v-data-table>

      </v-card>
       <br />
      <br />
      <v-dialog v-model="dialog" hide-overlay persistent max-width="600px">
        <v-card
          ><v-card-title>
            <span class="headline"> New User </span>
          </v-card-title>
          <v-form
            ref="form"
            lazy-validation
            @submit.prevent="newUser"
            v-model="valid"
          >
            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="6">
                    <v-text-field
                      label="Email*"
                      v-model="user.email"
                      :rules="emailRules"
                      type="email"
                      required
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <v-text-field
                      label="Password*"
                      v-model="user.password"
                      :rules="passwordRules"
                      type="password"
                      required
                    ></v-text-field>
                  </v-col>
                </v-row>
                <v-col cols="12">
                  <v-select
                    v-model="user.role"
                    :items="roles"
                    :rules="[(v) => !!v || 'Item is required']"
                    label="Role Name"
                    required
                  ></v-select>
                </v-col>
                <v-row>
                  <v-col cols="12" sm="6">
                    <v-text-field
                      label="Username*"
                      v-model="user.username"
                      type="text"
                      :rules="usernameRules"
                      required
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <v-text-field
                      label="FullName*"
                      type="text"
                      v-model="user.fullname"
                      :rules="fullnameRules"
                      required
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
              <v-btn color="blue darken-1" text type="submit">
                Save
              </v-btn>
            </v-card-actions>
          </v-form>
        </v-card>
      </v-dialog>
      <v-dialog v-model="dialog2" hide-overlay persistent max-width="600px">
        <v-card
          ><v-card-title>
            <span class="headline"> Edit User </span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-form ref="form2" lazy-validation v-model="valid2">
                <v-col cols="12">
                  <v-text-field
                    label="Email*"
                    :rules="emailRules"
                    v-model="modifyUser.email"
                    type="email"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    label="Password*"
                    :rules="passwordRules"
                    v-model="modifyUser.password"
                    type="password"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    label="Username*"
                    v-model="modifyUser.username"
                    :rules="usernameRules"
                    type="text"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    label="FullName*"
                    type="text"
                    :rules="fullnameRules"
                    v-model="modifyUser.fullname"
                    required
                  ></v-text-field>
                </v-col>
              </v-form>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="dialog2 = false">
              Close
            </v-btn>
            <v-btn color="blue darken-1" text @click="editUser">
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
import User from "@/models/user";

export default {
  name: "Users",
  data() {
    return {
      search: "",
      valid: true,
      valid2: true,
      message: "",
      user: new User("", "", "", "", ""),
      users: [],
      roles: [],
      dialog: false,
      dialog2: false,
      modifyUser: "",
      emailRules: [
        (v) => !!v || "E-mail is required",
        (v) => /.+@.+\..+/.test(v) || "E-mail must be valid",
      ],
      usernameRules: [(v) => !!v || "Username is required"],
      passwordRules: [(b) => !!b || "Password is required"],
      fullnameRules: [(v) => !!v || "Fullname is required"],
      headers: [
        {
          text: "Username",
          value: "username",
        },
        { text: "Fullname", value: "fullname" },
        { text: "Email", value: "email" },
        { text: "Role", value: "authority.authority" },
        { text: "Actions", value: "actions", sortable: false },
      ],
    };
  },

  mounted: function() {
    AdminService.getRoles().then(
      (res) => {
        this.roles = res.map((a) => a.authority);
        console.log(this.roles);
      },
      (error) => {
        this.message = error.response.data.message;
      }
    );
    AdminService.getUsers().then(
      (res) => {
        this.users = res;
      },
      (error) => {
        this.message = error.response.data.message;
      }
    );
  },
  methods: {
    deleteUser(id) {
      this.message = "";
      AdminService.deleteUser(id).then(
        () => {
          this.users = this.users.filter((user) => user.id != id);
        },
        (error) => {
          this.message = error.response.data.message;
        }
      );
    },
    getUser(id) {
      this.dialog2 = true;
      this.message = "";
      AdminService.getUser(id).then(
        (res) => {
          this.modifyUser = res;
        },
        (error) => {
          this.message = error.response.data.message;
        }
      );
    },
    editUser() {
      if (!this.$refs.form2.validate()) return false;
      this.dialog2 = false;
      this.message = "";
      AdminService.editUser(this.modifyUser.id, this.modifyUser).then(
        (res) => {
          let index = this.users.findIndex((r) => r.id == res.id);
          this.$set(this.users, index, res);
        },
        (error) => {
          this.message = error.response.data.message;
        }
      );
    },
    newUser() {
      if (!this.$refs.form.validate()) return false;
      this.message = "";
      this.dialog = false;
      AdminService.newUser(this.user).then(
        (res) => {
          this.users.push(res);
        },
        (error) => {
          this.message = error.response.data.message;
        }
      );
    },
  },
};
</script>
