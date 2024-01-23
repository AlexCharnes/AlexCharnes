package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		//int binary = 0;



		System.out.println("Please enter in a series of decimal values (separated by spaces):");
		String[] numbersInputted = userInput.nextLine().split(" ");



		//System.out.println(intInputted);
		for (int i = 0; i < numbersInputted.length; i++){
			double intInputted = Double.parseDouble(numbersInputted[i]);
			for (int y = 0; y < numbersInputted.length; y++)
				if (intInputted % 2 == 1) {
					intInputted = intInputted / 2;
					System.out.println(1);
					if (intInputted > 1){
						intInputted = intInputted / 2;
						System.out.println(intInputted % 2);



				}
//					if (intInputted % 2 == 0){
//						intInputted = intInputted / 2;
//						System.out.println(0);

			}
			//System.out.println(intInputted);
//			for (int y = 0; y < numbersInputted.length; i++ ){
//				if (intInputted / 2 >= 1 ){
//
//					intInputted = intInputted / 2;
//					intInputted = intInputted % 2;
//					}
//
//			}System.out.println(intInputted);
		}



	}

}