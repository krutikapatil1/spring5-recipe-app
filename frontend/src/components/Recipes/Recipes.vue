<template>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-4">
                <app-recipe-list></app-recipe-list>
            </div>
            <div class="col-md-8 col-sm-8 col-xs-8">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>
<script>
    import RecipeList from "./RecipeList.vue";
    export default {
        components: {
            appRecipeList: RecipeList,
        }
    }
</script>
<style scoped></style>