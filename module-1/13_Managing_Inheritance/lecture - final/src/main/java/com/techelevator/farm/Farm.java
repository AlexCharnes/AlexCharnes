package com.techelevator.farm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Farm {

    private static final DateTimeFormatter harvestDateFormatter = DateTimeFormatter.ofPattern("(QQQQ) EEEE MMM dd yyyy");
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String calculateHarvestDate(int plantingMonth, int plantingDay, int growthInDays) {
        LocalDate harvestDate = LocalDate.of(LocalDate.now().getYear(), plantingMonth, plantingDay).plusDays(growthInDays);
        return harvestDate.format(harvestDateFormatter);

    }
}
