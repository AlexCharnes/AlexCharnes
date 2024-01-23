package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        //int binary = 0;


        System.out.println("Please enter in a series of decimal values (separated by spaces):");
        String[] numbersInputted = userInput.nextLine().split(" ");

        String totalBinary = "";

        for (int i = 0; i < numbersInputted.length; i++) {

            int intInputted = Integer.parseInt(numbersInputted[i]);

            while (intInputted > 0) {

                if (intInputted % 2 == 1) {
                    int binaryDigit = 1;
                    totalBinary = binaryDigit + totalBinary;
                    //intInputted = intInputted / 2;

                }
                if (intInputted % 2 == 0) {
                    int binaryDigit = 0;
                    totalBinary = binaryDigit + totalBinary;
                }
                intInputted = intInputted / 2;
            }
            System.out.println(numbersInputted[i] + " in binary is " + totalBinary);
            totalBinary = "";
        }
    }
}