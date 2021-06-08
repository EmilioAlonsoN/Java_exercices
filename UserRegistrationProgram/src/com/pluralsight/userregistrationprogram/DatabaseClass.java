package com.pluralsight.userregistrationprogram;

import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class use for all actions related with a Database.
 */
public class DatabaseClass {

    public DatabaseClass() { }

    private final String url = "jdbc:postgresql://localhost:5432/urp";
    private final String user = "urp";
    private final String password = "urp6008";

    /**
     * Function use to connect with a SQLite database.
     */
    public static void connectSQLite() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/sqlite/db/UserRegistrationProgram.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Function use to connect with a PostgrestSQL database.
     */
    public static Connection getConnection() {
        final String url = "jdbc:postgresql://localhost:5432/urp";
        final String user = "urp";
        final String password = "urp6008";

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

    /**
     * Function use to created a table and his columns in the database.
     */
    public static void setupDatabase(Connection conn) throws SQLException {
        String sql = "CREATE TABLE Users " +
                "(ID SERIAL PRIMARY KEY  NOT NULL," +
                " NAME           TEXT    NOT NULL," +
                " SURNAME        TEXT    NOT NULL," +
                " EMAIL          TEXT    NOT NULL,"+
                " USERNAME       TEXT    NOT NULL," +
                " PASSWORD       TEXT    NOT NULL)";
        ArrayList<String> result = queryDatabase(conn, sql);
        System.out.println(result);
    }

    /**
     * Function use to write a new user into the database.
     */
    public static void saveUser(Connection conn, String name, String surname, String email,
                                                 String username, String password) throws SQLException {
        //Returns true if data has been saved successfully, else false


        PreparedStatement statement = conn.prepareStatement("INSERT INTO users " +
                                                                "(name, surname, email, username, password)" +
                                                                " VALUES (?, ?, ?, ?, ?)");
        statement.setString(1, name);
        statement.setString(2, surname);
        statement.setString(3, email);
        statement.setString(4, username);
        statement.setString(5 ,password);
        statement.executeUpdate();
        statement.close();
    }

    /**
     * Function use to check for usernames duplicate into the database.
     */
    public static boolean checkForDuplicatesDBUser(Connection conn, String inputUsername) throws SQLException {
        // Returns true if this username already exists in the database

        Statement statement = conn.createStatement();

        String query = String.format("select username\n" +
                                            "from users\n" +
                                            "WHERE username = '%s' ;", inputUsername);

        ResultSet resultset = statement.executeQuery(query);

        return resultset.next();
    }

    /**
     * Function use to check for emails duplicate into the database.
     */
    public static boolean checkForDuplicatesDBEmail(Connection conn, String inputEmail) throws SQLException {
        // Returns true if this email already exists in the database

        Statement statement = conn.createStatement();

        String query = String.format("select email\n" +
                "from users\n" +
                "WHERE email = '%s' ;", inputEmail);

        ResultSet resultset = statement.executeQuery(query);

        return resultset.next();
    }

    /**
     * Function use to query to the database.
     */
    public static ArrayList<String> queryDatabase(Connection conn, String query) throws SQLException {
        //Returns the output from a query that is sent to the connected database
        ArrayList<String> allRows = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(query);
        } catch (PSQLException e) {
            e.printStackTrace();
        } finally {
            printResults(resultSet);
        }
        return allRows;
    }

    /**
     * Function use to print the result of a query to the database.
     */
    public static void printResults(ResultSet resultSet) throws SQLException {

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnsNumber = resultSetMetaData.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = resultSet.getString(i);
                System.out.print(columnValue + " " + resultSetMetaData.getColumnName(i));
            }
            System.out.println();
        }
    }
}

