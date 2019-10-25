import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import {router} from './router';
import Vuex from 'vuex'
import store from './store';
import Buefy from 'buefy'
import 'buefy/dist/buefy.css'
import {ValidationProvider} from 'vee-validate'
import {required} from 'vee-validate/dist/rules';

Vue.use(VueRouter)
Vue.use(Vuex)
Vue.use(Buefy)
Vue.component('ValidationProvider', ValidationProvider)

Vue.config.productionTip = false

new Vue({
  store,
  router,
  required,
  render: h => h(App),
}).$mount('#app')
