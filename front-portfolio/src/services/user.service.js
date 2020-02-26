import axios from 'axios'
import authHeader from './auth-header'

const API_URL = 'http://94.23.47.22:3002/api/acces/';

class UserService {

    getUserBoard() {
        return axios.get(API_URL + 'user', { headers: authHeader() })
    }

    getModeratorBoard() {
        return axios.get(API_URL + 'mod', { headers: authHeader() })
    }

    getAdminBoard() {
        return axios.get(API_URL + 'admin', { headers: authHeader() })
    }
}

export default new UserService()
