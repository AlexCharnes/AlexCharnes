function unknownParams() {
    console.table(arguments);

    // arguments is an Object not an Array
    // It can be converted into an Array if needed
    const argumentsAsAnArray = Array.from(arguments);
    argumentsAsAnArray.push("this is now an array");
    console.table(argumentsAsAnArray);
}

/*
    The rest parameter must be the last parameter and will 
    make an array out of all remaining values sent as arguments
*/
function paramWithRestArguments(firstParameter, ...args) {
    console.log(firstParameter);
    console.table(args);
}

function multipleWithSpread(x, y, z) {
    return x * y * z;
}

const args = [1,2, 3, 4];
console.log(multipleWithSpread(...args));
//multipleWithSpread(args[0], args[1], args[2], args[3])



/******************************************
 * Anonymous Functions
 */

function addNumbers(x, y) {
    return x + y;
}

const addNumbersAgain = function (x, y) {
    return x + y;
}

const func1 = addNumbersAgain;

const addNumbersThird = (x, y) => {
    return x + y;
}

function doMath(func, x, y) {
    return "Result of math: " + func(x,y);
}

console.log( doMath(addNumbersThird, 2, 5) );

console.log( doMath( (x, y) => {
    return Math.PI + x * y;
}, 10, 2) );

/******************************************
 * Array forEach()
 */

// Arrays to work with 
const nums = [1,2,3,4,5,6,7,8,9,10];
const stringArr = ['Abc', 'Efg', 'Hij', 'Lmn'];
const products = [
    {
        name: 'book',
        price: 10
    },
    {
        name: 'laptop',
        price: 100
    },
    {
        name: 'milk',
        price: 4
    },
    {
        name: 'broken compact disc',
        price: 22
    },
    {
        name: 'shirt',
        price: 25
    },
]

function printForEach() {
    // for (let i = 0; i < nums.length; i ++) {
    //     console.log(nums[i]);
    // }

    nums.forEach( (currentNumber) => {
        console.log(currentNumber);
    });

    nums.forEach( (currentNumber, index) => {
        console.log(`(${index}) ${currentNumber}`);
    });


    nums.forEach( (currentNumber, index, theOrginalArray) => {
        console.log(`(${index}) ${currentNumber}`);
        console.table(theOrginalArray);
    });
}

function printReduce() {

    const sum = nums.reduce( (ongoingSum, currentValue) => {
        // Return the new ongoingSum
        return ongoingSum + currentValue;
    });
    console.log("Reduced to " + sum);

    // let sum = 0
    // for (let i = 0; i < nums.length; i ++) {
    //     sum += nums[i];
    // }

    const alphabet = stringArr.reduce( (newString, currentString) => {
        return newString + currentString;
    });
    console.log(alphabet);

    const ourReduceFunction = (max, currentValue) => {
        return currentValue > max ? currentValue : max;
    };

    let largestNumber = nums.reduce(ourReduceFunction);
    console.log("Largest Number: " + largestNumber);

    console.log( [].reduce( (sum, n) => sum + n ) );

    ['a','b','c','d'].reduce( (newStr, c) => { return newStr + c.toUpperCase(); } )
    // Results in 'aBCD' because 'a' seeds the accumulator and is not sent to the 
    // the callback function

    ['a','b','c','d'].reduce( (newStr, c) => { return newStr + c.toUpperCase(); }, "" );
    // Results in 'ABCD' because the second argument in reduce(callbackFunc, startingValue), which is
    // "" in this example is used to seed the accumulator so the first element is sent to the
    // callback function

    const sumStartingAt0 = nums.reduce( (ongoingSum, currentValue) => {
        return ongoingSum + currentValue;
    }, 0);

    let largestNumberStartingAt0 = nums.reduce(ourReduceFunction, 0);


}

function printFilter() {

    /*
        Filter all the odd number out of the array
    */
   const filtredArray = nums.filter( currentValue => {
    if (currentValue % 2 == 0) {
        // Return True if we want to keep the value in the array
        return true;
    } else {
        // Return false if we don't want the value
        return false;
    }
   });
   console.table(filtredArray);

   // Filter out all values that contain the letter f
   const valuesWithoutF = stringArr.filter( str => {
    if (str.toLowerCase().includes("f")) {
        return false;  // It has an f so don't include it
    } else {
        return true;  // It does not have an f so include it
    }
   });
   console.table(valuesWithoutF);

   // Filter for only products that are < $25
   const lowCostItems = products.filter( product => {
    return product.price < 25;
   });
   console.table(lowCostItems);

   // Get the total cost of all the items that start with the letter B
   const costOfItemsThatStartWithB = products.filter( product => {
    return product.name.toLowerCase().startsWith("b");
   }).reduce( (totalCost, product) => {
    return totalCost + product.price;
   }, 0);
   console.log("Price of all items that start with b: " + costOfItemsThatStartWithB);


}



function printMap() {

    const allNumsPlus100 = nums.map( num => {
        return num + 100;
    });
    console.table(allNumsPlus100);

    
    const everyOtherNumsPlus100 = nums.map( (num, index) => {
        return num + (!(index % 2) ? 100 : 0);
    });
    console.table(everyOtherNumsPlus100);

    const fizzArr = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,45];
    const fizzed = fizzArr.map( n => {
        if (!(n % 3) && !(n % 5)) {
            return 'FizzBuzz';
        } else if (!(n % 3)) {
            return 'Fizz';
        } else if (!(n % 5)) {
            return 'Buzz';
        } else {
            return String(n);
        }
    });
    console.table(fizzed);

    // Can also store the anonymous function in a variable
    const fizzFunction = n => {
        if (!(n % 3) && !(n % 5)) {
            return 'FizzBuzz';
        } else if (!(n % 3)) {
            return 'Fizz';
        } else if (!(n % 5)) {
            return 'Buzz';
        } else {
            return String(n);
        }
    };
    // and then use that variable as the callback function
    console.table( fizzArr.map(fizzFunction) );

}

function printFind() {

    // Can find an index
    const indexOf10 = nums.findIndex( n => n == 10 );
    console.log("Index of 10: " + indexOf10);

    const indexOfLaptop = products.findIndex (product => product.name.toLowerCase() === 'laptop' );
    console.log("Index of laptop: " + indexOfLaptop);

    // Can find an object
    const milk = products.find( product => product.name.toLowerCase() === 'milk' );
    console.table(milk);
}


/*
    For our products, add $10 to the price of all items over 20 and then return 
    the sum of all of the new prices.
*/

// filter the items over 20 
// add 10 to each price in the filtered list
// reduce the mapped list with the new price to a total sum

const totalOfItems = products.filter( p => p.price > 20 )
    .map( p => { 
        p.price += 10;  
        return p;
    }).reduce( (totalCost, p) => {
        return totalCost + p.price;
    },0);

console.table(totalOfItems);