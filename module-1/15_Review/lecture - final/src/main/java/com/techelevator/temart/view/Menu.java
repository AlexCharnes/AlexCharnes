package com.techelevator.temart.view;

import com.techelevator.temart.inventory.Product;

import java.util.Map;
import java.util.Scanner;

public class Menu {

    private static final Scanner in = new Scanner(System.in);

    public void showWelcomeScreen() {
        System.out.println("**************************");
        System.out.println(" Welcome to TE Mart ");
        System.out.println("**************************");
        System.out.println();
    }

    public String showProducts(Map<String, Product> products) {

        for (Map.Entry<String, Product> entry : products.entrySet()) {
            Product currentProduct = entry.getValue();

            System.out.print(currentProduct.getSku());
            System.out.print(" ) ");
            System.out.print(currentProduct.getName());
            System.out.printf("  $%1.2f %n", currentProduct.getPrice());

        }
        System.out.print("Select a Sku >>> ");
        String selectedSku = in.nextLine();
        return selectedSku;
    }

    public void showOneProduct(Product product) {

        System.out.println();
        System.out.println("You selected:");
        System.out.print(product.getSku());
        System.out.println(" ) " + product.getName());
        System.out.println("Description: " + product.getDescription());
        System.out.println("Price: $" + product.getPrice());
        System.out.println("Shipping Cost: $" + product.getShippingCost());
        System.out.println("Total Cost: $" + product.getTotalCostWithShipping());

    }
}
