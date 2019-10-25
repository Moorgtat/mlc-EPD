import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import Vuex from 'vuex'
import VeeValidate from 'vee-validate';
import Buefy from 'buefy'

Vue.use(VueRouter)
Vue.use(Vuex)
Vue.use(VeeValidate);
Vue.use(Buefy)

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
