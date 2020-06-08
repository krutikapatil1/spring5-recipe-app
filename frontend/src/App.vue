<template>
  <div id="app">
    <b-table striped hover head-variant="dark" :items="dataRes"></b-table>
  </div>
</template>

<script>
  import axios from 'axios';
export default {
  name: 'App',
  data() {
    return {
      dataRes: []
    }
  },
  created() {
    axios.get('getRecipes').then(res=> {
      console.log(res.data);
      this.dataRes = res.data;
    })
  }
}
</script>

<style>
</style>
