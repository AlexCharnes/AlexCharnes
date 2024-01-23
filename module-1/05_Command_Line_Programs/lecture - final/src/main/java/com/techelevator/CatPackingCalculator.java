package com.techelevator;

/*
an import allows us to work with other libraries in Java
 */
import java.util.Scanner;
public class CatPackingCalculator {

    private final static double AVG_VOLUME_OF_HOUSE_CAT = 0.083;
    private final static double PACKING_DENSITY_OF_HOUSE_CAT = 0.05;
    public static void main(String[] args) {

        /*
            Scanner is a library that helps us manage a stream, like System.in
            We need a variable of type Scanner
            use the new keyword to create a scanner
            pass the stream, System.in, as the value of the parameter
         */
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the length of the container in feet? ");
        /*
            the Scanner nextLine() method returns all the text typed by the user until Enter is pressed
         */
        String lengthOfContainer = userInput.nextLine();

        System.out.println("What is the width of the container in feet? ");
        String widthOfContainer = userInput.nextLine();

        System.out.println("What is the height of the container in feet? ");
        //String heightOfContainer = userInput.nextLine();
        /*
            Can also use nextInt(), nextDouble(), etc to get values already parsed into those data types,
            however, you must call nextLine() afterwards to clean-up the trailing end line character.
         */
        double height = userInput.nextDouble();
        userInput.nextLine();

        /*
            Each primitive data type has a wrapper class that has methods for that primitive and
            has a parse method that can convert a String to that data type, given string contains
            only characters that can be in that data type (example: a whole number if an int)
         */
        double length = Double.parseDouble(lengthOfContainer);
        double width = Double.parseDouble(widthOfContainer);
//        double height = Double.parseDouble(heightOfContainer);


        double containerVolume = length * width * height;
        double catsByVolume = containerVolume / AVG_VOLUME_OF_HOUSE_CAT;
        double packedCats = catsByVolume * PACKING_DENSITY_OF_HOUSE_CAT;

        System.out.printf("You can pack %1.0f cats in that box", packedCats);

    }

}
