package com.techelevator;

import java.util.Scanner;

public class TempConvert {


	public static void main(String[] args) {
//		double tempInF = 0;
//		double tempInC = 0;

		Scanner userInput = new Scanner(System.in);

		System.out.println("Please enter the temperature: ");
		String tempDegree = userInput.nextLine();

		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit?");
		String tempType = userInput.nextLine();
		double tempDegreeNumber = Double.parseDouble(tempDegree);
		double degreesInF = tempDegreeNumber * 1.8 + 32;
		double degreesInC = (tempDegreeNumber - 32) / 1.8;


		if (tempType.equalsIgnoreCase("c")){
			System.out.printf("%1.0f C is %1.0f F", tempDegreeNumber, degreesInF);
		} else if (tempType.equalsIgnoreCase("f")){
			System.out.printf("%1.0f F is %1.0f C", tempDegreeNumber, degreesInC);
		}


	}

}
