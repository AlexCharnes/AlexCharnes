package com.techelevator;

import java.math.BigDecimal;
import java.sql.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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


		System.out.println("100 compared to 10 is " + numberOne.compareTo(numberTwo));
		// CompareTo()
		// returns 1 if the number is bigger then the number in the compareTo()
		// return 0 if the numbers are the same
		// return -1 if the number is less then the number in the compareTo()

		System.out.println("####################");
		System.out.println("       LocalDate");
		System.out.println("####################");

		// Todays Date
		LocalDate today = LocalDate.now();

		//Tomorrows Date
		LocalDate tomorrow = today.plusDays(1);

		//Specific Date

		LocalDate april132010 = LocalDate.of(2010, 4, 13);

		//Specific Cate parsed from String
		LocalDate halloween1980 = LocalDate.parse("1980-10-31");

		// Create a formatter to change format date
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		// Can use the date formatter to print a local date
		System.out.println(dateFormatter.format(halloween1980));

		// Can use the formatter to parse a date from a string in the format
		LocalDate leadDay = LocalDate.parse("02/29/24", dateFormatter);


		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		//List<T>
		//Just like arrays but we can add and remove elements as needed
		//List (interface is a data type that cannot be instantiated but is a contract for what will be)
		// <String> - generic, which is a reference type that indicates what type of object the list will hold
		// ArrayLst - implementation class which is a data type that fulfulls the interface and can be instantiated into an object
		List<String> staff = new ArrayList<String>();

		// can use the Add method to put in values
		staff.add("Jonny");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for ( int i = 0; i < staff.size() - 1; i++){
			System.out.println((staff.get(i)));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		// add(index, value) can be used to add a value at a specific index.
		staff.add(1, "Rachelle");

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		//remove index removes the element at that index
		// for Strings you can also use the value to remove

		staff.remove(1);
		List<String> strs = new ArrayList<String>();
		strs.add("A");
		strs.add("B");
		strs.add("C");
		strs.add("A");
		// if multiple of the same value exist then remove will only remove the first one
		// removeAll will remove all equivalent values
		strs.remove("A");

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		System.out.println("Is Laura in the list?" + strs.contains("Laura"));


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");
		// use listname.indexOf(value)

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");




		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(staff);


		System.out.println("####################");
		System.out.println("Lists can be shuffled");
		System.out.println("####################");

		Collections.shuffle(staff);


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(staff);

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();


		System.out.println("####################");
		System.out.println("       AUTOBOXING");
		System.out.println("####################");

	}
}
