<template>
  <nav>
    <router-link v-bind:to="{ name: 'home' }">Home</router-link>
    <router-link v-bind:to="{ name: 'books' }">Books</router-link>
  </nav>
  <div id="book-app">
    <router-view />
  </div>
</template>

<script>

export default {
  
}
</script>

<style>
#book-app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px;
}
</style>
