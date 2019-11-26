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
        const response = await axios.post('http://localhost:8082/api/acces/newProjekt?titre=' + projekt.titre + '&description='
            + projekt.description + '&github=' + projekt.github + '&slide_1=' + projekt.slide_1 + '&slide_2=' + projekt.slide_2 + '&slide_3=' + projekt.slide_3);
        commit('newProjekt', response.data);
    },
    async deleteProjekt({ commit }, id){
        await axios.get('http://localhost:8082/api/acces/deleteProjekt?id=' + id);
        commit('removeProjekt', id)
    },
    async updtProjekt({ commit }, updprojekt){
        const response = await axios.put('http://localhost:8082/api/acces/putProjekt?id=' + updprojekt.id +
            '&titre=' + updprojekt.titre + '&description=' + updprojekt.description + '&github=' + updprojekt.github +
            '&slide_1=' + updprojekt.slide_1 + '&slide_2=' + updprojekt.slide_2 + '&slide_3=' + updprojekt.slide_3);
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
            state.projekts.splice(index, 1, updprojekt)
        }
    }
};


export default {
    state,
    getters,
    actions,
    mutations
}
