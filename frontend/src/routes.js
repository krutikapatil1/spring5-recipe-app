import Recipes from './components/Recipes/Recipes.vue';
import Home from './components/common/Home.vue';
import RecipeDetail from "./components/Recipes/RecipeDetail.vue";
import RecipeStart from "./components/Recipes/RecipeStart.vue";
import AddRecipe from "./components/Recipes/AddRecipe.vue";
import EditRecipe from "./components/Recipes/EditRecipe.vue";

export default [
    {path: '/', component: Home},
    {
        path: '/recipes',
        component: Recipes,
        children: [
            {path: '', component: RecipeStart},
            {path: 'addRecipe', component: AddRecipe},
            {path: 'edit/:id', component: EditRecipe},
            {path: ':id', component: RecipeDetail}
        ]}
]