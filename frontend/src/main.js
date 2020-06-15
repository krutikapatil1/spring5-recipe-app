import Vue from 'vue'
import App from './App.vue'
import axios from 'axios';
import {BootstrapVue, IconsPlugin } from 'bootstrap-vue';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import 'bootstrap/dist/css/bootstrap.css';
import VueRouter from 'vue-router';
import Vuelidate from "vuelidate";
import routes from './routes';
import store from './store';

axios.defaults.baseURL="http://localhost:8080";
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(VueRouter);
Vue.use(Vuelidate);
Vue.config.productionTip = false

export const eventEmitter = new Vue();

const router = new VueRouter({
  mode: 'history',
  routes
})
new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
