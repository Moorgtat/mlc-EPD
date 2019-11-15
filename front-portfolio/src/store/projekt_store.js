import axios from 'axios'

const state = {
    projekts: []
};
const getters = {
    allProjekts: (state) => state.projekts
};
const actions = {
    async fetchProjekts ({ commit }) {
        const response = await axios.get('http://localhost:8082/api/acces/getProjekts');
        commit('setProjekts', response.data);
    },
    async addProjekt({ commit }, projekt){
        const response = await axios.post('http://localhost:8082/api/acces/newProjekt?Titre=' + projekt.titre + '&Description=' + projekt.description + '&Github=' + projekt.github);
        commit('newProjekt', response.data);
    },
    async deleteProjekt({ commit }, id){
        await axios.get('http://localhost:8082/api/acces/deleteProjekt?id=' + id);
        commit('removeProjekt', id)
    },
    async updtProjekt({ commit }, updprojekt){
        const response = await axios.put('http://localhost:8082/api/acces/putProjekt?id=' + updprojekt.id + '&Titre=' + updprojekt.titre + '&Description=' + updprojekt.description + '&Github=' + updprojekt.github);
        commit('changeProjekt', response.data )
    }
};
const mutations = {
    setProjekts: (state, projekts) => (state.projekts = projekts),
    newProjekt: (state, projekt) => state.projekts.push(projekt),
    removeProjekt: (state, id) => state.projekts = state.projekts.filter(projekt => projekt.id !== id),
    changeProjekt: (state, updprojekt) => {
        const index = state.projekts.findIndex(projekt => projekt.id === updprojekt.id);
        if(index !== -1) {
            state.projekts.splice(2, 1, updprojekt)
        }
    }
};


export default {
    state,
    getters,
    actions,
    mutations
}
