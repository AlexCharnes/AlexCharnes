package com.techelevator.hotels;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.IpCountry;
import com.techelevator.hotels.model.Review;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    public static final int MENU_LIST_HOTELS = 1;
    public static final int MENU_LIST_REVIEWS = 2;
    public static final int MENU_SHOW_DETAILS_FOR_HOTEL_1 = 3;
    public static final int MENU_LIST_REVIEWS_FOR_HOTEL_1 = 4;
    public static final int MENU_LIST_HOTELS_WITH_3_STARS = 5;
    public static final int MENU_PUBLIC_API = 6;
    public static final int MENU_EXIT = 0;

    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == MENU_LIST_HOTELS) {
                Hotel[] hotels = hotelService.listHotels();
                consoleService.printHotels(hotels);
            } else if (menuSelection == MENU_LIST_REVIEWS) {
                consoleService.printReviews( hotelService.listReviews() );
            } else if (menuSelection == MENU_SHOW_DETAILS_FOR_HOTEL_1) {
                Hotel hotelOne = hotelService.getHotelById(1);
                consoleService.printHotel(hotelOne);
            } else if (menuSelection == MENU_LIST_REVIEWS_FOR_HOTEL_1) {
                Review[] reviews = hotelService.getReviewsByHotelId(1);
                consoleService.printReviews(reviews);
            } else if (menuSelection == MENU_LIST_HOTELS_WITH_3_STARS) {
                Hotel[] hotels = hotelService.getHotelsByStarRating(3);
                consoleService.printHotels(hotels);
            } else if (menuSelection == MENU_PUBLIC_API) {
                IpCountry country = hotelService.getWithCustomQuery();
                // This println() is here only for demonstration.  It should be in consoleService
                System.out.println(country);
            } else if (menuSelection == MENU_EXIT) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

}
