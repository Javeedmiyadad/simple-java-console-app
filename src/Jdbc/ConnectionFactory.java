package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {

    public static Connection cnn = null;

    public static Connection getConnection() throws SQLException {
        if (cnn == null) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("Jdbc/dbConfig");
            String dc = resourceBundle.getString("driverClass");
            String url = resourceBundle.getString("url");
            String username = resourceBundle.getString("username");
            String password = resourceBundle.getString("password");

            cnn = DriverManager.getConnection(url, username, password);
        }
        return cnn;

    }
}