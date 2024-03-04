import axios from "axios";

const apiUrl = 'http://localhost:9598/manufacture';

const api = axios.create({
    baseURL: apiUrl
});

export default api;