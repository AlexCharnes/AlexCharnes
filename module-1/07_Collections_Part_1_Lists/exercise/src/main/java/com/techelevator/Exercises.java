package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercises {

	/*
	 Note, for-each is preferred, and should be used when possible.
	 */

    /*
     Given an array of Strings, return an ArrayList containing the same Strings in the same order
     array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
     array2List( {"Red", "Orange", "Yellow"} )  ->  ["Red", "Orange", "Yellow"]
     array2List( {"Left", "Right", "Forward", "Back"} )  ->  ["Left", "Right", "Forward", "Back"]
     */
    public List<String> array2List(String[] stringArray) {
		List<String> arrayAsList = Arrays.asList(stringArray);
        return arrayAsList;
    }

    /*
     Given a list of Strings, return an array containing the same Strings in the same order
     list2Array( ["Apple", "Orange", "Banana"] )  ->  {"Apple", "Orange", "Banana"}
     list2Array( ["Red", "Orange", "Yellow"] )  ->  {"Red", "Orange", "Yellow"}
     list2Array( ["Left", "Right", "Forward", "Back"] )  ->  {"Left", "Right", "Forward", "Back"}
     */
    public String[] list2Array(List<String> stringList) {
		String[] listAsArray = stringList.toArray( new String[ stringList.size() ] );
        return listAsArray;
    }

    /*
     Given an array of Strings, return an ArrayList containing the same Strings in the same order
     except for any words that contain exactly 4 characters.
     no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
     no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
     no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
     */
    public List<String> no4LetterWords(String[] stringArray) {
		List<String> newArray = new ArrayList<>();
		String four = new String();
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length() > 4 || stringArray[i].length() < 4) {
                newArray.add(stringArray[i]);
            }

        }
        return newArray;
    }

    /*
     Given an array of ints, divide each int by 2, and return an ArrayList of Doubles.
     arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100, 48.5]
     arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22, 4508.5, 3]
     arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5, 1642.5, 6.5, 438.5]
     */
    public List<Double> arrayInt2ListDouble(int[] intArray) {
        List<Double> half = new ArrayList<Double>();
        for (int currentInt : intArray){
            double newValue = currentInt / 2.0;
            half.add(newValue);
        }

        return half;
    }

    /*
     Given a List of Integers, return the largest value.
     findLargest( [11, 200, 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333
     findLargest( [987, 1234, 9381, 731, 43718, 8932] ) -> 43718
     findLargest( [-2, -6, -8] ) -> -2
     */
    public Integer findLargest(List<Integer> integerList) {

        int largestInt = -100;

        for (int currentInt : integerList){

            if (currentInt > largestInt){
                largestInt = currentInt;
            }
            }
        return largestInt;
        }






    /*
     Given an array of Integers, return a List of Integers containing just the odd values.
     oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83]
     oddOnly( {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643]
     oddOnly( {734, 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
     */
    public List<Integer> oddOnly(Integer[] integerArray) {
        List<Integer> oddInt = new ArrayList<>();
        for (int currentInt : integerArray){
            if (currentInt % 2 == 1 || currentInt % 2 == -1){
                oddInt.add(currentInt);
            }
        }
        return oddInt;
    }

    /*
     Given a List of Integers, and an int value, return true if the int value appears two or more times in
     the list.
     foundIntTwice( [5, 7, 9, 5, 11], 5 ) -> true
     foundIntTwice( [6, 8, 10, 11, 13], 8 -> false
     foundIntTwice( [9, 9, 44, 2, 88, 9], 9) -> true
     */
    public boolean foundIntTwice(List<Integer> integerList, int intToFind) {

        // 1. create boolean variable - true when there is two or more
        // 2. create a count variable - count how many times intToFind appears on the list
        // 3. loop over integer list.
        // 4. if intToFind is found in list +1 to counter
        // 5. check if counter is 2 if it is break the loop
        // 6. set boolean to true if counter is 2
        // 7. return boolean

        boolean isFoundTwice = false;
        int counter = 0;

        for (int currentNumber : integerList) {
            if (currentNumber == intToFind) {
                counter += 1;
            }
            if (counter == 2) {
                break;
            }
        }
        if (counter >= 2) {
            isFoundTwice = true;
        }
        return isFoundTwice;
    }

    /*
     Given an array of Integers, return a List that contains the same Integers (as Strings). Except any multiple of 3
    must be replaced by the String "Fizz", any multiple of 5 must be replaced by the String "Buzz",
    and any multiple of both 3 and 5 must be replaced by the String "FizzBuzz."
    ** INTERVIEW QUESTION **

    fizzBuzzList( {1, 2, 3} )  ->  ["1", "2", "Fizz"]
    fizzBuzzList( {4, 5, 6} )  ->  ["4", "Buzz", "Fizz"]
    fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} )  ->  ["7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]

    HINT: To convert an Integer x to a String, you can use x.toString() in your code. For example, if x = 1, then x.toString() returns "1."
     */
    public List<String> fizzBuzzList(Integer[] integerArray) {
        List<String> fizzBuzz = new ArrayList<>();

        for (int currentInt : integerArray){
            if (currentInt % 3 == 0 && currentInt % 5 ==0){
                fizzBuzz.add("FizzBuzz");
                //fizzBuzz.remove(currentInt);
            }
            else if (currentInt % 5 == 0){
                fizzBuzz.add("Buzz");
                //fizzBuzz.remove(currentInt);

            }
            else if (currentInt % 3 == 0){
            fizzBuzz.add("Fizz");
                //fizzBuzz.remove(currentInt);
            }
            else {
                String intToString = Integer.toString(currentInt);
                fizzBuzz.add(intToString);
            }
        }
        return fizzBuzz;
    }

    /*
     Given two lists of Integers, interleave them beginning with the first element in the first list followed
     by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
     Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
     list to the new list before returning it.
     interleaveLists( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
     interleaveLists( [7, 1, 3], [2, 5, 7, 9] )  ->  [7, 2, 1, 5, 3, 7, 9]
     interleaveLists( [1, 2, 5, 8, 10], [4, 5, 6] )  ->  [1, 4, 2, 5, 5, 6, 8, 10]
     */
    public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {

        List<Integer> interWoven = new ArrayList<>();
        int lengthListOne = listOne.size();
        int lengthListTwo = listTwo.size();


        int longestLength;
        if ( lengthListOne > lengthListTwo){
            longestLength = lengthListOne;
        }else {
            longestLength = lengthListTwo;
        }

        for ( int i = 0; i < longestLength; i++){
            if ( i < lengthListOne){
                interWoven.add(listOne.get(i));
            }
            if ( i < lengthListTwo){
                interWoven.add(listTwo.get(i));
            }


        }
        return interWoven;
    }

}
