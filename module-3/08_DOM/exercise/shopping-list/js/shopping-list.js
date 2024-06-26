// add pageTitle
const pageTitle = 'My Shopping List';
// add groceries
let groceries = ['milk', 'eggs', 'bacon', 'bread', 'cereal', 'sausage', 'peppers', 'onion', 'cilantro', 'heavy cream']
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const pageTitleElement = document.getElementById('title');
  pageTitleElement.textContent = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const mainList = document.getElementById('groceries');

  groceries.forEach( item =>{
    const listItem = document.createElement("li");
    listItem.innerText = item;
    mainList.insertAdjacentElement('beforeend', listItem)
  })
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
//item.classList.add("completed");

function markCompleted() {
  const mainList = document.querySelectorAll('#groceries li')

  mainList.forEach( item => {
    item.classList.add('completed')
  })
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
