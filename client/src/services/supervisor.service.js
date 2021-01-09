import axios from "axios";
import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/api/supervisor/";

class SupervisorService {
  getMyEmployee() {
    const supervisor = JSON.parse(localStorage.getItem("user"));
    return axios
      .get(API_URL + supervisor.id+"/employee", { headers: authHeader() })
      .then((response) => {
        return response.data;
      });
  }
  getTravelRemoval(id) {
    const supervisor = JSON.parse(localStorage.getItem("user"));
    return axios
      .get(API_URL + supervisor.id+"/employee/"+id+"/travelRemoval", { headers: authHeader() })
      .then((response) => {
        return response.data;
      });
  }
  travelRemovalApprove(id) {
    const supervisor = JSON.parse(localStorage.getItem("user"));
    return axios
      .put(API_URL + supervisor.id+"/employee/"+id+"/travelRemoval/approve",{"approved":true}, { headers: authHeader() })
      .then((response) => {
        return response.data;
      });
  }
}
export default new SupervisorService();
