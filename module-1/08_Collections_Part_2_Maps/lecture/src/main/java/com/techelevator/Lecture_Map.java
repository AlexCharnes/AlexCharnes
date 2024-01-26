package com.techelevator;

import java.util.*;

public class Lecture_Map {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<String, String> animalNoises = new HashMap<String, String>();

		//adding key/value to a map
		//put(key, value) - key must be unique and the value can duplicate

		animalNoises.put("Cow", "Moo");
		animalNoises.put("Chicken", "Cluck");
		animalNoises.put("Dog", "Bark");
		animalNoises.put("Cat", "Meow");
		animalNoises.put("Lion", "roar");
		animalNoises.put("Duck", "roar");


		//Updating a value in a map
		//put(existing key, new value) - use an existing and put will update its calue to the new given value

		animalNoises.put("Duck", "Quack");

		//Retrieve a value from the map using the key
		// get(key) - returns the value


		String noise = animalNoises.get("Cat");

		//The key used with get() does not exit in the map it will return null

		String wolfNoise = animalNoises.get("wolf");

		animalNoises.get("Dog");

		//Remove a key/value
		//remove(key) - deletes the key and value from the map
		//remove() will return the value for the key being removed as well as delete it

		String lionNoise = animalNoises.remove("Lion");

		//if the key does not exist then remove)_ will return null

		lionNoise = animalNoises.remove("lion");

		//Can check if the key or a value exists using
		//containsKey(key) - return true is the key exists
		//containsvalue(value) returns true if the value exists

		boolean doesCatExist = animalNoises.containsKey("Cat");
		boolean doesFoxExist = animalNoises.containsKey("Fox");
		boolean doesAnimalBark = animalNoises.containsValue("Bark");
		boolean doesAnAnimalStillRoar = animalNoises.containsValue("Roar");


		//Can get a Set<T> of the keys using keySet()

		Set<String> keys = animalNoises.keySet();

		for (String animal : keys){
			System.out.println(animal);
		}
		//Can get a Set of Entry<T, T> using entrySet()
		//An Entry contains a key and that keys value

		Set<Map.Entry<String, String>> entries = animalNoises.entrySet();

		//In the for each loop we could use the entries variable to loop over the entrySet
		//However, you can just call entrySet() in the for loop to access it without needing
		// to store it in your own variable

		for (Map.Entry<String, String> currentEntry : animalNoises.entrySet()){
			String animal = currentEntry.getKey();
			String noiseItMakes = currentEntry.getValue();
			System.out.println(animal + "says" + noiseItMakes);
		}




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
