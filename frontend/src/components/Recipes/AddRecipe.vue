<template>
    <div>
        <div class="row">
            <div class="col-md-3 col-xs-3 col-sm-3">
                <button class="btn btn-success" @click.prevent="saveRecipe" :disabled="$v.$invalid">Save Recipe</button>
            </div>
            <div class="col-md-2 col-xs-2 col-sm-2">
                <router-link :to="{path: '/recipes'}" tag="button" class="btn btn-danger">Cancel</router-link>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-md-12 col-xs-12 col-sm-12">
                <b-form>
                    <b-form-group id="input-group-1" label="Description:" label-for="input-1">
                        <b-form-input
                                id="input-1"
                                v-model="recipe.description"
                                required
                        ></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-4" label="Categories:" label-for="checkboxes-4">
                        <b-form-checkbox-group v-model="categories" id="checkboxes-4">
                            <b-form-checkbox value="American">American</b-form-checkbox>
                            <b-form-checkbox value="Mexican">Mexican</b-form-checkbox>
                        </b-form-checkbox-group>
                    </b-form-group>

                    <b-form-group id="input-group-2" label="Prep Time:" label-for="input-2">
                        <b-form-input
                                id="input-2"
                                type="number"
                                v-model="recipe.prepTime"
                                required
                        ></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-3" label="Cook Time:" label-for="input-3">
                        <b-form-input
                                id="input-3"
                                type="number"
                                v-model="recipe.cookTime"
                                required
                        ></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-6" label="Difficulty:" label-for="input-6">
                        <b-form-select
                                id="input-6"
                                v-model="recipe.difficulty"
                                :options="difficultyLevels"
                                required
                        ></b-form-select>
                    </b-form-group>

                    <b-form-group id="input-group-5" label="Servings:" label-for="input-5">
                        <b-form-input
                                id="input-5"
                                type="number"
                                v-model="recipe.servings"
                                required
                        ></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-7" label="Source:" label-for="input-7">
                        <b-form-input
                                id="input-7"
                                v-model="recipe.source"
                                required
                        ></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-8" label="Url:" label-for="input-8">
                        <b-form-input
                                id="input-8"
                                v-model="recipe.url"
                                required
                        ></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-9" label="Ingredients:" label-for="input-9">
                        <div class="row mt-1" v-for="(ingredient, index) in recipe.ingredients" :key="index">
                            <div class="col-md-5 col-xs-5 col-sm-5">
                                <b-form-input
                                        id="input-8"
                                        v-model="ingredient.description"
                                        required
                                ></b-form-input>
                            </div>
                            <div class="col-md-2 col-xs-2 col-sm-2">
                                <b-form-input
                                        id="input-9"
                                        type="number"
                                        v-model="ingredient.amount"
                                        required
                                ></b-form-input>
                            </div>
                            <div class="col-md-3 col-xs-3 col-sm-3">
                                <b-form-select
                                        id="input-6"
                                        v-model="ingredient.uom.description"
                                        :options="uomTypes"
                                        required
                                ></b-form-select>
                            </div>
                            <div class="col-md-2 col-xs-2 col-sm-2">
                                <button class="btn btn-danger" @click.prevent="deleteIngredient(index)">X</button>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-md-12 col-xs-12 col-sm-12">
                                <button class="btn btn-success" @click.prevent="addIngredient">Add Ingredient</button>
                            </div>
                        </div>
                    </b-form-group>
                    <b-form-group id="input-group-11" label="Directions:" label-for="input-11">
                        <b-form-textarea
                                id="textarea"
                                v-model="recipe.directions"
                                placeholder="Enter something..."
                                rows="3"
                                max-rows="6"
                                required
                        ></b-form-textarea>
                    </b-form-group>
                    <b-form-group id="input-group-10" label="Notes:" label-for="input-10">
                        <b-form-textarea
                                id="textarea"
                                v-model="recipe.notes.recipeNotes"
                                placeholder="Enter something..."
                                rows="3"
                                max-rows="6"
                        ></b-form-textarea>
                    </b-form-group>
                </b-form>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-md-12 col-xs-12 col-sm-12">
                <b-card class="mt-3" header="Form Data Result">
                    <pre class="m-0">{{ recipe }}</pre>
                </b-card>
            </div>
        </div>
    </div>
</template>

<script>
    import { required } from 'vuelidate/lib/validators';
    export default {
        name: "AddEditRecipe",
        data() {
            return {
                recipe: {
                    description: '',
                    categories: [],
                    prepTime: '',
                    cookTime: '',
                    difficulty: '',
                    servings: '',
                    source: '',
                    url: '',
                    ingredients: [
                        {
                            description: '',
                            amount: '',
                            uom: {
                                description: ''
                            }
                        }
                    ],
                    notes: {
                        recipeNotes: ''
                    },
                    directions: ''
                },
                difficultyLevels: [
                    'EASY', 'MODERATE', 'HARD'
                ],
                uomTypes: [
                    'Teaspoon', 'Tablespoon', 'Cup', 'Dash', 'Pint', 'Each', 'Ounce'
                ],
                categories: []
            }
        },
        validations: {
            recipe: {
                description: {required},
                prepTime: {required},
                cookTime: {required},
                difficulty: {required},
                servings: {required},
                source: {required},
                url: {required},
                ingredients: {
                    $each: {
                        description: {required},
                        amount: {required},
                        uom: {
                            description: {required}
                        }
                    }
                },
                notes: {
                    recipeNotes: {
                        required
                    }
                },
                directions: {
                    required
                }
            }
        },
        methods: {
            addIngredient() {
                let addNew = true;
                this.recipe.ingredients.forEach(ingredient => {
                    if (ingredient.description == '' || ingredient.amount == '' || ingredient.uom == {} || ingredient.uom.description == '') {
                        addNew = false;
                    }
                })
                if (addNew) {
                    this.recipe.ingredients.push(
                        {
                            description: '',
                            amount: '',
                            uom: {
                                description: ''
                            }
                        }
                    )
                }
            },
            deleteIngredient(index) {
                this.recipe.ingredients.splice(index, 1);
            },
            saveRecipe(){
                this.categories.forEach(category => {
                    this.recipe.categories.push({
                        description: category
                    })
                })
                this.$store.dispatch('addUpdateRecipe', this.recipe);
            }
        }
    }
</script>

<style scoped>

</style>