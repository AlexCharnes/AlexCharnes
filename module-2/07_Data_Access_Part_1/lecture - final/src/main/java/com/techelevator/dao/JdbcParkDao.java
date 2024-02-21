package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {


    private JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getParkCount() {
        int parkCount = 0;
        String sql = "SELECT COUNT(*) AS count_of_parks FROM park";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        if (results.next()) {
            parkCount = results.getInt("count_of_parks");
        }

        return parkCount;
    }
    
    @Override
    public LocalDate getOldestParkDate() {
        LocalDate oldestParkDate = null;
        String sql = "SELECT MIN(date_established) AS date_of_oldest_park FROM park";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            oldestParkDate = results.getDate("date_of_oldest_park").toLocalDate();
        }
        return oldestParkDate;
    }
    
    @Override
    public double getAverageParkArea() {
        double averageArea = 0;
        String sql = "SELECT AVG(area) AS average_area FROM park";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            averageArea = results.getDouble("average_area");
        }
        return averageArea;
    }
    
    @Override
    public List<String> getParkNames() {
        List<String> parkNames = new ArrayList<String>();
        String sql = "SELECT park_name FROM park";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            parkNames.add( results.getString("park_name") );
        }

        return parkNames;
    }
    
    @Override
    public Park getRandomPark() {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping FROM park " +
                "ORDER BY random() " +
                "LIMIT 1;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksWithCamping() {
        List<Park> parks = new ArrayList<Park>();
        String sql = "SELECT park_id, park_name, date_established, area, has_camping FROM park " +
                "WHERE has_camping = true";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Park park = mapRowToPark(results);
            parks.add( park );
        }

        return parks;
    }

    @Override
    public Park getParkById(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping FROM park " +
                "WHERE park_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        while (results.next()) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> parks = new ArrayList<Park>();
        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping FROM park " +
                "JOIN park_state ON park.park_id = park_state.park_id " +
                "WHERE park_state.state_abbreviation = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while (results.next()) {
            parks.add( mapRowToPark(results) );
        }
        return parks;
    }

    @Override
    public List<Park> getParksByName(String name, boolean useWildCard) {
        List<Park> parks = new ArrayList<Park>();
        String sql = "SELECT park_id, park_name, date_established, area, has_camping FROM park ";

        if (useWildCard) {
            sql += " WHERE park_name ILIKE ?";
            name = "%" + name + "%";
        } else {
            sql += " WHERE park_name = ?";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        while (results.next()) {
            parks.add( mapRowToPark(results) );
        }
        return parks;
    }

    private Park mapRowToPark(SqlRowSet results) {
        Park park = new Park();
        park.setParkId( results.getInt("park_id") );
        park.setParkName( results.getString("park_name") );
        if ( results.getDate("date_established") != null ) {
            park.setDateEstablished( results.getDate("date_established").toLocalDate() );
        }
        park.setArea( results.getDouble("area") );
        park.setHasCamping( results.getBoolean("has_camping") );
        return park;
    }
}
