package com.techelevator;

import java.util.*;

public class Lecture_Map {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();









		System.out.println();
		System.out.println("####################");
		System.out.println("      MAP ORDER     ");
		System.out.println("####################");
		System.out.println();

		System.out.println("The values where inserted in the following order: 2, 10, 25, 1");


		// HashMap does not retain order
		System.out.println();
		System.out.println("  HASHMAP");
		System.out.println("Does not retain any order.  Instead it uses it's own internal ordering");

		Map<Integer, String> hashMapNumbersToWords = new HashMap<Integer, String>();

		hashMapNumbersToWords.put(2, "Two");
		hashMapNumbersToWords.put(10, "Ten");
		hashMapNumbersToWords.put(25, "Twenty-Five");
		hashMapNumbersToWords.put(1, "One");

		for (Integer number : hashMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + hashMapNumbersToWords.get(number));
		}


		System.out.println();
		System.out.println("  LINKED HASHMAP");
		System.out.println("Retains the Order of Insertion");

		Map<Integer, String> linkedHashMapNumbersToWords = new LinkedHashMap<Integer, String>();

		linkedHashMapNumbersToWords.put(2, "Two");
		linkedHashMapNumbersToWords.put(10, "Ten");
		linkedHashMapNumbersToWords.put(25, "Twenty-Five");
		linkedHashMapNumbersToWords.put(1, "One");

		for (Integer number : linkedHashMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + linkedHashMapNumbersToWords.get(number));
		}


		System.out.println();
		System.out.println("  TREEMAP");
		System.out.println("Retains the Natural Order of the Data Type");
		System.out.println();
		System.out.println("Natural Order when numbers are Integer");

		Map<Integer, String> treeMapNumbersToWords = new TreeMap<Integer, String>();

		treeMapNumbersToWords.put(2, "Two");
		treeMapNumbersToWords.put(10, "Ten");
		treeMapNumbersToWords.put(25, "Twenty-Five");
		treeMapNumbersToWords.put(1, "One");

		for (Integer number : treeMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + treeMapNumbersToWords.get(number));
		}


		System.out.println();
		System.out.println("TreeMap Natural Order when numbers are String");

		Map<String, String> treeMapNumbersAsStrings = new TreeMap<String, String>();

		treeMapNumbersAsStrings.put("2", "Two");
		treeMapNumbersAsStrings.put("10", "Ten");
		treeMapNumbersAsStrings.put("25", "Twenty-Five");
		treeMapNumbersAsStrings.put("1", "One");

		for (String number : treeMapNumbersAsStrings.keySet()) {
			System.out.println(number + " is " + treeMapNumbersAsStrings.get(number));

		}






	}


}
