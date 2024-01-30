package com.techelevator.printer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PrinterApp {

    public static void main(String[] args) {

        Product product = new Product("A01", "Surviving TE Book", 12.99, "", 2);
        Animal cat = new Animal("Cat", "Meow");
        StringReverse stringReverse = new StringReverse("Reverse This String");
        Fibonnaci fibonnaci = new Fibonnaci(100);

        List<Printable> thingsThatCanPrint = new ArrayList<Printable>();
        thingsThatCanPrint.add(product);
        thingsThatCanPrint.add(cat);
        thingsThatCanPrint.add(stringReverse);
        thingsThatCanPrint.add(fibonnaci);

        Collections.shuffle(thingsThatCanPrint);

        for (Printable thing : thingsThatCanPrint) {
            thing.print();
            System.out.println();
        }

    }
}
