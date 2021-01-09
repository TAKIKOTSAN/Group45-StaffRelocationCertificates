import axios from "axios";
import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/api/admin/";

class AdminService {
  getRoles() {
    return axios
      .get(API_URL + "roles", { headers: authHeader() })
      .then((response) => {
        return response.data;
      });
  }

  newRole(role) {
    return axios
      .post(
        API_URL + "roles/create",
        {
          roleName: role.roleName,
        },
        { headers: authHeader() }
      )
      .then((response) => {
        return response.data;
      });
  }
  editRole(id, role) {
    return axios
      .put(
        API_URL + "roles" + id + "/edit",
        {
          roleName: role.roleName,
        },
        { headers: authHeader() }
      )
      .then((response) => {
        return response.data;
      });
  }
  deleteRole(id) {
    return axios
      .delete(API_URL + "roles/" + id, { headers: authHeader() })
      .then((response) => {
        return response.data;
      });
  }
  getRole(id) {
    return axios
      .get(API_URL + "roles/" + id, { headers: authHeader() })
      .then((response) => {
        return response.data;
      });
  }
  getUsers() {
    return axios
      .get(API_URL + "users", { headers: authHeader() })
      .then((response) => {
        return response.data;
      });
  }

  newUser(user) {
    return axios
      .post(
        API_URL + "users/create",
        {
          username: user.username,
          email: user.email,
          fullname: user.fullname,
          password: user.password,
          role: user.role,
        },
        { headers: authHeader() }
      )
      .then((response) => {
        return response.data;
      });
  }
  deleteUser(id) {
    return axios
      .delete(API_URL + "users/" + id, { headers: authHeader() })
      .then((response) => {
        return response.data;
      });
  }
  getUser(id) {
    return axios
      .get(API_URL + "users/" + id, { headers: authHeader() })
      .then((response) => {
        return response.data;
      });
  }
  editUser(id, user) {
    return axios
      .put(API_URL + "users/" + id + "/edit", user, { headers: authHeader() })
      .then((response) => {
        return response.data;
      });
  }
}

export default new AdminService();
