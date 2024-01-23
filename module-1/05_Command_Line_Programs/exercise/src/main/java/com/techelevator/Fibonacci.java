package com.techelevator;

import java.util.Scanner;

//need variable
//if you use an array it is the hardest way possible
public class Fibonacci {

	public static void main(String[] args) {


		int firstInteger = 0;
		int secondInteger = 1;
		int integerSum = firstInteger + secondInteger;

		Scanner userInput = new Scanner(System.in);

		System.out.println("Please enter a number: ");
		String numberInput = userInput.nextLine();
		double number = Double.parseDouble(numberInput);

		if (number > 1){
			System.out.println("0 \n1" );
			while(integerSum <= number){
				System.out.println(integerSum);
				firstInteger = secondInteger;
				secondInteger = integerSum;
				integerSum = firstInteger + secondInteger;
			}
			//System.out.println("%1.0f, %1.0f");

		} else if ( number == 1){
			System.out.println("0, 1, 1");
		} else {
			System.out.println("0, 1");
		}


	}

}
