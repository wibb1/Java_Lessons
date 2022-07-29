package com.willcampbell;

import java.sql.*;

public class Main {

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\Coding\\databases\\testjava.db";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    private static final String TABLE_CONTACTS = "contacts";

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS
                    + " ("
                    + COLUMN_NAME + " TEXT, "
                    + COLUMN_PHONE + " INTEGER, "
                    + COLUMN_EMAIL + " TEXT)"
            );
            statement.close();
            // these are not how you should do them, but he wanted to type out each one, and I couldn't bring myself to repeat all that code.
            insertContact(conn, "Tim", 6545678, "tim@email.com");
            insertContact(conn, "Joe", 45632, "joe@anywhere.com");
            insertContact(conn, "Jane", 4829484, "jane@somewhere.com");
            insertContact(conn, "Fido", 9068, "fido@email.com");

            updateContactPhone(conn, "Jane", 556789);

            deleteContact(conn, "Joe");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts"); // replaces 2 previous lines

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name")
                        + " " + resultSet.getString("phone")
                        + " " + resultSet.getString("email"));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void insertContact(Connection conn, String name, Integer phone, String email) throws SQLException {
        Statement statement = conn.createStatement();
        statement.execute("INSERT INTO " + TABLE_CONTACTS
                + " ("
                + COLUMN_NAME + ", "
                + COLUMN_PHONE + ", "
                + COLUMN_EMAIL + ") " +
                "VALUES('" + name + "', " + phone + ", '" + email + "')");
        statement.close();
    }

    public static void updateContactPhone(Connection conn, String name, Integer phone) throws SQLException {
        Statement statement = conn.createStatement();
        statement.execute("UPDATE " + TABLE_CONTACTS + " SET " + COLUMN_PHONE + "=" + phone + " WHERE " + COLUMN_NAME + "='" + name + "'");
        statement.close();
    }

    public static void deleteContact(Connection conn, String name) throws SQLException {
        Statement statement = conn.createStatement();
        statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE " + COLUMN_NAME + "='" + name + "'");
    }
}
