<template>
  <div class="main">
    <!-- Step 3: use the imported component as a tag in the HTML -->
    <ProductReview />
    <div class="spacer"></div>
    <ContactForm />
  </div>
</template>

<script>
// Step 1: Import the component
import ProductReview from './components/ProductReview.vue';
import ContactForm from './components/ContactForm.vue';

export default {
  // Step 2: Add the component to the components list
  components: {
    ProductReview,
    ContactForm
  }
}
</script>

<style>
.main div.spacer {
  height: 50px;
}
.main {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
</style>
