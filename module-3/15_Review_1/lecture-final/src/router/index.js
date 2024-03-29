import { createRouter as _createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import AboutView from '../views/AboutView.vue';
import PlayerView from '../views/PlayerView.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: AboutView
  },
  {
    path: '/search',
    name: 'search',
    component: PlayerView
  }  

];

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
