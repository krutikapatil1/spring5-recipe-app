import Vue from 'vue'
import App from './App.vue'
import axios from 'axios';
import {BootstrapVue, IconsPlugin } from 'bootstrap-vue';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import 'bootstrap/dist/css/bootstrap.css';
import VueRouter from 'vue-router';
import {routes} from './routes';

axios.defaults.baseURL="http://localhost:8080";
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(VueRouter);
Vue.config.productionTip = false
Vue.config.devtools = true

export const eventEmitter = new Vue();

const router = new VueRouter({
  mode: 'history',
  routes
})
new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
