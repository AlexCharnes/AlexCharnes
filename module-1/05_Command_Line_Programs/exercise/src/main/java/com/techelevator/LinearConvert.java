package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		double distanceInFeet = 0;
		double distanceInMeters = 0;

		Scanner userInput = new Scanner(System.in);
		String[] conversion = new String[2]{};

		System.out.println("Please enter the length: ");
		String length = userInput.nextLine();

		System.out.println("Is the measurement in (m)eters, or (f)eet?");
		String type = userInput.nextLine();

		double lengthNumber = Double.parseDouble(length);

		if (type == "m"){
			distanceInFeet = lengthNumber * 0.3048;
			conversion[] = length + " is " + distanceInFeet
			System.out.println(conversion[]);
		} else if (type == "f"){
			distanceInMeters = lengthNumber * 3.2808399;
			System.out.println(distanceInMeters);
		}




	}

}
