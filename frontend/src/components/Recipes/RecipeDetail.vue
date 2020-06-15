<template>
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-xs-12 col-sm-12">
                <div v-if="recipe == undefined">
                    <p>Recipe Not Found!</p>
                </div>
                <div v-else>
                    <div>
                    <b-card
                            border-variant="primary"
                            header-bg-variant="primary"
                            header-text-variant="white"
                            :header="recipe.description"
                            header-tag="header"
                    >
                        <b-card-text>
                            <div class="row">
                                <div class="col-md-3">
                                    <h6>Categories</h6>
                                </div>
                                <div class="col-md-3">
                                    <ul>
                                        <li v-for="category in recipe.categories" :key="category.id">{{category.description}}</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">
                                    <h6>Prep Time</h6>
                                </div>
                                <div class="col-md-3">
                                    <p>{{recipe.prepTime}} min</p>
                                </div>
                                <div class="col-md-3">
                                    <h6>Difficulty</h6>
                                </div>
                                <div class="col-md-3">
                                    <p>{{recipe.difficulty}}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">
                                    <h6>Cook Time</h6>
                                </div>
                                <div class="col-md-3">
                                    <p>{{recipe.cookTime}} min</p>
                                </div>
                                <div class="col-md-3">
                                    <h6>Servings</h6>
                                </div>
                                <div class="col-md-3">
                                    <p>{{recipe.servings}}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">
                                    <h6>Source</h6>
                                </div>
                                <div class="col-md-3">
                                    <p>{{recipe.source}}</p>
                                </div>
                                <div class="col-md-3">
                                    <h6>Url</h6>
                                </div>
                                <div class="col-md-3">
                                    <p>{{recipe.url}}</p>
                                </div>
                            </div>
                        </b-card-text>
                    </b-card>
                    </div>
                    <div class="mt-3">
                        <b-card
                                border-variant="primary"
                                header-bg-variant="primary"
                                header-text-variant="white"
                                header="Ingredients"
                                header-tag="header"
                        >
                            <b-text>
                                <ul>
                                    <li v-for="ingredient in recipe.ingredients" :key="ingredient.id">{{ingredient.amount}} {{ingredient.uom.description}} of {{ingredient.description}}</li>
                                </ul>
                            </b-text>
                        </b-card>
                    </div>
                    <div class="mt-3">
                        <b-card
                                border-variant="primary"
                                header-bg-variant="primary"
                                header-text-variant="white"
                                header="Directions"
                                header-tag="header"
                        >
                            <b-text>
                                <p>{{recipe.directions}}</p>
                            </b-text>
                        </b-card>
                    </div>
                    <div class="mt-3">
                        <b-card
                                border-variant="primary"
                                header-bg-variant="primary"
                                header-text-variant="white"
                                header="Notes"
                                header-tag="header"
                        >
                            <b-text>
                                <p>{{recipe.notes.recipeNotes}}</p>
                            </b-text>
                        </b-card>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "RecipeDetail",
        data() {
            return {
                recipe: undefined
            }
        },
        created() {
          console.log(this.$route.params.id);
          let id = this.$route.params.id;
          console.log(this.$store.getters.recipeById(id));
          this.recipe = this.$store.getters.recipeById(id);
        },
        watch: {
            '$route' (to) {
                console.log(to.params.id);
                let id = to.params.id;
                console.log(this.$store.getters.recipeById(id));
                this.recipe = this.$store.getters.recipeById(id);
            }
        }

    }
</script>

<style scoped>

</style>