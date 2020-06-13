<template>
    <div>
        <a
           class="list-group-item clearfix"
           :class="{active: selectedIndex == recipe.id}"
           style="cursor: pointer"
           v-for="recipe in recipes" :key="recipe.id"
           @click="recipeSelected(recipe)"
        >
            <div class="float-left">
                <h6 class="list-group-item-heading">{{ recipe.description }}</h6>
                <p class="list-group-item-text">{{ recipe.description }}</p>
            </div>
            <!--<span class="float-right">
            <img :src="recipe.imageUrl" alt class="img-responsive" style="max-height: 50px;" />
          </span>-->
        </a>
    </div>
</template>

<script>
    import axios from "axios";
    import {eventEmitter} from "../../main";

    export default {
        data() {
            return {
                recipes: [],
                selectedIndex: -1
            }
        },
        created() {
            axios.get('/getRecipes').then(res => {
                console.log(res.data);
                this.recipes = res.data;
            })
        },
        methods: {
            recipeSelected(recipe) {
                this.selectedIndex = recipe.id;
                eventEmitter.$emit('recipeSelected', recipe);
            }
        }
    }
</script>

<style scoped>

</style>