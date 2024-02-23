package com.techelevator.temart;


import com.techelevator.temart.dao.FileInventoryDao;
import com.techelevator.temart.dao.InventoryDao;
import com.techelevator.temart.dao.JdbcInventoryDao;
import com.techelevator.temart.dao.MemoryInventoryDao;
import com.techelevator.temart.inventory.Product;
import com.techelevator.temart.view.Menu;
import org.apache.commons.dbcp2.BasicDataSource;

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


        InventoryDao inventory = getTypeOfInventoryFromUser();

        menu.showWelcomeScreen();

        Map<String, Product> products = inventory.getProducts();

        String selectedSku = menu.showProducts(products);

        Product selectedProduct = inventory.getProductBySku(selectedSku);

        menu.showOneProduct( selectedProduct );
    }

    private InventoryDao getTypeOfInventoryFromUser() {
        InventoryDao inventoryDao = null;
        String userInventoryChoice = menu.getTypeOfInventoryFromUser();

        if (userInventoryChoice.equalsIgnoreCase("M")) {
            // Load Inventory from Memory
            inventoryDao = new MemoryInventoryDao();
        } else if (userInventoryChoice.equalsIgnoreCase("F")) {
            // Load Inventory from a file
            try {
                inventoryDao = new FileInventoryDao("inventory.csv");
            } catch (FileNotFoundException e) {
                menu.tellUserFileNotFound();
            }
        } else if (userInventoryChoice.equalsIgnoreCase("D")) {
            // Load Inventory from the database
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:postgresql://localhost:5432/temart");
            dataSource.setUsername("postgres");
            dataSource.setPassword("postgres1");

            inventoryDao = new JdbcInventoryDao(dataSource);
        }

        return inventoryDao;
    }

}
