<template>
  <div class="main">
    <ProductReview />

    <!-- Title and Description -->
    <!-- div.well-display -->
      <!-- Average Summary -->
      <!-- Star Summaries -->
    <!-- Add Review -->
    <!-- Review List -->
  </div>
</template>

<script>
import ProductReview from './components/ProductReview.vue'

export default {
  components: {
    ProductReview
  }
};
</script>

<style scoped>
.main {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}

.well-display {
  display: flex;
  justify-content: space-around;
  margin-bottom: 1rem;
}
</style>
