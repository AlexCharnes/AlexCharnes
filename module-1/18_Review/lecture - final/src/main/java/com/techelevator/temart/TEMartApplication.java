package com.techelevator.temart;


import com.techelevator.temart.inventory.FileInventory;
import com.techelevator.temart.inventory.Inventory;
import com.techelevator.temart.inventory.MemoryInventory;
import com.techelevator.temart.inventory.Product;
import com.techelevator.temart.view.Menu;

import java.io.FileNotFoundException;
import java.util.Map;

public class TEMartApplication {

    private Menu menu;

    public static void main(String[] args) {
        Menu menu = new Menu();
        TEMartApplication app = new TEMartApplication(menu);
        app.run();
    }

    public TEMartApplication(Menu menu) {
        this.menu = menu;
    }

    public void run() {

   //     Inventory inventory = new MemoryInventory();
        Inventory inventory = null;
        try {
            inventory = new FileInventory("inventory.csv");
        } catch (FileNotFoundException e) {
           menu.tellUserFileNotFound();
           return;
        }

        menu.showWelcomeScreen();

        Map<String, Product> products = inventory.getProducts();

        String selectedSku = menu.showProducts(products);

        Product selectedProduct = inventory.getProductBySku(selectedSku);

        menu.showOneProduct( selectedProduct );
    }

}
