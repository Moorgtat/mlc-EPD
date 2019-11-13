import axios from 'axios'

const state = {
   skills: []
};
const getters = {
    allSkills: (state) => state.skills
};
const actions = {
    async fetchSkills ({ commit }) {
      const response = await axios.get('http://localhost:8082/api/acces/getSkills');
      commit('setSkills', response.data);
    },
    async addSkill({ commit }, skill){
        const response = await axios.post('http://localhost:8082/api/acces/newSkill?Titre=' + skill.titre + '&Description=' + skill.description);
        commit('newSkill', response.data);
    },
    async deleteSkill({ commit }, id){
        await axios.get('http://localhost:8082/api/acces/deleteSkill?id=' + id);
        commit('removeSkill', id)
    },
    async updtSkill({ commit }, updskill){
        const response = await axios.put('http://localhost:8082/api/acces/putSkill?id=' + updskill.id + '&Titre=' + updskill.titre + '&Description=' + updskill.description);
        commit('changeSkill', response.data )
    }
};
const mutations = {
    setSkills: (state, skills) => (state.skills = skills),
    newSkill: (state, skill) => state.skills.push(skill),
    removeSkill: (state, id) => state.skills = state.skills.filter(skill => skill.id !== id),
    changeSkill: (state, updskill) => {
        const index = state.skills.findIndex(skill => skill.id === updskill.id);
        if(index !== -1) {
            state.skills.splice(2, 1, updskill)
        }
    }
};


export default {
    state,
    getters,
    actions,
    mutations
}
