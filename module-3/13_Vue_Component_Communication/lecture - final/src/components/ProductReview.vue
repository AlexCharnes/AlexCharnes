<template>
  <!-- class main moves to main div on App.vue -->
  <div class="main">

    <!-- Title and Description move to App.vue -->


    <!-- div.well-display moves to App.vue -->
    
      <!-- div for average rating moves to AverageSummary.vue -->


      <!-- divs for individual star ratings move to StarSummary.vue -->
  




    <!-- Show Form button and the form move to AddReview.vue -->


    <!-- No reviews found moves to ReviewList.vue -->
    

    <!-- div for an individual review moves to ReviewDisplay.vue.  v-for moves to ReviewList.vue -->

  </div>
</template>

<script>
export default {
  data() {
    return {
      // name, description, filter, reviews move to the VueX Store
      
      // showForm, nextReviewId, and newReview move to AddReview.vue
     
 
    };
  },
  computed: {
    // filteredReviews: move to ReviewList.vue
 
    // averageRating: move to AverageSummary.vue

    // numberOfXStarReviews: no longer needed as they are handled by the StarSummary component

    // isFormValid: Move to AddReview.vue

  },
  methods: {
    /*
     * Returns the next review id. Normally, a database would assign a unique id for the review.
     * This code simulates that since there's no database in this example.
     * 
     * Moves to AddReview.vue
     */
    getNextReviewId() {
      return this.nextReviewId++;
    },
    // addNewReview and resetForm: Move to AddReview.vue

    // numberOfReviews: move to StarSummary.vue

  }

};
</script>

<style scoped>
.main {
  margin: 1rem 0;
}

.well-display {
  display: flex;
  justify-content: space-around;
  margin-bottom: 1rem;
}

.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
  padding: 0.25rem;
}

.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

.amount:hover {
  cursor: pointer;
}

.favorited {
  background-color: lightyellow;
}

.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

.rating img {
  height: 100%;
}

.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

.review p {
  margin: 20px;
}

.review h3 {
  display: inline-block;
}

.review h4 {
  font-size: 1rem;
}

.form-element {
  margin-top: 10px;
}

.form-element label {
  display: block;
}

.form-element input,
.form-element select {
  height: 30px;
  width: 300px;
}

.form-element textarea {
  height: 60px;
  width: 300px;
}

form input[type=button] {
  width: 100px;
}

form input[type=submit] {
  width: 100px;
  margin-right: 10px;
}
</style>
