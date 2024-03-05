package com.techelevator.temart.dao;

import com.techelevator.temart.model.Wishlist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcWishlistDao implements WishlistDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcWishlistDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Wishlist create(Wishlist wishlist) {
        String sql = "INSERT INTO wish_list (user_id, name) VALUES (?, ?) RETURNING id, date_created";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, wishlist.getUserId(), wishlist.getName());
        if (rows.next()) {
            wishlist.setId( rows.getInt("id") );
            wishlist.setDateCreated( rows.getDate("date_created").toLocalDate() );
        }
        return wishlist;
    }
}
