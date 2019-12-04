import axios from 'axios'

const state = {
    contacts: []
};
const getters = {
    mycontacts: (state) => state.contacts
};
const actions = {
    async fetchContacts ({ commit }) {
        const response = await axios.get('http://localhost:8082/api/acces/getContacts');
        commit('setContact', response.data);
    },
    async addContact({ commit }, contact){
        const response = await axios.post('http://localhost:8082/api/acces/newContact?name=' + contact.name + '&mail='
            + contact.mail + '&message=' + contact.message);
        commit('newContact', response.data);
    },
    async deleteContact({ commit }, id){
        await axios.get('http://localhost:8082/api/acces/deleteContact?id=' + id);
        commit('removeContact', id)
    }
};
const mutations = {
    setContact: (state, contacts) => (state.contacts = contacts),
    newContact: (state, contact) => state.contacts.push(contact),
    removeContact: (state, id) => state.contacts = state.contacts.filter(contact => contact.id !== id)
};

export default {
    state,
    getters,
    actions,
    mutations
}