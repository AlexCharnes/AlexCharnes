package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {
        // 1) Build the URL
        String url = API_BASE_URL + "/hotels/" + newReservation.getHotelId() + "/reservations";
        // 2) Instantiate an HttpHeaders
        HttpHeaders httpHeaders = new HttpHeaders();
        // 3) Set the ContentType to application/json
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // 4) Instantiate an HttpEntity<T> T - the data type to serialize into the message body JSON
        //        new HttpEntity<T>(object to serialize, headers)
        HttpEntity<Reservation> httpRequest = new HttpEntity<Reservation>(newReservation, httpHeaders);

        Reservation returnedReservation = null;
        try {
            returnedReservation = restTemplate.postForObject(url, httpRequest, Reservation.class);
        } catch (ResourceAccessException e) {
            // Cannot connect to the server
            BasicLogger.log("Unable to connect to server: " + e.getMessage());
        } catch (RestClientResponseException e) {
            // Response from server, but was an error code
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        }

        return returnedReservation;
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Reservation> requestEntity = new HttpEntity<Reservation>(updatedReservation, httpHeaders);

        boolean isSuccessful = false;
        try {
            restTemplate.put(API_BASE_URL + "/reservations/" + updatedReservation.getId(), requestEntity);
            isSuccessful = true;
        } catch (ResourceAccessException e) {
            BasicLogger.log("Can not connect to server");
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        }

        return isSuccessful;
    }

    /**
     * Delete an existing reservation
     */
    public boolean deleteReservation(int id) {
        boolean isSuccessful = false;
        try {
            restTemplate.delete(API_BASE_URL + "/reservations/" + id);
            isSuccessful = true;
        } catch (ResourceAccessException e) {
            BasicLogger.log("Cannot connect to server");
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getMessage());
        }
        return isSuccessful;
    }

    /* DON'T MODIFY ANY METHODS BELOW */

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;
        try {
            hotels = restTemplate.getForObject(API_BASE_URL + "/hotels", Hotel[].class);
        } catch (RestClientResponseException e) {
            // handles exceptions thrown by rest template and contains status codes
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            // i/o error, ex: the server isn't running
            BasicLogger.log(e.getMessage());
        }
        return hotels;
    }

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            reservations = restTemplate.getForObject(API_BASE_URL + "/hotels/" + hotelId + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {
        Reservation reservation = null;
        try {
            reservation = restTemplate.getForObject(API_BASE_URL + "/reservations/" + reservationId, Reservation.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

}
