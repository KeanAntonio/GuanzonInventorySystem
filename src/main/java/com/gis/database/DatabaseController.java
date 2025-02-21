package com.gis.database;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseController {
    private static final String URL = "jdbc:mariadb://localhost:3306/gisuser_db"; // Database URL
    private static final String USER = "root"; // MySQL username (default: root)
    private static final String PASSWORD = ""; // MySQL password (default: empty)

    // Method to validate user credentials
    public static boolean validateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            // If a result is returned, the user exists in the database
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // You can implement additional methods here (e.g., for inserting users, etc.)
}
