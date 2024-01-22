package com.techelevator;

import java.util.Scanner;

public class TemartApplication {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        String[] products = new String[4];

        products[0] = "Bacon,2.50";
        products[1] = "Steak,9.99";
        products[2] = "Lobster,23.99";
        products[3] = "Lettuce,4.00";

        System.out.println("****************************");
        System.out.println("    Welcome to TE Mart");
        System.out.println("****************************");

        double totalCost = 0;
        boolean isShopping = true;
        while (isShopping == true) {

            System.out.println();

            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ") " + products[i]);
            }
            System.out.print("Please select an item >>> ");
            String usersOrder = userInput.nextLine();

            int parsedUsersOrder = Integer.parseInt(usersOrder);
            int index = parsedUsersOrder - 1;

            String[] partsOfTheString = products[index].split(",");

            double price = Double.parseDouble(partsOfTheString[1]);
            totalCost += price;

            System.out.printf("You have selected %4s for $%1.2f %n", partsOfTheString[0], price);

            System.out.println("Select another Item (Y/N)?");
            String userChoice = userInput.nextLine();
            if (userChoice.equalsIgnoreCase("N")) {
                isShopping = false;
            }
        }

        System.out.printf("Your total cost is $%1.2f %n", totalCost);
        System.out.println("Thank you for shopping with us!");

    }
}
