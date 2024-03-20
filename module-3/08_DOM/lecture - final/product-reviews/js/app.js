const bookName = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Madwell',
    title: 'What a book!',
    review:
    "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language. Yes indeed, it is a book!",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add the product name to the page title
 * Get the page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById("page-title");
  const titleSpan = pageTitle.querySelector("span.name");
  titleSpan.innerText = bookName;

}

/**
 * Add the product description to the page.
 */
function setPageDescription() {
  document.querySelector("p.description").innerText = description;
}

/**
 * Display all of the reviews on the page.
 * Loop over the array of reviews and use some helper functions
 * to create the elements needed for the markup and add them to the DOM.
 */
function displayReviews() {
  const mainDiv = document.getElementById("main");

  reviews.forEach( review => {
    // Create the review div
    const containerDiv = document.createElement('div');
    // Add the review class to the div
    containerDiv.classList.add("review");
    // Add the reviewer
    addReviewer(containerDiv,review.reviewer);
    // add the rating
    addRating(containerDiv, review.rating);
    // add the review title
    addTitle(containerDiv, review.title);
    // add the review text
    addReview(containerDiv, review.review);
    // insert the new div as the last child of the container (mainDiv)
    mainDiv.insertAdjacentElement('beforeend', containerDiv);
  });

}

/**
 * Create a new h2 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  const reviewerH4 = document.createElement('h4');
  reviewerH4.innerHTML = name;
  parent.appendChild(reviewerH4);
}

/**
 * Add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {
  // Create a div
  const ratingDiv = document.createElement('div');
  // add the class rating
  ratingDiv.classList.add("rating");
  // for each rating
  for (let i = 0; i < numberOfStars; i++) {
    // create an img
    const img = document.createElement('img');
    // set the src attribute to img/star.png
    img.src = 'img/star.png';
    // add the class ratingStar
    img.classList.add('ratingStar');
    // append to the div.rating
    ratingDiv.appendChild(img);
  }
  // append div.rating to the parent
  parent.appendChild(ratingDiv);
}

/**
 * Add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  // Create an H3
  const titleH3 = document.createElement('h3');
  // Set the text to title
  titleH3.innerText = title;
  // append the the parent container
  parent.appendChild(titleH3);
}

/**
 * Add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  const reviewP = document.createElement('p');
  reviewP.innerText = review;
  parent.appendChild(reviewP);
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on the page
displayReviews();
