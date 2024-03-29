<template>
  <div class="card">
    <h2 class = "book-title">{{ book.title }}</h2>
    <h3 class = "book-author">Author: {{ book.author }}</h3>
    <img class = "book-image" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" alt="Book Cover">
    <button class="mark-read" v-if="!book.read" @click="toggleReadStatus(true)">Mark Read</button>
    <button class="mark-read" v-if="book.read" @click="toggleReadStatus(false)">Mark Unread</button>
  </div>
</template>

<script>
export default {
  props: {
    book: {
      type: Object,
      required: true
    }
  } 
}
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
  position: relative;
}

.card.read {
  background-color: lightgray;
}

.card .book-title {
  font-size: 1.5rem;
}

.card .book-author {
  font-size: 1rem;
}

.book-image {
  width: 80%;
}

.mark-read, .mark-unread {
  display: block;
  position: absolute;
  bottom: 40px;
  width: 80%;
  left: 10%;
  font-size: 1rem;
}
</style>