import axios from "axios";
import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/api/director/";

class DirectorService {
    getSupervisors() {
      return axios
        .get(API_URL + "supervisors", { headers: authHeader() })
        .then((response) => {
          return response.data;
        });
    }
        getEmployees() {
          return axios
            .get(API_URL + "employees", { headers: authHeader() })
            .then((response) => {
              return response.data;
            });
        }
        editEmployee(id, employee) {
            return axios
              .put(API_URL + "employees/" + id + "/AddSupervisor", employee, { headers: authHeader() })
              .then((response) => {
                return response.data;
              });
          }
          getTravelRemovalsByDate(date) {
            return axios
              .get(API_URL + "travelRemovals/"+date, { headers: authHeader() })
              .then((response) => {
                return response.data;
              });
          }
}
export default new DirectorService();
