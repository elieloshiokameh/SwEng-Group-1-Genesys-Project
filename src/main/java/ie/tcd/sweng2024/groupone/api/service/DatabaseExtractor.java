package ie.tcd.sweng2024.groupone.api.service;

import ie.tcd.sweng2024.groupone.api.ApiApplication;
import ie.tcd.sweng2024.groupone.api.model.Discount;
import org.springframework.boot.SpringApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseExtractor {
    //config file not uploaded to git for security purposes
    private static final String CONFIG_FILE = "/absolute/path/to/application.properties"; //use your path and REPLACE with this example after
    public DatabaseExtractor() {

    }
    List<Discount> getSocietyDiscounts() {
        Connection connection = null;
        ResultSet resultSet = null;
        List<Discount> societyDiscounts = new ArrayList<>();
        String dbUrl = "", dbUsername = "", dbPassword = "";

        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            properties.load(input);
            dbUrl = properties.getProperty("db.url");
            dbUsername = properties.getProperty("db.username");
            dbPassword = properties.getProperty("db.password");
        }
        catch (IOException ex) {
            System.err.println("Failed to read configuration file: " + ex.getMessage());
        }
        try {
            // Establishing connection
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            System.out.println("Connected to the database!");

            Statement statement = connection.createStatement();

            // Select all society discounts
            String sqlQuery = "SELECT * FROM dicount_table";

            // Execute the query
            resultSet = statement.executeQuery(sqlQuery);

            // Process the result set in a temporary discount variable
            while (resultSet.next()) {

                // Retrieve data from each row
                int id = resultSet.getInt("Id");
                String type = resultSet.getString("dicount_type");
                String society = resultSet.getString("society_name");
                String product = resultSet.getString("discount_amount") + " for: " + resultSet.getString("product_name");
                String provider = resultSet.getString("discount_provided");

                Discount temp = new Discount(id, provider, type, product, society);
                societyDiscounts.add(temp);
            }

        } catch (SQLException e) {
            System.err.println("Failed to load from the database!");
            e.printStackTrace();
        } finally {
            // Closing connection
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Disconnected from the database.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return societyDiscounts;
    }
}
