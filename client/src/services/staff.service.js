import axios from "axios";
import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/api/staff/";

class StaffService {
  getApprovedTravelRemovals() {
    return axios
      .get(API_URL + "travelRemovals/approved", { headers: authHeader() })
      .then((response) => {
        return response.data;
      });
  }
}
export default new StaffService();
