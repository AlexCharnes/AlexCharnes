package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class HotelReservationsTest {


    private HotelReservation hotelReservation;

    double numberOfNights = 3;
    @Before
    public void setup() throws FileNotFoundException {
        hotelReservation = new HotelReservation("bob", 2);

    }



    @Test
    public void total_actual_amount(){
        double estimatedResult = hotelReservation.finalTotal(true, false);
        double actualResult = 132.97;
        Assert.assertEquals(estimatedResult, actualResult, .0009);
    }
    @Test
    public void estimated_total_amount(){
        double actualResult = 119.98;
        double estimatedResult = hotelReservation.getDailyRate() * hotelReservation.getNumberOfNights();
        Assert.assertEquals(estimatedResult, actualResult, .0009);
    }




}
