package com.techelevator;

public class Exercise01_StoreOrders {

    /*
    Sally's Pizza is bringing its pizza ordering system into the digital age
    to get better customer insights.

    They've encoded each of Sally's pizzas and other dishes as an integer:
	 * 10: small, cheese       20: medium, cheese       30: large, cheese
	 * 11: small, pepperoni    21: medium, pepperoni    31: large, pepperoni
	 * ---
	 * 40: calzone
	 * 41: spaghetti pie
	 * 42: baked ziti
     */

    // You can use these constants in your solutions.
    private final int SMALL_CHEESE = 10;
    private final int SMALL_PEPPERONI = 11;

    private final int MEDIUM_CHEESE = 20;
    private final int MEDIUM_PEPPERONI = 21;

    private final int LARGE_CHEESE = 30;
    private final int LARGE_PEPPERONI = 31;

    private final int CALZONE = 40;
    private final int SPAGHETTI_PIE = 41;
    private final int BAKED_ZITI = 42;

    /*
    Each customer order, consisting of one or more items, is represented as an array
    where each value represents an item in that order.

    Create an "order" that contains the following items:
	 * - small, cheese (SMALL_CHEESE)
	 * - calzone (CALZONE)
	 * - large, pepperoni (LARGE_PEPPERONI)
	 * - spaghetti pie (SPAGHETTI_PIE)

	 Examples:
	 createOrder() → [10, 40, 31, 41]
     */
    public int[] createOrder() {
        // 1. Create an array
        // 2. put in the values
        int[] order = new int[] { SMALL_CHEESE, CALZONE, LARGE_PEPPERONI, SPAGHETTI_PIE};
        // 3. return the array
        return order;
    }

    /*
    Sally realized that she needed to know how many calzones her shop sells per day.

    Implement the logic to count the number of calzones sold per day when given an
    array representing each item that her customers ordered that day.

    Examples:
    getCalzoneSales([CALZONE, LARGE_CHEESE, LARGE_PEPPERONI, CALZONE, SMALL_CHEESE]) → 2
    which is the same as:
    getCalzoneSales([40, 30, 31, 40, 10]) → 2

    getCalzoneSales([LARGE_CHEESE, LARGE_PEPPERONI, SMALL_CHEESE]) → 0
    getCalzoneSales([]) → 0
     */
    public int getCalzoneSales(int[] orders) {
        // 1. declare a variable to count the number of calzone
        // 2. loop over the order array
            // 2a. look for calzone
            // 2b. if find calzone add 1 to count
        // 3. return the number of calzones we found
        int count = 0;

        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == CALZONE) {
                count++;
            }
        }
        return count;
    }

    /*
    Sally also needs to know the total revenue for all cheese pizzas sold on any given day.
        * Each small cheese pizza costs $8.
        * Each medium cheese pizza costs $11.
        * Each large cheese pizza costs $14.

    Implement the logic to return the total revenue of all cheese pizzas when given
    an array representing each item that her customers ordered that day.

    Examples:
    getCheesePizzaRevenue([SMALL_CHEESE]) → 8
    getCheesePizzaRevenue([SMALL_CHEESE, SMALL_PEPPERONI, MEDIUM_CHEESE]) → 19
    getCheesePizzaRevenue([SMALL_PEPPERONI, MEDIUM_PEPPERONI]) → 0
     */
    public int getCheesePizzaRevenue(int[] orders) {
        // 1. create a variable to sum the revenue
        int revenueOfCheesePizzas = 0;
        // 2. Loop over orders
            // 2a. initialize the counter variable in for
            // 2b. check element at the index of i is a Small Cheese Pizza add 8 to revenue
            // 3b. check element at the index of i is a Medium Cheese Pizza add 11 to revenue
            // 4b. check element at the index of i is a Large Cheese Pizza add 14 to revenue
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == SMALL_CHEESE) {
                revenueOfCheesePizzas += 8;
            } else if (orders[i] == MEDIUM_CHEESE) {
                revenueOfCheesePizzas += 11;
            } else if (orders[i] == LARGE_CHEESE) {
                revenueOfCheesePizzas += 14;
            }
        }


        // 3. return the revenue
        return revenueOfCheesePizzas;
    }
}
