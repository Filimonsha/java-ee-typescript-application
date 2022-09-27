import axios from "axios";

const baseURL = 'http://localhost:8080/ITMO_web_2_war_exploded/';

const axiosInstance = axios.create({
    baseURL,
    headers: {
        'Content-Type': 'application/json'
    }
});


export default axiosInstance;
