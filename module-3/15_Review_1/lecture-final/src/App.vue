<template>
  <div class="main">
    <the-header />
    <router-view />
     <the-footer />
  </div>
</template>

<script>

import TheHeader from './components/TheHeader.vue';
import TheFooter from './components/TheFooter.vue';

export default {

  components: {
    TheHeader,
    TheFooter
  }

};
</script>

<style>
.main {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 1980px;
  margin: 0 auto 0 auto;
}
</style>
