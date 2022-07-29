package com.willcampbell;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
//        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\Coding\\databases\\testjava.db");
//             Statement statement = conn.createStatement()){
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\Coding\\databases\\testjava.db");
//            conn.setAutoCommit(false); // turns off the autocommit feature
            Statement statement = conn.createStatement();
//            statement.execute("DROP TABLE contacts");
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Tim', 6545678, 'tim@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Joe', 45632, 'joe@anywhere.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Jane', 4829484, 'jane@somewhere.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Fido', 9068, 'fido@email.com')");
//            statement.execute("UPDATE contacts SET phone=5566789 WHERE name='Jane'");
//            statement.execute("DELETE FROM contacts WHERE name='Joe'");
            statement.execute("SELECT * FROM contacts");
            ResultSet resultSet = statement.getResultSet();
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
        }
    }
}
