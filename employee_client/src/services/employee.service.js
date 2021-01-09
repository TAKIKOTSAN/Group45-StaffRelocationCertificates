import axios from "axios";
import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/api/employee/";
class EmployeeService {
  newTravelRemoval(travelRemoval) {
    const employee = JSON.parse(localStorage.getItem("user"));
    return axios
      .post(API_URL + employee.id + "/travelRemoval/create", travelRemoval, {
        headers: authHeader(),
      })
      .then((response) => {
        return response.data;
      });
  }
  getMyTravelRemoval() {
    const employee = JSON.parse(localStorage.getItem("user"));
    return axios
      .get(API_URL + employee.id + "/travelRemoval", { headers: authHeader() })
      .then((response) => {
        return response.data;
      });
  }
}
export default new EmployeeService();
