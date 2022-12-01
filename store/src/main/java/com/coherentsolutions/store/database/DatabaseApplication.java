package com.coherentsolutions.store.database;
import com.coherentsolutions.domain.CategoryEnum;
import com.coherentsolutions.domain.CategoryFactory;
import com.github.javafaker.Faker;

import java.sql.*;

public class DatabaseApplication {
    private static final Faker faker = new Faker();
    private static final CategoryFactory category = new CategoryFactory();

    public static void printProducts(Connection connection) throws SQLException {
        PreparedStatement findAllProducts = connection.prepareStatement("SELECT * FROM PRODUCT");
        ResultSet rs = findAllProducts.executeQuery();

        while(rs.next()) {
            String product = String.format("Product %d: %s | %d | %d | (Category: %d)",
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getInt("product_price"),
                    rs.getInt("product_rate"),
                    rs.getInt("category_id"));
            System.out.println(product);
        }
    }

    public static void createSchema(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String categorySchema = "create table category (category_id integer, type varchar(255), primary key (category_id))";
        String productSchema = "create table product (product_id integer, product_name varchar(255), product_price integer, product_rate integer, category_id integer, primary key (product_id))";
        statement.executeUpdate(categorySchema);
        statement.executeUpdate(productSchema);
    }

    public static void createCategory(Connection connection, int i) throws SQLException {
        String insertAddressSQL = "INSERT INTO category (category_id, type) VALUES(?,?)";
        PreparedStatement createCategory = connection.prepareStatement(insertAddressSQL);
        createCategory.setInt(1, i);
        createCategory.setString(2, category.getCategory(CategoryEnum.BIKE).toString());
        createCategory.executeUpdate();
    }

    public static void createProduct(Connection connection, int i) throws SQLException {
        String insertPersonSQL = "INSERT INTO product (product_id, product_name, product_price, product_rate, category_id) VALUES(?,?,?,?,?)";
        PreparedStatement createProduct = connection.prepareStatement(insertPersonSQL);
        createProduct.setInt(1, i);
        createProduct.setString(2, faker.commerce().productName());
        createProduct.setInt(3, faker.number().numberBetween(1,999));
        createProduct.setInt(4, faker.number().numberBetween(1,100));
        createProduct.setInt(5, i);
        createProduct.executeUpdate();
    }
}
