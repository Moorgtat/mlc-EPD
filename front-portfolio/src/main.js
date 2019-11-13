import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import {router} from './router'
import store from './store'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import Buefy from 'buefy'
import 'buefy/dist/buefy.css'

Vue.use(VueRouter);
Vue.use(Buefy);
Vue.config.productionTip = false;

new Vue({
  store,
  router,
  render: h => h(App),
}).$mount('#app');
