package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import com.techelevator.movies.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Genre> getGenres() {
        List<Genre> genreList = new ArrayList<>();
        String sql = "SELECT genre_name, genre_id FROM genre;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            Genre genre = new Genre(results.getInt("genre_id"), results.getString("genre_name"));
            genreList.add(genre);
        }

        return genreList;
    }


    @Override
    public Genre getGenreById(int id) {
        Genre genres = null;
        String sql = "SELECT genre_id, genre_name FROM genre WHERE genre_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if(results.next()){
            genres = genreMap(results);
        }
        return genres;
    }


    @Override
    public List<Genre> getGenresByName(String name, boolean useWildCard) {
        List<Genre> genre = new ArrayList<>();
        String sql = "SELECT genre_id, genre_name FROM genre ";

        if (useWildCard){
            sql += "WHERE genre_name ILIKE ?";
            name = "%" + name + "%";

        } else {
            sql += " WHERE genre_name ILIKE ?";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        while(results.next()){
            genre.add(genreMap(results));
        }
        return genre;

    }
    private Genre genreMap(SqlRowSet rowSet){
        Genre genre = new Genre();
        genre.setId(rowSet.getInt("genre_id"));
        genre.setName(rowSet.getString("genre_name"));
        return genre;
    }
    }



