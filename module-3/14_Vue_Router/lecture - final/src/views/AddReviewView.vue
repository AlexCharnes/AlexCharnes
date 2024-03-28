<template>
    <h1>Add Review</h1>
    <AddReview v-bind:productId="productIdComputedProperty" />
</template>

<script>
import AddReview from '../components/AddReview.vue';

export default {
    components: {
        AddReview
    },
    computed: {
        productIdComputedProperty() {
            return this.$route.params.id;
        }
    }
}
</script>

<style>

</style>