package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {

        List<Collection> list = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name FROM collection;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            Collection collection = new Collection(results.getInt("collection_id"), results.getString("collection_name"));
            list.add(collection);
        }
        return list;
    }

    @Override
    public Collection getCollectionById(int id) {
        Collection collection = null;
        String sql = "SELECT collection_id, collection_name FROM collection WHERE collection_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        while (results.next()){
            collection = mapRowToCollection(results);

        }

        return collection;
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name FROM collection ";

        if (useWildCard){
            sql += "WHERE collection_name ILIKE ?";
            name = "%" + name + "%";

        } else {
            sql += " WHERE collection_name ILIKE ?";
        }

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        while(results.next()){
            collections.add(mapRowToCollection(results));
        }
        return collections;
    }

    private Collection mapRowToCollection(SqlRowSet rowSet) {
        Collection collection = new Collection();
        collection.setId(rowSet.getInt("collection_id"));
        collection.setName(rowSet.getString("collection_name"));

        return collection;
    }
}
