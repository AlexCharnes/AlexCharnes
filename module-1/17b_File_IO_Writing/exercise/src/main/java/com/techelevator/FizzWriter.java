package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        FizzWriter fizzWriter = new FizzWriter();
        fizzWriter.run();
    }

    public void run() throws FileNotFoundException {

        /* Your code goes here */

        System.out.print("Output file: ");
        String outputFileName = userInput.nextLine();

        File outputFile = new File(outputFileName);

        try (PrintWriter fizzWriter = new PrintWriter(outputFile)) {

            for (int i = 1; i <= 300; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    fizzWriter.println("FizzBuzz");
                } else if (i % 5 == 0) {
                    fizzWriter.println("Buzz");
                } else if (i % 3 == 0) {
                    fizzWriter.println("Fizz");
                } else {
                    fizzWriter.println(i);
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("Output file not found: " + outputFileName);
        }

    }
}
