package com.techelevator;

public class LoopsAndArrays {

    public static void main(String[] args) {

        /* ******************************
                ARRAYS
         ****************************** */


        /*
            new creates an array of the size specified in the []
         */
        String[] staff = new String[5];

        /*
            access individual elements in the array using the index, they
            do not have to accessed in any specific order
         */
        staff[0] = "John";
        staff[2] = "Steve";
        staff[1] = "Rachelle";
        staff[3] = "Kevin";
        staff[4] = "Laura";

        System.out.println( staff[3] );

        String sayHello = "Hello, " + staff[0];
        System.out.println(sayHello);

        // The index of the first element will always be 0
        System.out.println("This is the first element: " + staff[0] );

        // The index of the last element will always be the length of the array - 1
        // array.length will return the length of the array
        System.out.println("This is the the last element: " + staff[ staff.length - 1 ] );

        staff[0] = "THE John Fulton";

        /*
            If an index is used that is not in the array it will result in
            an ArrayIndexOutOfBounds Exception (an exception is an error in your code)
         */
        //staff[5] = "";

        /*
            You can not resize an array, if you need more elements you would need
            to create a new array of a larger size and then copy the elements from the
            original array into it.
         */

        String[] staff2 = new String[6];
        staff2[0] = staff[0];
        staff2[1] = staff[1];


        String[] staffStaticInitialized = new String[]{ "John", "Rachelle", "Steve", "Kevin", "Laura"};

        /*
            Arrays can hold any data type, but only 1.
         */
        int[] numbers = new int[] { 10, 20, 30, 40, 50 };


        /* ******************************
                LOOPS
         ****************************** */
        /*
                i = i + 1
                i += 1
                i++
         */

        /*
            The for loop has 3 parts in its condition
            declares the incrementer ; boolean condition ; change to the incrementer

            The incrementer is just a variable usually and int that is a counter
            boolean condition - the block of code runs while the condition is true and the loops ends when it is false
            change to incrementer - makes a change so eventually the boolean condition will become false to end the loop
         */
        for (int i = 0; i < 5; i++ ) {
            System.out.println( i );
        }

        System.out.println("This code is after the for loop");

        // count backwards from 50 to 20
        for (int i = 50; i >= 20; i--) {
            System.out.println( i );
        }

        // Print every 3rd number between 0 and 100
        for (int i = 0; i <= 100; i += 3) {
            System.out.println(i);
        }

        // the incrementer and the change are optional
        int sum = 0;
        for ( ; sum < 100 ; ) {
            sum += 10;
        }


        /*
            Loops with Arrays
         */
        for (int i = 0; i < staff.length ; i++ ) {
            System.out.println( staff[ i ] );
        }

//        0
//        1
//        2
//        3
//        4

        for (int i = 0; i < staff.length; i+=2) {
            System.out.println( staff[i] );
        }

        for (int i = 0; i < staff.length; i++) {
            System.out.println( staff[i] );
            i++;
        }

        int j = 0;
        for (; j < staff.length; j++) {
            System.out.println( staff[j] );
            j++;
        }

        for (int i = 0; i < staff.length; i++) {
            if (i % 2 == 0) {
                System.out.println( staff[i] );
            }
        }

        // Sum all the numbers in the array numbers
        int sumOfNumbers = 0;
        for (int i = 0; i < numbers.length; i++) {
            sumOfNumbers = sumOfNumbers + numbers[i];
        }
        System.out.println(sumOfNumbers);


        /*
            continue tells the loop to go to the next iteration without finishing the block
            break immediately ends the loop
         */
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;
            }
            if (i == 8) {
                break;
            }
            System.out.println(i);
        }
    }

}
