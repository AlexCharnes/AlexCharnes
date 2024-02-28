package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
    @RestController - goes on a class and makes it a Controller for a RESTful Web Service

    @RequestMapping - goes on a method and tells Spring to call that method when the endpoint given in path="" is part of the URL
                      and the request is of the type of the RequestMethod (GET vs POST, etc)

    /Hotels/{id} - creates a Path variable
    @PathVariable int id  - tells Spring to get the value of the path parameter named id and set it to the variable

    /Hotels?state=Ohio - this is a request parameter in the query string
    @RequestParam String state - tells Spring to look in the query string for a key "state" and set its value to this variable

    @RequestBody Reservation reservation - tells Spring that there will be JSON in the message body that will match a Reservation object.  Spring
                                           will then deserialize that JSON by instantiating a new Reservation object and populating from the values
                                           in the JSON

 */
@RestController
// @RequestMapping(path="/hotels")  - this is a Global RequestMapping the path will be prepended to every other path in this class
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    // with a global RequestMapping path="/hotels" would end up /hotels/hotels, so we could just use
    // path="" for just /hotels
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list(@RequestParam(required=false) String state,
                            @RequestParam(required=false, defaultValue="") String city,
                            @RequestParam(required=false, defaultValue="0.0") double price) {
        if (state != null || !city.isBlank()) {
            return hotelDao.getHotelsByStateAndCity(state, city);
        }
        return hotelDao.getHotels();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.getHotelById(id);
    }

    /**
     * Return a list of Reservations
     */
    @RequestMapping(path="/reservations", method=RequestMethod.GET)
    public List<Reservation> listReservations() {
        return reservationDao.getReservations();
    }

    /**
        Return a reservation by id
     */
    @RequestMapping(path="/reservations/{reservationId}", method=RequestMethod.GET)
    public Reservation getReservationById(@PathVariable int reservationId) {
        return reservationDao.getReservationById(reservationId);
    }

    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.GET)
    public List<Reservation> getReservationsForHotel(@PathVariable("id") int hotelId) {
        return reservationDao.getReservationsByHotel(hotelId);
    }

    @RequestMapping(path="/hotels/{hotelId}/reservations", method=RequestMethod.POST)
    public Reservation createReservation(@RequestBody Reservation reservation, @PathVariable int hotelId) {
        return reservationDao.createReservation(reservation);
    }
}
