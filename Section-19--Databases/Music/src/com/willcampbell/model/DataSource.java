package com.willcampbell.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_LOCATION = "D:\\Coding\\GitHub\\Java_Lessons\\Section-19--Databases\\Music\\";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + CONNECTION_LOCATION + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_ALBUM = "album";

    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            printSQLErrorMessage(e, "Could not connect to database:");
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            printSQLErrorMessage(e, "Could not disconnect to database:");
        }
    }

    public List<Artist> queryArtists() {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS);
            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(COLUMN_ARTIST_ID));
                artist.setName(resultSet.getString(COLUMN_ARTIST_NAME));
                artists.add(artist);
            }
            return artists;
        } catch (SQLException e) {
            printSQLErrorMessage(e, "Query failed:");
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                printSQLErrorMessage(e, "Error closing resultSet:");
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                printSQLErrorMessage(e, "Could not close statement:");
            }
        }
    }

    private static void printSQLErrorMessage(SQLException e, String message) {
        System.out.println(message + " " + e.getMessage());
        e.printStackTrace();
    }
}
