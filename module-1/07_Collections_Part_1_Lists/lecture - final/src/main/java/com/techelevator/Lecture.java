package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Lecture {

	public static void main(String[] args) {


		System.out.println("####################");
		System.out.println("       BigDecimal");
		System.out.println("####################");

		BigDecimal numberOne = new BigDecimal(100);
		BigDecimal numberTwo = BigDecimal.TEN;

		BigDecimal numbersMultiplied = numberOne.multiply( numberTwo );

		/*
			CompareTo()
			returns 1 if the number is greater than the number in the compareTo()
			returns 0 if the numbers are the same
			returns -1 if the number is less than the number in the compareTo()
		 */
		System.out.println("100 compared to 10 is " + numberOne.compareTo(numberTwo) );
		System.out.println("100 compared to 100 is " + numberOne.compareTo(numberOne) );
		System.out.println("10 compared to 100 is " + numberTwo.compareTo(numberOne) );

		BigDecimal resultOf10DividedBy3 = numberTwo.divide( new BigDecimal(3), 4, RoundingMode.FLOOR);

		System.out.println("####################");
		System.out.println("       LocalDate");
		System.out.println("####################");

		// Today's Date
		LocalDate today = LocalDate.now();

		// Tomorrow's Date
		LocalDate tomorrow = today.plusDays(1);

		// Specific Date
		LocalDate april132010 = LocalDate.of(2010, 4, 13);

		// Specific Date parsed from String
		LocalDate halloween1980 = LocalDate.parse("1980-10-31");

		// Create a formatter to change the format of the date
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		// Can use the formatter to print a local date
		System.out.println( dateFormatter.format(halloween1980) );

		// Can use the formatter to parse a date from a string in that format
		LocalDate leapDay = LocalDate.parse("02/29/2024", dateFormatter);

		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		/*
		List  - interface, which is a data type that cannot be instantiated, but is a contract for what will be
		<String> - generic, which is a reference type that indicates what type of object the list will hold
		ArrayList - implementation class, which is a data type that fulfills the interface and can be instantiated into an object
		 */
		List<String> staff = new ArrayList<String>();

		// Can use the add() method to put in values
		staff.add("John");
		staff.add("Steve");
		staff.add("Kevin");
		staff.add("Laura");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		/*
			Collections use size() to return how many elements it has
		 */
		for (int i = 0; i < staff.size(); i++) {
			// .get(index) retrieves the value at the specified index
			System.out.println( staff.get(i) );
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		staff.add("John");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		// add(index, value) can be used to insert a value at a specific index
		staff.add(3, "Rachelle");


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		/*
			remove(index) removes the element at that index
			For Strings you can also use the value to remove
		 */
		staff.remove(5);
		staff.remove("Steve");

		List<String> strs = new ArrayList<String>();
		strs.add("A");
		strs.add("B");
		strs.add("A");
		strs.add("C");
		strs.add("A");

		// If multiple of the same value remove will only remove the first one
		strs.remove("A");


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		System.out.println( "Is Laura in the list: " + staff.contains("Laura") );

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println("The index of Rachelle is: " + staff.indexOf("Rachelle") );

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] staffAsArray = staff.toArray( new String[ staff.size() ] );

		staff.add("Steve");

		System.out.println("####################");
		System.out.println("Arrays can be converted to a List");
		System.out.println("####################");

		String[] animalNamesArray = new String[] {"horse", "dog", "cat", "penguin"};
		List<String> animalNamesAsList = Arrays.asList(animalNamesArray);


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(staff);
		Collections.sort(strs);

		System.out.println("####################");
		System.out.println("Lists can be shuffled");
		System.out.println("####################");

		Collections.shuffle(staff);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(staff);

		System.out.println("####################");
		System.out.println("       AUTOBOXING");
		System.out.println("####################");

		// Only reference can be used with Collections so wrapper classes must be used
		List<Integer> numbers = new ArrayList<Integer>();

		int x = 10;
		Integer y = 20;
		x = y;


		Integer one = 10;
		Integer two = 10;
		System.out.println( one == two );

		if ( one > 5) {
			System.out.println("10 is greater than 5");
		}

		numbers.add(10);
		numbers.add(20);
		numbers.add(30);

		Double accountBalance = null;
		//double newBalance = accountBalance + 100;

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for (String nameOfStaff : staff) {
			System.out.println( nameOfStaff );
		}

		int[] nums = {10,20,30,40,50};

		int sumOfNumbers = 0;
		for (int currentNumber : nums) {
			sumOfNumbers += currentNumber;
		}
		System.out.println(sumOfNumbers);


	}
}
