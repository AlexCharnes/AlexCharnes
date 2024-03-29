import { createStore as _createStore } from 'vuex';

export function createStore() {
  return _createStore({
    state: {
      books: [
        {
          title: "Kafka on the Shore",
          author: "Haruki Murakami",
          read: false,
          isbn: "9781784877989"
        },
        {
          title: "The Girl With All the Gifts",
          author: "M.R. Carey",
          read: true,
          isbn: "9780356500157"
        },
        {
          title: "The Old Man and the Sea",
          author: "Ernest Hemingway",
          read: true,
          isbn: "9780684830490"
        },
        {
          title: "Le Petit Prince",
          author: "Antoine de Saint-Exupéry",
          read: false,
          isbn: "9783125971400"
        }
      ]
    },
    mutations: {
      toggleReadStatus(state, book) {
        // Find the book by ISBN or title
        const foundBook = state.books.find(b => b.isbn === book.isbn || b.title === book.title);
        // If the book is found, toggle its read status
        if (foundBook) {
          foundBook.read = !foundBook.read;
        }
      }},
      actions: {},
      modules: {},
      // Strict should not be used in production code. It is used here as a
      // learning aid to warn you if state is modified without using a mutation.
      strict: true
    });

}


