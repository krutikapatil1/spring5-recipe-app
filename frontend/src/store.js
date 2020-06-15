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
        ADD_RECIPE: (state, recipe) => {
            state.recipes.push(recipe);
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
        addRecipe: ({commit}, recipe) => {
            axios.post('/saveRecipe', recipe).then(res => {
                console.log(res.data);
                commit('ADD_RECIPE', res.data);
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