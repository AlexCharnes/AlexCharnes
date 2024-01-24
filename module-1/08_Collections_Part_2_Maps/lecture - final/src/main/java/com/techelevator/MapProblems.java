package com.techelevator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapProblems {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("####################");
        System.out.println("     Problem 1     ");
        System.out.println("####################");
        System.out.println();

        /*
			Create a map from the following data of product codes and names.  The map should store the values
			in alphabetic order by the product code.  Use the map to print a menu of the product codes to the console.

			A1: Candy Bar
			A2: Nut Bar
			A3: Bag of Chocolates
			B1: Potato Chips
			B2: Pretzels
			B3: Nutter Butters
			C1: Cat Treats
			C2: Dog Treats
			C3: Squirrel Treats
		 */



        System.out.println();
        System.out.println("####################");
        System.out.println("     Problem 2     ");
        System.out.println("####################");
        System.out.println();
		/*
			Given the following Map which is users and their account balances in dollars,
			transfer $50 the funds from Bob's account to Anya's account

			Print the new value of Anya's account to the screen.
		 */
        Map<String, Double> accounts = new HashMap<String, Double>();
        accounts.put("Anya", 100d);
        accounts.put("Bob", 200d);



        System.out.println();
        System.out.println("####################");
        System.out.println("     Problem 3    ");
        System.out.println("####################");
        System.out.println();
		/*
			Given the following List count how many times each name appears in the list
		 */
        List<String> names = Arrays.asList(new String[]{"Rachelle", "John", "Rachelle", "Steve", "Dan", "Matt", "John", "Matt", "Rachelle", "Steve", "John", "Rachelle", "Rachelle" });



        System.out.println();
        System.out.println("####################");
        System.out.println("     Problem 4     ");
        System.out.println("####################");
        System.out.println();
		/*
			Given the following map that tracks grades for students, where the key is the student id
			and the value is their average grade, determines which student id has the highest and lowest score.
		 */
        Map<Integer, Integer> studentGradesByIds = new HashMap<Integer, Integer>();
        studentGradesByIds.put(10, 82);
        studentGradesByIds.put(11, 61);
        studentGradesByIds.put(12, 97);
        studentGradesByIds.put(13, 48);
        studentGradesByIds.put(14, 88);




        System.out.println();
        System.out.println("####################");
        System.out.println("     Problem 5     ");
        System.out.println("####################");
        System.out.println();
		/*
			Given the following map.  Replace all the null values with the word "default"
		 */
        Map<Integer, String> myMap = new HashMap<Integer, String>();

        myMap.put(1, "abc");
        myMap.put(2, null);
        myMap.put(3, null);
        myMap.put(4, "def");
        myMap.put(5, "null");
        myMap.put(6, null);
        myMap.put(7, "ghi");
        myMap.put(8, "jkl");

    }
}
