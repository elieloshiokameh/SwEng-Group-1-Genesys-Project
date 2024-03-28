package ie.tcd.sweng2024.groupone.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Properties;

@SpringBootApplication
public class ApiApplication {
    //config file not uploaded to git for security purposes
    private static final String CONFIG_FILE = "/absolute/path/to/application.properties";
    public static void main(String[] args) {
        Connection connection = null;
        String dbUrl = "", dbUsername = "", dbPassword = "";
        SpringApplication.run(ApiApplication.class, args);
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
            //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // Establishing connection
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            System.out.println("Connected to the database!");

            // Perform database operations here

        } catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
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
    }
}
