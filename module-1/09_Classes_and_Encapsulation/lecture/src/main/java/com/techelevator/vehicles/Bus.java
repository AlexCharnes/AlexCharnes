package com.techelevator.vehicles;

import java.util.Locale;

public class Bus {
    /*
    Member / Instance Variables
     */
    private final static int TOTAL_NUMBER_OF_SEATS = 40;

    private String routeName;
    private int passengers;
    private int gallonsOfGas = 50;
    private boolean isDoorOpen = false;

    public Bus() {

    }

    public Bus(String routeName){
        this.routeName = routeName;
    }



    /*
    Getters and Setters give public access to see or change the private member variables
     */

    public String getRouteName(){
        return this.routeName;
    }

    public void setRouteName(String routeName){

            this.routeName = formatRouteName(routeName);
        }

    }

    public int getPassengers() {
        return this.passengers;
    }

    public int getGallonsOfGas() {
        return this.gallonsOfGas;
    }

    public boolean isDoorOpen() {
        return this.isDoorOpen;
    }

    public void openDoor() {
        this.isDoorOpen = true;
    }

    public void closeDoor() {
        this.isDoorOpen = false;
    }

    public int getRemainingSeats() {
        return TOTAL_NUMBER_OF_SEATS - this.passengers;
    }

    public int addGas(int gallonsToAdd) {
        if (this.gallonsOfGas + gallonsToAdd >= 100){
            this.gallonsOfGas = 100;

        } else{
            this.gallonsOfGas += gallonsToAdd;
        }
        return  this.gallonsOfGas;
    }

    public boolean board() {
        if (this.isDoorOpen && getRemainingSeats() >= 1){
            this.passengers += 1;
            return true;
        }
        return false;
    }

    public boolean board(int numberOfBoardingPassengers) {
        if (this.isDoorOpen && getRemainingSeats() >= numberOfBoardingPassengers) {
            this.passengers += numberOfBoardingPassengers
                    return true;
        }
        return false;
    }

    private String formatRouteName(String routeName){
        String name = routeName.replaceAll("", "-"){
            return name.toUpperCase();
    }


}
}
