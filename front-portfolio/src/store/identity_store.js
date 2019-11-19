import axios from 'axios'

const state = {
    identities: []
};
const getters = {
    myIdentity: (state) => state.identities
};
const actions = {
    async fetchIdentity ({ commit }) {
        const response = await axios.get('http://localhost:8082/api/acces/getIdentity');
        commit('setIdentity', response.data);
    },
    async updtIdentity({ commit }, updidentity){
        const response = await axios.put('http://localhost:8082/api/acces/putIdentity?id=' + updidentity.id +
            '&name=' + updidentity.name + '&poste=' + updidentity.poste + '&presentation=' + updidentity.presentation +
            '&mail=' + updidentity.mail + '&git=' + updidentity.git + '&twitter=' + updidentity.twitter);
        commit('changeIdentity', response.data )
    }
};
const mutations = {
    setIdentity: (state, identities) => (state.identities = identities),
    changeIdentity: (state, updidentity) => {
        const index = state.identities.findIndex(identity => identity.id === updidentity.id);
        if(index !== -1) {
            state.identities.splice(0, 1, updidentity)
        }
    }
};

export default {
    state,
    getters,
    actions,
    mutations
}
