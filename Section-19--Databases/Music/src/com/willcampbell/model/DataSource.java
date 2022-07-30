package com.willcampbell.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.willcampbell.model.QueryBuilder.*;

public class DataSource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_LOCATION = "D:\\Coding\\GitHub\\Java_Lessons\\Section-19--Databases\\Music\\";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + CONNECTION_LOCATION + DB_NAME;

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
    public List<Artist> queryAllArtists(int sortOrder) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(ARTISTS_TABLE);
        if (sortOrder != NONE_ORDER_BY) {
            sb.append(" ORDER BY ");
            sb.append(NAME_ARTIST_COLUMN);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder == DESC_ORDER_BY) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sb.toString())) {

            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(ID_ARTIST_INDEX));
                artist.setName(resultSet.getString(NAME_ARTIST_INDEX));
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
        StringBuilder sb = new StringBuilder(QueryBuilder.getFindAlbumsByArtist(artistName));

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sb.toString())) {
            List<Album> albums = new ArrayList<>();
            while (resultSet.next()) {
                Album album = new Album();
                album.setArtist(resultSet.getString(ARTIST_ALBUM_INDEX));
                album.setId(resultSet.getInt(ID_ARTIST_INDEX));
                album.setName(resultSet.getString(NAME_ARTIST_INDEX));
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
        StringBuilder sb = new StringBuilder(QueryBuilder.getFindSongsByAlbum(albumName));
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sb.toString())) {
            List<Song> songs = new ArrayList<>();
            while (resultSet.next()) {
                Song song = new Song();
                song.setAlbum(resultSet.getString(ALBUM_SONG_INDEX));
                song.setId(resultSet.getInt(ID_SONG_INDEX));
                song.setTitle(resultSet.getString(TITLE_SONG_INDEX));
                song.setTrack(TRACK_SONG_INDEX);
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
        StringBuilder sb = new StringBuilder(QueryBuilder.getFindArtistByAlbum(albumName));
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sb.toString())) {
            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setName(resultSet.getString(NAME_ARTIST_INDEX));
                artist.setId(resultSet.getInt(ID_ARTIST_INDEX));
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
        StringBuilder sb = new StringBuilder(QueryBuilder.getFindAlbumBySong(songName));
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sb.toString())) {
            List<Album> albums = new ArrayList<>();
            while (resultSet.next()) {
                Album album = new Album();
                album.setArtist(resultSet.getString(ARTIST_ALBUM_INDEX));
                album.setId(resultSet.getInt(ID_ALBUM_INDEX));
                album.setName(resultSet.getString(NAME_ALBUM_INDEX));
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
        StringBuilder sb = new StringBuilder(QueryBuilder.getFindArtistAlbumTrackBySong(songName));
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sb.toString())) {
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
