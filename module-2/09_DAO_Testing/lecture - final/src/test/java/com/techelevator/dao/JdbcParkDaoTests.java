package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

import java.time.LocalDate;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private Park testPark;

    private JdbcParkDao sut;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
        testPark = new Park(0, "Test Park", LocalDate.now(), 999, true);
    }

    @Test
    public void getParkById_with_valid_id_returns_correct_park() {
        // 1. Determine expected results form test-data.sql data
        //    For id 1 will get back Park 1
        // 2. Call the method to get the park
        Park returnedPark = sut.getParkById(1);
        // 3. Assert the park returned is the one we expected
        Assert.assertEquals(PARK_1, returnedPark);
    }

    @Test
    public void getParkById_with_invalid_id_returns_null_park() {
        Park returnedPark = sut.getParkById(99);
        Assert.assertNull(returnedPark);
    }

    @Test
    public void getParksByState_with_valid_state_returns_correct_parks() {
        List<Park> returnedParks = sut.getParksByState("BB");
        Assert.assertEquals("Expected 1 park returned", 1, returnedParks.size());
        Assert.assertEquals("Wrong park returned", PARK_2, returnedParks.get(0));

        returnedParks = sut.getParksByState("AA");
        Assert.assertEquals("Expected 2 parks returned", 2, returnedParks.size());
        Assert.assertTrue("Park 1 not returned", returnedParks.contains(PARK_1));
        Assert.assertTrue("Park 3 not returned", returnedParks.contains(PARK_3));
    }

    @Test
    public void getParksByState_with_invalid_state_returns_empty_list() {
        List<Park> returnedParks = sut.getParksByState("ZZ");
        Assert.assertEquals(0, returnedParks.size());
    }

    @Test
    public void createPark_creates_park() {
        // 1) Insert the new record using the method we are testing
        Park returnedPark = sut.createPark(testPark);
        // 2) Verify the return from the insert method (create) is correct
        Assert.assertNotNull("Park is null", returnedPark);
        Assert.assertTrue("Park id not set", returnedPark.getParkId() > 0);
        // 3) Select the park using the new id
        Park selectedPark = sut.getParkById( returnedPark.getParkId() );
        // 4) Verify the park returned by the select is the correct park
        testPark.setParkId( returnedPark.getParkId() );
        Assert.assertEquals(testPark, selectedPark);
    }

    @Test
    public void updatePark_updates_park() {
        // 1) Select a park from the database
        Park parkToUpdate = sut.getParkById(1);
        // 2) change the values in the returned park
        parkToUpdate.setParkName("updated");
        parkToUpdate.setDateEstablished(LocalDate.of(1500, 01, 01));
        parkToUpdate.setHasCamping(false);
        parkToUpdate.setArea(99999);
        // 3) call the update method with the changed park
        sut.updatePark(parkToUpdate);
        // 4) select the park from the database again
        Park parkAfterUpdate = sut.getParkById(1);
        // 5) Assert the park returned after update contains the updated values
        Assert.assertEquals(parkToUpdate, parkAfterUpdate);

    }

    @Test
    public void deleteParkById_deletes_park() {
        // 1) delete the park
        int rowsDeleted = sut.deleteParkById(1);
        // 2) Verify the right number of rows returned
        Assert.assertEquals(1, rowsDeleted);
        // 3) select the park and make sure it is null
        Park returnedPark = sut.getParkById(1);
        Assert.assertNull(returnedPark);
    }

    @Test
    public void linkParkState_adds_park_to_list_of_parks_in_state() {
        sut.linkParkState(3, "BB");
        List<Park> parksReturned = sut.getParksByState("BB");
        Assert.assertEquals(2, parksReturned.size());
        Assert.assertTrue(parksReturned.contains(PARK_3));
    }

    @Test
    public void unlinkParkState_removes_park_from_list_of_parks_in_state() {
        sut.unlinkParkState(3, "AA");
        List<Park> parksReturned = sut.getParksByState("AA");
        Assert.assertEquals(1, parksReturned.size());
        Assert.assertEquals(PARK_1, parksReturned.get(0));
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

    /*
        Example using JdbcTemplate to select data instead of an existing
        method.

        Everything below this comment is just a demonstration that you don't
        need to follow here at TE.
     */

    @Test
    public void createPark_creates_park_without_select_method() {
        // 1) Insert the new record using the method we are testing
        Park returnedPark = sut.createPark(testPark);
        // 2) Verify the return from the insert method (create) is correct
        Assert.assertNotNull("Park is null", returnedPark);
        Assert.assertTrue("Park id not set", returnedPark.getParkId() > 0);
        // 3) Select the park using the new id
        Park selectedPark = selectParkFromDatabaseById( returnedPark.getParkId() );
        // 4) Verify the park returned by the select is the correct park
        testPark.setParkId( returnedPark.getParkId() );
        Assert.assertEquals(testPark, selectedPark);
    }

    private Park selectParkFromDatabaseById(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, park_name, " +
                "date_established, area, has_camping FROM park WHERE park_id = ?";
        JdbcTemplate dbTemplate = new JdbcTemplate(dataSource);
        SqlRowSet rows = dbTemplate.queryForRowSet(sql, parkId);
        if (rows.next()) {
            park = new Park();
            park.setParkId( rows.getInt("park_id") );
            park.setParkName( rows.getString("park_name") );
            park.setDateEstablished( rows.getDate("date_established").toLocalDate() );
            park.setArea( rows.getDouble("area") );
            park.setHasCamping( rows.getBoolean("has_camping") );
        }
        return park;
    }

}
