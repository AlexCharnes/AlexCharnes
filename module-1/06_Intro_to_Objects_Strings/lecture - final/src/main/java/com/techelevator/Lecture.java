package com.techelevator;

public class Lecture {
	static String nullString;
	public static void main(String[] args) {

		int x = 120;
		boolean isReading = false;
		int y = x;
		x = 35;

		int[] intArr = new int[] {1,2,3};
		int[] arr2 = intArr;
		intArr[1] = 100;
		arr2[2] = 555;

		int[] anotherIntArry = new int[]{1,100,555};



		System.out.println("************************************");
		System.out.println("******    CREATING OBJECTS    ******");
		System.out.println("************************************");

		Cake vanillaCake = new Cake("vanilla", true);
		Cake chocolateCake = new Cake("chocolate", false);
		Cake strawberryCake = new Cake("strawberry", false);

		chocolateCake.setHasSprinkles(true);

		Cake vanillaCake2 = vanillaCake;
		vanillaCake.setIcingType("Blueberry");

		// This will cause a nullPointerException
//		Cake nullCake = null;
//		nullCake.getIcingType();


		/*
		nullString is null so this will cause a nullPointerException because
		the variable (at the top of the class) has been declared but not instantiated
		 */
		//nullString.equalsIgnoreCase("test");

		/*
			Once an instantiated object has been assigned to the variable then it will
			no longer cause a nullPointerException, even if the object is empty because
			empty means the object exists just has no value.
		 */
		nullString = "";
		nullString.equalsIgnoreCase("test");


		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes).  This
		 * is not the case for most classes */

		/* create a new instance of String using a literal */
		String name = "Tech Elevator";
		// String name = new String("Tech Elevator");

		String newString = name + " ABC";

		char[] charArray = new char[]{'A','w','e','s','o','m','e'};
		String awesomeString = new String(charArray);
		System.out.println(awesomeString);

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
		String hello1 = new String(helloArray);
		String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}


		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		// name = "Tech Elevator" - declared above

		char characterAt3 = name.charAt(3);

		for (int i = 0; i < name.length(); i++) {
			System.out.println( name.charAt(i) );
		}

		// Substring takes the starting index (inclusive) and the ending index (exclusive) and returns
		// those letters as a new String
		String substringed = name.substring(0,4);

		// Given only a starting index it will return the end of the string starting with the character
		// at that index.
		String endOfString = name.substring(5);

		boolean doesContainVa = name.contains("va");
		boolean doesStartWithTech = name.startsWith("Tech");
		boolean doesStartWithtech = name.startsWith("tech");
		boolean doesEndWithVator = name.endsWith("vator");


		int indexOfE = name.indexOf("E");
		// If the string in the parameter does not exist in the string on which is method is called then -1 will be returned
		int indexOfX = name.indexOf("X");

		String techStairs = name.replace("Elevator", "Stairs");

		String stringWithSpacingIssues = "         test        ";
		String stringWithoutSpacingIssues = stringWithSpacingIssues.trim();


		String numberString = String.valueOf(10);

		String[] countDown = new String[] { "5", "4", "3", "2", "one!!"};
		String joinedString = String.join(" --> ", countDown);

		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

	}
}
