package com.techelevator.temart;


import com.techelevator.temart.view.Menu;

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

    }

}
