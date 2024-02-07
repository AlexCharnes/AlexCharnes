package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() {
		/* Your code goes here */
		String fileName = userInput.nextLine();

		try (PrintWriter w = new PrintWriter(new File(fileName))) {
			for (int i = 1; i<= 300; i++) {
				if (i % 15 == 0) {
					w.println("FizzBuzz");
				} else if (i % 3 == 0) {
					w.println("Fizz");
				} else if (i % 5 == 0) {
					w.println("Buzz");
				} else {
					w.println(i);
				}
			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}


	}

}
