package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		double distanceInFeet = 0;
		double distanceInMeters = 0;

		Scanner userInput = new Scanner(System.in);
		String[] conversion = new String[args.length];

		System.out.println("Please enter the length: ");
		String length = userInput.nextLine();

		System.out.println("Is the measurement in (m)eters, or (f)eet?");
		String type = userInput.nextLine();

		double lengthNumber = Double.parseDouble(length);

		if (type.equalsIgnoreCase("m")){
			distanceInFeet = lengthNumber * 3.2808399;

			System.out.printf("%1.0f is %1.0f", lengthNumber, distanceInFeet);
		} else if (type.equalsIgnoreCase("f")){
			distanceInMeters = lengthNumber * 0.3048;
			System.out.printf("%1.0f is %1.0f", lengthNumber, distanceInMeters);
		}




	}

}
