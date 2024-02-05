package com.techelevator.exceptions;

import java.util.Scanner;


public class ExceptionsLecture {

    private final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Input a whole number >>> ");
        String userSelection = input.nextLine();

        try {
            int number = Integer.parseInt(userSelection);
            System.out.println("Your number was " + number);
        } catch (NumberFormatException e) {
            System.out.println("You did not enter a number, please try again");
        }

        System.out.println("This line is after the try catch");
    }

}
