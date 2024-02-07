package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {

    Scanner scanner = new Scanner(new File("HotelInput.csv") {

    });
    List<String> customers = new ArrayList<String>(){};

    private String name;
    // indicates the name on the reservation.

    private double numberOfNights;

    private double estimatedTotal = getNumberOfNights() * getDailyRate();



    private double dailyRate = 59.99;

    private boolean requiresCleaning;

    private boolean usedMinibar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(double numberOfNights) {
        this.numberOfNights = numberOfNights;
    }



    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }


    public HotelReservation(String name, double numberOfNights) throws FileNotFoundException {
        this.name = name;
        this.numberOfNights = numberOfNights;

    }



    public double finalTotal(boolean usedMinibar, boolean requiresCleaning){
        double totalCost = 0;
        totalCost = dailyRate * numberOfNights;
        if (usedMinibar == true){
            totalCost = totalCost + 12.99;
            if (requiresCleaning == true){
                totalCost = totalCost + 69.98;

            }
        }else if (requiresCleaning == true){
            totalCost = totalCost + 34.99;
        }

        return totalCost;
    }

    public String toString(){
        return "RESERVATION - " + name + " - " + finalTotal(true, false);

    }

}
