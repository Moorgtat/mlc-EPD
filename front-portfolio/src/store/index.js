import Vue from 'vue'
import Vuex from 'vuex'

import {auth} from './auth.module'
import skills from './skills_store'
import projekts from './projekt_store'
import identities from './identity_store'
import contacts from './contact_store'

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        auth,
        skills,
        projekts,
        identities,
        contacts
    }
});