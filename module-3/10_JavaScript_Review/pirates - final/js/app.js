/*
* Add Events and functions to move the Ship and Win the game
*/
const obstacles = ['pirate', 'iceberg'];
const directions = ['up','right','down', 'left'];
let clock;

// Creates the Grid -- this should only occur after the DOM loads
document.addEventListener('DOMContentLoaded', () => {
    createGrid();
    document.querySelector('body').addEventListener('keydown', (eventObj) => {
        if (eventObj.key === 'ArrowRight') {
            moveShipRight();
        }
        if (eventObj.key === 'ArrowLeft') {
            moveShipLeft();
        }
        if (eventObj.key === 'ArrowDown') {
            moveShipDown();
        }
        if (eventObj.key === 'ArrowUp') {
            moveShipUp();
        }
    });

    document.getElementById("resetButton").addEventListener('click', () => {
        resetGame();
    })

});


/*
  Move the Ship 
*/
function moveShipRight() {
    const ship = shipLocation();
    const newLocation = ship.nextElementSibling;
    moveShip(ship, newLocation);
}

function moveShipLeft() {
    const ship = shipLocation();
    const newLocation = ship.previousElementSibling;
    moveShip(ship, newLocation);
}

function moveShipDown() {
    const ship = shipLocation();
    const newLocation = getElementAtSameIndex(ship, ship.parentElement.nextElementSibling);
    moveShip(ship, newLocation);
}

function moveShipUp() {
    const ship = shipLocation();
    const newLocation = getElementAtSameIndex(ship, ship.parentElement.previousElementSibling);
    moveShip(ship, newLocation);
}

function getElementAtSameIndex(ship, newParent) {
    let elementAtIndex = null;

    if (newParent != null) {
        const index = Array.from(ship.parentNode.children).indexOf(ship);
        elementAtIndex = newParent.childNodes[index];
    }

    return elementAtIndex;
}

function canMoveToNewLocation(newLocation) {
    if (newLocation == null || newLocation.classList.contains('iceberg') || 
        newLocation.classList.contains('pirate')) {
        return false;
    }
    return true;
}

function moveShip(currentLocation, newLocation) {

    if (isLoss(newLocation)) {
        lose("You suck!");
    }
    if (isWin(newLocation)) {
        win();
    } 
    if (canMoveToNewLocation(newLocation)) {
        currentLocation.classList.remove('boat');
        newLocation.classList.add('boat');
    } 
}


function shipLocation() {
    // Get the return the current location of the ship
    return document.getElementById('frame').querySelector('.boat');
}





/*
  Win Conditions
*/
function isWin(newLocation) {
    if (newLocation && newLocation.classList.contains('treasure')) {
        return true;
    }
    return false;
}

function win() {
    changeAnnounceText('You Win!');
    document.getElementById('frame').querySelector('.treasure').classList.remove('treasure');
}



/*
    Loss Conditions
*/
function isLoss(newLocation) {
    if (newLocation && 
        (newLocation.classList.contains('pirate') 
        || newLocation.classList.contains('iceberg'))) {
            return true;
        }
    return false;
}

function lose(message) {
    changeAnnounceText(message);
    const ship = shipLocation();
    ship.classList.remove('boat');

    ship.classList.add('boat_explosion');
    setTimeout( () => {
        ship.classList.remove('boat_explosion');
        ship.classList.add('boat_sunk');
    }, 300);
}

function changeAnnounceText(newText) {
    const announce = document.querySelector('h1.announce');
    announce.innerText = newText;
}

/**
 * Reset the Game
 */
function resetGame() {
    resetBoat();
    // Create the obstacles
    createObstacles();

    // Inform the user they can start
    changeAnnounceText('Play');

    // Set the starting location of the boat and the treasure
    const frame = document.getElementById('frame');
    frame.firstElementChild.firstElementChild.classList.add('boat');
    frame.lastElementChild.lastElementChild.classList.add('treasure');
}

function resetBoat() {
    const ship = shipLocation();
    if (ship) {
        ship.classList.remove('boat');
    }
    const sunkShip = document.getElementById('frame').querySelector('.boat_sunk');
    if (sunkShip) {
        sunkShip.classList.remove('boat_sunk');
    }
}

/*
    Setup the Game
*/
/**
 * Creates the game grid
 */
function createGrid() {

    // Get a Reference to the game board 
    const frame = document.getElementById('frame');

    for (let i = 0; i < 10 ; i++) {
        buildRow(frame); 
    }
    resetGame();
}

/**
 * Builds the grid rows
 * @param {HTMLElement} frame 
 */
function buildRow(frame) {
    // Create a Div to be the row
    const row = document.createElement('div');
    // Add the row class to the row div
    row.classList.add('row')
    // Append the row div to the game board (frame)
    frame.appendChild(row);
    for (let i = 0; i < 10 ; i++) {
        buildSquare(row, i); 
    }    
}

/**
 * Builds the grid squares 
 * @param {HTMLElement} row 
 * @param {int} count 
 */
function buildSquare(row, count) {
   // Create a Div for the game board square
   const square = document.createElement('div');
   // Add the square class to the div
   square.classList.add('square');
   // Insert the square at the end of the row
  row.insertAdjacentElement('beforeend', square);
}

function createObstacles() {

    // Select the frame
    // get the list of child nodes (rows)
    // Loop over the rows
        // Loop over the squares the rows
    // get a random value using Math.random()
    // check if anything exists on that square

    const rows = document.getElementById('frame').children;
    Array.from(rows).forEach( (row, rowIndex) =>{
        const cells = row.children;
        Array.from(cells).forEach( (cell, cellIndex) => {
            if ( !(rowIndex === 0 && cellIndex === 0) && 
                !(rowIndex === rows.length - 1 && cellIndex === cells.length - 1)){
                  addObstacles(cell);  
                }
        });
    });

}


/**
 * Adds random obstacles to a game cell
 * 
 * @param {HTMLElement} cell 
 */
function addObstacles(cell) {
    // remove any existing pirates or icebergs
    cell.classList.remove('pirate');
    cell.classList.remove('iceberg');

    const rand = getRandomNumber(100, false);

    if (rand > 85) {
        // Add iceberg here
        cell.classList.add('iceberg');
    } else if (rand > 80) {
        // Add pirates here
        cell.classList.add('pirate');
    } 
}


/*
  Move the Pirates
*/



function getRandomNumber(top, zeroBased) {
    let randNumber = (Math.floor(Math.random() * top) + 1);
    return zeroBased ? randNumber - 1: randNumber;
}
