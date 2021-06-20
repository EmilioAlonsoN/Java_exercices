package com.my_webside.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private final String url = "jdbc:postgresql://localhost:5432/urp";
    private final String user = "urp";
    private final String password = "urp6008";

    public static Connection getConnection() {

        String url = new Database().url;
        String user = new Database().user;
        String password = new Database().password;

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("connection established");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
