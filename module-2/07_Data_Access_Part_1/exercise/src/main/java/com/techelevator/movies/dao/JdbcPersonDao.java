package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import com.techelevator.movies.model.Genre;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();
        String sql = "SELECT person_id, person_name, birthday, deathday, biography, profile_path, home_page FROM person;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            Person person = mapToPerson(results);
            personList.add(person);
        }
        return personList;

    }

    @Override
    public Person getPersonById(int id) {
        Person person = null;
        String sql = "SELECT person_id, person_name, birthday, deathday, biography, profile_path, home_page FROM person WHERE person_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        while (results.next()){
            person = mapToPerson(results);

        }

        return person;

    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        List<Person> person = new ArrayList<>();
        String sql = "SELECT person_id, person_name, birthday, deathday, biography, profile_path, home_page FROM person ";

        if (useWildCard){
            sql += "WHERE person_name ILIKE ?";
            name = "%" + name + "%";

        } else {
            sql += " WHERE person_name ILIKE ?";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        while(results.next()){
            person.add(mapToPerson(results));
        }
        return person;
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        List<Person> person = new ArrayList<>();
        String sql = "SELECT DISTINCT person_id, person_name, birthday, deathday, biography, profile_path, person.home_page FROM person JOIN movie_actor ON person.person_id = movie_actor.actor_id JOIN movie ON movie_actor.movie_id = movie.movie_id JOIN collection ON movie.collection_id = collection.collection_id ";

        if (useWildCard){
            sql += "WHERE collection_name ILIKE ? ;";
            collectionName = "%" + collectionName + "%";

        } else {
            sql += "WHERE collection_name ILIKE ? ";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionName);
        while(results.next()){
            person.add(mapToPerson(results));
        }
        return person;

    }
    private Person mapToPerson(SqlRowSet rowSet){
        Person person = new Person();
        person.setId(rowSet.getInt("person_id"));
        person.setName(rowSet.getString("person_name"));
        if (rowSet.getDate("birthday") != null ){
        person.setBirthday(rowSet.getDate("birthday").toLocalDate());}
        if (rowSet.getDate("deathday") != null){
        person.setDeathDate(rowSet.getDate("deathday").toLocalDate());}
        person.setBiography(rowSet.getString("biography"));
        person.setProfilePath(rowSet.getString("profile_path"));
        person.setHomePage(rowSet.getString("home_page"));

        return person;
    }
}
