<template>
  <div v-if="filteredReviews.length === 0">
      <p>No {{ $store.state.filter }} Star Reviews Found</p>
  </div>
   <ReviewDisplay v-for="currentReview in filteredReviews" 
    v-bind:key="currentReview.id" 
    v-bind:review="currentReview"/>
</template>

<script>
import ReviewDisplay from './ReviewDisplay.vue'

export default {

  
  components: {
    ReviewDisplay
  },
  computed: {
    filteredReviews() {
      const currentFilter = this.$store.getters.getCurrentFilter;
      return this.$store.state.reviews.filter(review => {
        return currentFilter === 0 || currentFilter === review.rating;
      });
    }
  }
};
</script>
