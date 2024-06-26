package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises = 26;
		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/

		// declare the variable
		double half;

		// assign the value
		half = 0.5;

		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "TechElevator";
		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;
		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println(myFavoriteLanguage);


		char theLetterT = 'T';
		System.out.println(theLetterT);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		double pi = 3.14159;
		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String myName = "your name";

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numberOfButtonsOnMyMouse = 3;

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		int percentageOfPhoneBatteryRemaining;

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int difference = 121 - 27;
		System.out.println(difference);

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double numberOne = 12.3;
		double sumOfNumbers = numberOne + 32.1;
		System.out.println(sumOfNumbers);

		/*
		12. Create a String that holds your full name.
		*/
		String yourFullName = "Rachelle Rauh";

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String hello = "Hello, ";

		String helloYourFullName = hello + yourFullName;
		System.out.println(helloYourFullName);

		/*
		14. Add " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		helloYourFullName = helloYourFullName + " Esquire";
		System.out.println(helloYourFullName);

		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		helloYourFullName += " Esquire";
		System.out.println(helloYourFullName);

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String saw = "Saw" + 2;
//		saw += 2;
		System.out.println(saw);

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		saw += 0;
		System.out.println(saw);

		/*
		18. What is 4.4 divided by 2.2?
		*/
		System.out.println( 4.4 / 2.2 );

		/*
		19. What is 5.4 divided by 2?
		*/

		System.out.println(5.4 / 2);

		/*
		20. What is 5 divided by 2?
		*/

		System.out.println( 5 / 2 );

		/*
		21. What is 5.0 divided by 2?
		*/
		System.out.println( 5.0 / 2 );

		System.out.println( 5 / 2d );


		int firstNumber = 5;
		int secondNumber = 2;

		double answer = (double) firstNumber / secondNumber;

		System.out.println(answer);


		long x = 10;
		int y = (int) x;

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		System.out.println( 66.6 / 100 );
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		int remainder = 5 % 2;
		System.out.println(remainder);

		/*
		24. What is 1,000,000,000 * 3?
		*/
		long result24 = 1000000000 * 3;
		System.out.println(result24);


		/*
		25. Create a variable that holds a boolean called isDoneWithExercises and
		set it to false.
		*/
		boolean isDoneWithExercises = false;
		System.out.println(isDoneWithExercises);

		/*
		26. Now set isDoneWithExercise to true.
		*/
		isDoneWithExercises = true;
		
	}

}
