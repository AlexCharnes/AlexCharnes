package com.techelevator;

import java.util.*;

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

        // 1. Create a new Map
        Map<String, String> treats = new TreeMap<String, String>();

        // 2. Assign the variables
        treats.put("A1", "Candy Bar");
        treats.put("A3", "Bag of Chocolates");
        treats.put("A2", "Nut Bar");
        treats.put("B1", "Potato Chips");
        treats.put("B2", "Pretzels");
        treats.put("B3", "Nutter Butters");
        treats.put("C1", "Cat Treats");
        treats.put("C2", "Dog Treats");
        treats.put("C3", "Squirrel Treats");

        //3. Display the codes and an items like a menu

        for(Map.Entry<String, String> treat : treats.entrySet()) {
            String code = treat.getKey();
            String name = treat.getValue();
            System.out.println(code + ") " + name);
        }


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

        double transferMoney = 50;
        double bobMoney = accounts.get("Bob");
        double anyaMoney = accounts.get("Anya");
        accounts.put("Bob", bobMoney - transferMoney);
        accounts.put("Anya", anyaMoney + transferMoney);
        System.out.println(accounts.get("Anya"));



        System.out.println();
        System.out.println("####################");
        System.out.println("     Problem 3    ");
        System.out.println("####################");
        System.out.println();
		/*
			Given the following List count how many times each name appears in the list
		 */
        List<String> names = Arrays.asList(new String[]{"Rachelle", "John", "Rachelle", "Steve", "Dan", "Matt", "John", "Matt", "Rachelle", "Steve", "John", "Rachelle", "Rachelle" });


        Map<String, Integer> nameCount = new HashMap<String, Integer>();
        for (String name : names){
            if (nameCount.containsKey(name)){
                nameCount.put(name, nameCount.get(name) + 1);


            } else {
                nameCount.put(name, 1);
            }

        }
        System.out.println(nameCount);



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

        int idWithHighestScore = - 1;
        int idWithLowestScore = -1;
        int currentHighScore = 0;
        int currentLowestScore = 100;


        for (Map.Entry<Integer, Integer> thisStudent : studentGradesByIds.entrySet()) {
            if(thisStudent.getValue() > currentHighScore ){
                currentHighScore = thisStudent.getValue();
                idWithHighestScore = thisStudent.getKey();

            }if(thisStudent.getValue()  < currentLowestScore ) {
                currentLowestScore = thisStudent.getValue();
                idWithLowestScore = thisStudent.getKey();
            }
        }
        System.out.println("The id With Lowest Score is :" + idWithLowestScore);
        System.out.println("The id With Higest Score is :" + idWithHighestScore);




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

        for (Map.Entry<Integer, String> currentEntry : myMap.entrySet()) {
            if(currentEntry.getValue() == null){
                myMap.put(currentEntry.getKey(),"default");
            }
        }


    }
}
