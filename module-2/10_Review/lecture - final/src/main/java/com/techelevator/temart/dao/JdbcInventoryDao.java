package com.techelevator.temart.dao;

import com.techelevator.temart.inventory.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class JdbcInventoryDao implements InventoryDao {

    private static final String SELECT_PRODUCT_SQL = "SELECT sku, product_type.type, product_type.name AS type_name, product.name AS product_name, " +
            "description, perishable, price, weight_in_lbs, taxable " +
            "FROM product " +
            "JOIN product_type ON product_type.id = product.product_Type ";

    private JdbcTemplate jdbcTemplate;

    public JdbcInventoryDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Map<String, Product> getProducts() {
        Map<String, Product> inventory = new HashMap<String, Product>();
        String sql =  SELECT_PRODUCT_SQL + "ORDER BY product_type.name, product.name";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            String sku = results.getString("sku");
            inventory.put(sku, mapRowToProduct(results) );
        }

        return inventory;
    }

    @Override
    public Product getProductBySku(String sku) {
        Product product = null;
        String sql = SELECT_PRODUCT_SQL + "WHERE sku = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, sku);
        if (results.next()) {
            product = mapRowToProduct(results);
        }
        return product;
    }

    private Product mapRowToProduct(SqlRowSet row) {
        Product product = null;

        String sku = row.getString("sku");
        String productType = row.getString("type");
        if (productType.equals("C")) {
            // instantiate a Clothing product
            product = new Clothing(sku);
        } else if (productType.equals("G")) {
            // instantiate a Grocery product
            product = new Grocery(sku);
        } else if (productType.equals("B")) {
            // instantiate a Book product
            product = new Book(sku);
        } else if (productType.equals("H")) {
            // instantiate a HomeGood product
            product = new HomeGood(sku);
        }

        // populate the properties of the product
        product.setName( row.getString("product_name") );
        product.setDescription( row.getString("description") );
        product.setPrice( row.getDouble("price") );
        product.setWeightInLbs( row.getInt("weight_in_lbs") );
        product.setPerishable( row.getString("perishable").equals("Y") ? true : false );
        product.setTaxable( row.getBoolean("taxable") );

        return product;
    }



}
