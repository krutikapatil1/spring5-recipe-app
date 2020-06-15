<template>
    <div>
        <div class="row">
            <div class="col-md-12">
                <router-link :to="{path: '/recipes/addRecipe'}" tag="button" class="btn btn-success">New Recipe</router-link>
            </div>
        </div>
        <div class="row mt-5">
            <div class="col-md-12">
                <router-link
                        tag="a"
                        class="list-group-item clearfix"
                        :class="{active: selectedIndex === recipe.id}"
                        style="cursor: pointer"
                        v-for="recipe in recipes" :key="recipe.id"
                        @click.native="selectedIndex = recipe.id"
                        :to="{path: '/recipes/' + recipe.id}"
                >
                    <div class="float-left">
                        <h6 class="list-group-item-heading">{{ recipe.description }}</h6>
                        <p class="list-group-item-text">{{ recipe.description }}</p>
                    </div>
                    <!--<span class="float-right">
                    <img :src="recipe.imageUrl" alt class="img-responsive" style="max-height: 50px;" />
                  </span>-->
                </router-link>
            </div>
        </div>
    </div>
</template>

<script>
    import { mapGetters } from 'vuex';

    export default {
        data() {
            return {
                selectedIndex: -1
            }
        },
        computed: {
            ...mapGetters([
                'recipes',
            ])
        },
        created() {
            this.$store.dispatch('loadData');
        }
    }
</script>

<style scoped>

</style>