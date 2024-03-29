<template>
    <div class="book-container">
    <BookCard v-for = "book in  $store.state.books" :key=" book.isbn" v-bind:book = "book"></BookCard>
  </div>
</template>

<script>
import BookCard from './BookCard.vue';
export default {
  components: {BookCard}
}
</script>

<style>
.book-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>