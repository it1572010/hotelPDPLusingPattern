package com.hotel_pattern.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Anthony
 */
public class Koneksi {

    public static Connection createConnection() throws ClassNotFoundException,
            SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/pdpl_hotel", "root", "");
        connection.setAutoCommit(false);
        return connection;
    }
}
