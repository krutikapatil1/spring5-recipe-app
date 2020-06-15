import Vue from 'vue';
import Vuex from 'vuex';
import axios from "axios";

Vue.use(Vuex);
Vue.config.devtools = true

export default new Vuex.Store({
    state: {
        recipes: []
    },
    mutations: {
        LOAD_DATA: (state, recipes) => {
            state.recipes = recipes;
        },
        ADD_UPDATE_RECIPE: (state, newRecipe) => {
            let index = -1;
            state.recipes.forEach(recipe => {
                index++;
                if (recipe.id == newRecipe.id) {
                    state.recipes.splice(index, 1);
                    return;
                }
            })
            state.recipes.push(newRecipe);
        }
    },
    actions: {
        loadData: ({commit}) => {
            axios.get('/getRecipes').then(res => {
                console.log(res.data);
                commit('LOAD_DATA', res.data);
            }).catch(error => {
                console.log(error);
            })
        },
        addUpdateRecipe: ({commit}, recipe) => {
            axios.post('/saveRecipe', recipe).then(res => {
                console.log(res.data);
                commit('ADD_UPDATE_RECIPE', res.data);
            }).catch(error => {
                    console.log(error);
                })
        }
    },
    getters: {
        recipes: (state) => {
            return state.recipes;
        },
        recipeById: (state) => (id) => {
            let recipe = state.recipes.find( recipe => recipe.id == id );
            return recipe;
        }
    }
})