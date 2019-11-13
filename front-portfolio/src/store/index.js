import Vue from 'vue'
import Vuex from 'vuex'

import {auth} from './auth.module'
import skills from './skills_store'

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        auth,
       skills
    }
});