<template>
    <h1>{{ product.name }}</h1>
    <p class="description">{{ product.description }}</p>
    <div class="actions">
        <RouterLink v-bind:to="{ name: 'products' }">Back to Products</RouterLink>&nbsp;|
        <RouterLink v-bind:to="{ name: 'add-review', params: { id: product.id } }">Add Review</RouterLink>
    </div>
    <div class="well-display">
        <average-summary v-bind:reviews="product.reviews" />
        <star-summary v-for="i in 5" v-bind:rating="i" v-bind:key="i" v-bind:reviews="product.reviews" />
    </div>
    <review-list v-bind:reviews="product.reviews" />
</template>
  

<script>
import AverageSummary from '../components/AverageSummary.vue';
import StarSummary from '../components/StarSummary.vue';
import ReviewList from '../components/ReviewList.vue';

export default {
    components: {
        AverageSummary,
        StarSummary,
        ReviewList
    },
    computed: {
        product() {
            // Get the Product Id from the URL
            const productIdFromUrlParams = this.$route.params.id;
            const product = this.$store.state.products.find(p => p.id == productIdFromUrlParams);
            return product;
        }
    }
}
</script>


<style scoped>
.well-display {
  display: flex;
  justify-content: space-around;
  margin-bottom: 1rem;
}
.actions {
  margin: 2rem;
}
</style>
