package com.techelevator;

import java.util.Scanner;
public class CatPackingCalculator {
    private final static double AVG_VOLUME_OF_HOUSE_CAT = 0.083;
    private final static double PACKING_DENSITY_OF_HOUSE_CAT = 0.05;
    //VARIABLES IN SQFT.
    public static void main(String[] args) {
//
//        Scanner is a library that helps us manage a stream, like System.in
//        We need a variable of type scanner
//        use the new keyword to create a scanner
//        pass the stream, System.in, as the value of the parameter.
//
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the length of the container in feet? ");
        // the Scanner nextLine() method returns all the text typed by the user up until enter is pressed.
        String lengthOfContainer = userInput.nextLine();

        System.out.println("What is the width of the container in feet? ");
        String widthOfContainer = userInput.nextLine();

        System.out.println("What is the height of the container in feet?");
        String heightOfContainer = userInput.nextLine();

        double length = Double.parseDouble(lengthOfContainer);
        double width = Double.parseDouble(widthOfContainer);
        double height = Double.parseDouble(heightOfContainer);



        double containerVolume = length * width * height;
        double catsByVolume = containerVolume / AVG_VOLUME_OF_HOUSE_CAT;
        double packedCats = catsByVolume * PACKING_DENSITY_OF_HOUSE_CAT;

        System.out.printf("You can pack %1.0f Cats in a box", packedCats);



    }

}
