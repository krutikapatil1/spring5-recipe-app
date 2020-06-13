import Recipes from './components/Recipes/Recipes.vue';
import Home from './components/common/Home.vue';

export const routes = [
    {path: '/', component: Home},
    {path: '/recipes', component: Recipes},
]