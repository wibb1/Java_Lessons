package com.willcampbell.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_LOCATION = "D:\\Coding\\GitHub\\Java_Lessons\\Section-19--Databases\\Music\\";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + CONNECTION_LOCATION + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

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

    /**
     * returns information on all artists in the collection
     */
    public List<Artist> queryAllArtists() {

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT * FROM " + TABLE_ARTISTS)) {

            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(INDEX_ARTIST_ID));
                artist.setName(resultSet.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }
            return artists;
        } catch (SQLException e) {
            printSQLErrorMessage(e, "Query failed:");
            return null;
        }
    }

    /**
     * all albums by single artist
     *
     * @param artistName - the name of the artist
     */
    public List<Album> findAlbumsByArtist(String artistName) {
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT * FROM " + TABLE_ALBUMS +
                             " JOIN " + TABLE_ARTISTS + " ON " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + "=" + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST
                             + " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + "='" + artistName + "'")) {
            List<Album> albums = new ArrayList<>();
            while (resultSet.next()) {
                Album album = new Album();
                album.setArtist(resultSet.getString(INDEX_ALBUM_ARTIST));
                album.setId(resultSet.getInt(INDEX_ARTIST_ID));
                album.setName(resultSet.getString(INDEX_ARTIST_NAME));
                albums.add(album);
            }
            return albums;
        } catch (SQLException e) {
            printSQLErrorMessage(e, "Could not acquire albums list:");
            return null;
        }
    }

    /**
     * songs by album
     *
     * @param albumName - the name of the album
     */
    public List<Song> findSongsByAlbum(String albumName) {
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT * FROM " + TABLE_SONGS +
                             " JOIN " + TABLE_ALBUMS + " ON " +
                             TABLE_SONGS + "." + COLUMN_SONG_ALBUM + "=" + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
                             " WHERE " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + "='" + albumName + "'")) {
            List<Song> songs = new ArrayList<>();
            while (resultSet.next()) {
                Song song = new Song();
                song.setAlbum(resultSet.getString(INDEX_SONG_ALBUM));
                song.setId(resultSet.getInt(INDEX_SONG_ID));
                song.setTitle(resultSet.getString(INDEX_SONG_TITLE));
                song.setTrack(INDEX_SONG_TRACK);
                songs.add(song);
            }
            return songs;
        } catch (SQLException e) {
            printSQLErrorMessage(e, "Unable to acquire songs by album: ");
            return null;
        }
    }

    /**
     * which artists recorded album by album name
     *
     * @param albumName - name of the album
     */
    public List<Artist> findArtistByAlbum(String albumName) {
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT " + TABLE_ARTISTS + ".*" + " FROM " + TABLE_ARTISTS +
                             " JOIN " + TABLE_ALBUMS + " ON " +
                             TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + "=" + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
                             " WHERE " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + "='" + albumName + "'")) {
            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setName(resultSet.getString(INDEX_ARTIST_NAME));
                artist.setId(resultSet.getInt(INDEX_ARTIST_ID));
                artists.add(artist);
            }
            return artists;
        } catch (SQLException e) {
            printSQLErrorMessage(e,
                    "Unable to acquire artist using the album name: " + albumName +
                            ".\nError message: ");
            return null;
        }
    }

    /**
     * which album song is on - returns a list in case there is more than one song name in the collection
     *
     * @param songName - the song that you want the album of
     */
    public List<Album> findAlbumBySong(String songName) {
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT " + TABLE_ALBUMS + ".*" + " FROM " + TABLE_ALBUMS +
                             " JOIN " + TABLE_SONGS + " ON "
                             + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + "=" + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
                             " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + "='" + songName + "'")) {
            List<Album> albums = new ArrayList<>();
            while (resultSet.next()) {
                Album album = new Album();
                album.setArtist(resultSet.getString(INDEX_ALBUM_ARTIST));
                album.setId(resultSet.getInt(INDEX_ALBUM_ID));
                album.setName(resultSet.getString(INDEX_ALBUM_NAME));
                albums.add(album);
            }
            return albums;
        } catch (SQLException e) {
            printSQLErrorMessage(e, "Unable to acquire album using the song name: " + songName +
                    ".\nError message: ");
            return null;
        }
    }

    /**
     * which artist recorded a song and include the album and track number
     */
    public List<Map<String, List<String>>> findArtistAlbumTrackBySong(String songName) {
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT " +
                     TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                     TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
                     TABLE_SONGS + "." + COLUMN_SONG_TRACK +
                     " FROM " + TABLE_SONGS +
                     " JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + "=" + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
                     " JOIN " + TABLE_ARTISTS + " ON " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + "=" + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
                     " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + "='" + songName + "'")) {
            List<Map<String, List<String>>> maps = new ArrayList<>();
            while (resultSet.next()) {
                Map<String, List<String>> map = new HashMap<>();
                List<String> stringList = new ArrayList<>();
                stringList.add(resultSet.getString(1));
                stringList.add(resultSet.getString(2));
                stringList.add(resultSet.getString(3));
                map.put(songName, stringList);
                maps.add(map);
            }
            return maps;
        } catch (SQLException e) {
            printSQLErrorMessage(e, "Unable to perform query");
            return null;
        }
    }

    /**
     * @param e       - system error
     * @param message - message that will be printed
     */
    private static void printSQLErrorMessage(SQLException e, String message) {
        System.out.println(message + " " + e.getMessage());
        e.printStackTrace();
    }
}
