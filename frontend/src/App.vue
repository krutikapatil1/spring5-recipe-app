<template>
  <div id="app">
    <app-header></app-header>
    <div class="container">
      <div class="row">
        <div class="col-md-12 col-xs-12 col-sm-12">
          <router-view></router-view>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import Header from './components/common/Header.vue';
  export default {
    components: {
      appHeader: Header
    },
    created() {
      this.$store.dispatch('loadDifficultyLevels');
    }
  }
</script>

<style>
</style>
