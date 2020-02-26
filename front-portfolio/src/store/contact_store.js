import axios from 'axios'

const state = {
    contacts: []
};
const getters = {
    mycontacts: (state) => state.contacts
};
const actions = {
    async fetchContacts ({ commit }) {
        const response = await axios.get('https://94.23.47.22:3002/api/acces/getContacts');
        commit('setContact', response.data);
    },
    async addContact({ commit }, contact){
        const response = await axios.post('https://94.23.47.22:3002/api/acces/newContact?name=' + contact.name + '&mail='
            + contact.mail + '&message=' + contact.message);
        commit('newContact', response.data);
    },
    async deleteContact({ commit }, id){
        await axios.get('https://94.23.47.22:3002/api/acces/deleteContact?id=' + id);
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
