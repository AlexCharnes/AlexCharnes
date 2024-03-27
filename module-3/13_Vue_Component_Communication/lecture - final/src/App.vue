<template>
  <div class="main">


    <!-- Title and Description -->
    <h2>Product Reviews for {{ $store.state.name }}</h2>
    <p class="description">{{ $store.state.description }}</p>
    <!-- div.well-display -->
    <div class="well-display">
      <!-- Average Summary -->
      <AverageSummary  />
      <!-- Star Summaries -->
      <StarSummary v-for="n in 5" v-bind:key="n" v-bind:rating="n" />
    </div>
    <!-- Add Review -->
    <AddReview /> 
    <!-- Review List -->
    <ReviewList />

  </div>
</template>

<script>
import AverageSummary from './components/AverageSummary.vue';
import StarSummary from './components/StarSummary.vue';
import ReviewList from './components/ReviewList.vue';
import AddReview from './components/AddReview.vue';

export default {
  components: {
    AverageSummary,
    StarSummary,
    ReviewList,
    AddReview
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
