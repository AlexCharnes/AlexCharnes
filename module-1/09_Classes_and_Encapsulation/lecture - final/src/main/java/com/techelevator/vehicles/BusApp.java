package com.techelevator.vehicles;

import java.util.Scanner;

public class BusApp {
    public static void main(String[] args) {


        Bus busOne = new Bus();
        Bus busTwo = new Bus("Front Street");

        busOne.setRouteName("High Street");
        System.out.println( busOne.getRouteName() );


        System.out.println(busOne.getRemainingSeats());
        busOne.addGas(20);
        System.out.println(busOne.board());

        busOne.openDoor();
        System.out.println(busOne.board());
        System.out.println(busOne.getRemainingSeats());

    }
}
