import axios from 'axios'

const state = {
    identity: {}
};
const getters = {
    myIdentity: (state) => state.identity
};
const actions = {
    async fetchIdentity ({ commit }) {
        const response = await axios.get('http://localhost:8082/api/acces/getIdentity');
        commit('setIdentity', response.data);
    },
    async updateIdentity({ commit }, updIdentity){
        const response = await axios.put('http://localhost:8082/api/acces/putIdentity?id=' + updIdentity.id +
            '&Name=' + updIdentity.name + '&Poste=' + updIdentity.poste + '&Presentation=' + updIdentity.presentation +
            '&Mail=' + updIdentity.mail + '&Git=' + updIdentity.git + '&Twitter=' + updIdentity.twitter);
        commit('changeIdentity', response.data )
    }
};
const mutations = {
    setIdentity: (state, identity) => (state.identity = identity),
    changeIdentity: (state, updIdentity) => (state.identity = updIdentity)
};

export default {
    state,
    getters,
    actions,
    mutations
}
