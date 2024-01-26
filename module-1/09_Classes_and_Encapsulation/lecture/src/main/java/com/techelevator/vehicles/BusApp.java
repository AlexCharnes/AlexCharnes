package com.techelevator.vehicles;

public class BusApp {
    public static void main(String[] args) {


        Bus busOne = new Bus();
        Bus busTwo = new Bus();

        busOne.setRouteName("High Street");
        System.out.println(busOne.getRouteName());


        busTwo.setRouteName("Front Street");

        System.out.println(busOne.getRemainingSeats());
        busOne.addGas(20);
        System.out.println(busOne.board());

        busOne.openDoor();
        System.out.println(busOne.board());
        System.out.println(busOne.getRemainingSeats());


    }
}
