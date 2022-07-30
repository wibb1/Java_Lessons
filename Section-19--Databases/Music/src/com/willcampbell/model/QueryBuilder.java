package com.willcampbell.model;

public class QueryBuilder {

    public static final String ALBUMS_TABLE = "albums";
    public static final String ID_ALBUM_COLUMN = "_id";
    public static final String NAME_ALBUM_COLUMN = "name";
    public static final String ARTIST_ALBUM_COLUMN = "artist";
    public static final int ID_ALBUM_INDEX = 1;
    public static final int NAME_ALBUM_INDEX = 2;
    public static final int ARTIST_ALBUM_INDEX = 3;

    public static final String ARTISTS_TABLE = "artists";
    public static final String ID_ARTIST_COLUMN = "_id";
    public static final String NAME_ARTIST_COLUMN = "name";
    public static final int ID_ARTIST_INDEX = 1;
    public static final int NAME_ARTIST_INDEX = 2;

    public static final String SONGS_TABLE = "songs";
    public static final String ID_SONG_COLUMN = "_id";

    public static final String TRACK_SONG_COLUMN = "track";
    public static final String TITLE_SONG_COLUMN = "title";
    public static final String ALBUM_SONG_COLUMN = "album";
    public static final int ID_SONG_INDEX = 1;
    public static final int TRACK_SONG_INDEX = 2;
    public static final int TITLE_SONG_INDEX = 3;
    public static final int ALBUM_SONG_INDEX = 4;

    public static final int NONE_ORDER_BY = 1;
    public static final int ASC_ORDER_BY = 2;
    public static final int DESC_ORDER_BY = 3;

    public static final String FIND_ALBUMS_BY_ARTIST =
            "SELECT * FROM " + ALBUMS_TABLE +
                    " JOIN " + ARTISTS_TABLE + " ON " +
                    ARTISTS_TABLE + "." + ID_ARTIST_COLUMN + "=" + ALBUMS_TABLE + "." + ARTIST_ALBUM_COLUMN
                    + " WHERE " + ARTISTS_TABLE + "." + NAME_ARTIST_COLUMN + "='";

    public static final String FIND_SONGS_BY_ALBUM =
            "SELECT * FROM " + SONGS_TABLE +
                    " JOIN " + ALBUMS_TABLE + " ON " +
                    SONGS_TABLE + "." + ALBUM_SONG_COLUMN + "=" + ALBUMS_TABLE + "." + ID_ALBUM_COLUMN +
                    " WHERE " + ALBUMS_TABLE + "." + NAME_ALBUM_COLUMN + "='";

    public static final String FIND_ARTIST_BY_ALBUM =
            "SELECT " + ARTISTS_TABLE + ".*" + " FROM " + ARTISTS_TABLE +
                    " JOIN " + ALBUMS_TABLE + " ON " +
                    ARTISTS_TABLE + "." + ID_ARTIST_COLUMN + "=" + ALBUMS_TABLE + "." + ARTIST_ALBUM_COLUMN +
                    " WHERE " + ALBUMS_TABLE + "." + NAME_ALBUM_COLUMN + "='";

    public static final String FIND_ALBUM_BY_SONG = "SELECT " + ALBUMS_TABLE + ".*" + " FROM " + ALBUMS_TABLE +
            " JOIN " + SONGS_TABLE + " ON "
            + SONGS_TABLE + "." + ALBUM_SONG_COLUMN + "=" + ALBUMS_TABLE + "." + ID_ALBUM_COLUMN +
            " WHERE " + SONGS_TABLE + "." + TITLE_SONG_COLUMN + "='";

    public static final String FIND_ARTIST_ALBUM_TRACK_BY_SONG =
            "SELECT " + ARTISTS_TABLE + "." + NAME_ARTIST_COLUMN + ", " +
                    ALBUMS_TABLE + "." + NAME_ALBUM_COLUMN + ", " +
                    SONGS_TABLE + "." + TRACK_SONG_COLUMN +
                    " FROM " + SONGS_TABLE +
                    " JOIN " + ALBUMS_TABLE + " ON " + SONGS_TABLE + "." + ALBUM_SONG_COLUMN + "=" + ALBUMS_TABLE + "." + ID_ALBUM_COLUMN +
                    " JOIN " + ARTISTS_TABLE + " ON " + ARTISTS_TABLE + "." + ID_ARTIST_COLUMN + "=" + ALBUMS_TABLE + "." + ARTIST_ALBUM_COLUMN +
                    " WHERE " + SONGS_TABLE + "." + TITLE_SONG_COLUMN + "='";

    public static String getFindAlbumsByArtist(String artist) {
        return getQueryStringWithSingleInput(artist, FIND_ALBUMS_BY_ARTIST);
    }

    public static String getFindSongsByAlbum(String song) {
        return getQueryStringWithSingleInput(song, FIND_SONGS_BY_ALBUM);
    }

    public static String getFindArtistByAlbum(String album) {
        return getQueryStringWithSingleInput(album, FIND_ARTIST_BY_ALBUM);
    }

    public static String getFindAlbumBySong(String song) {
        return getQueryStringWithSingleInput(song, FIND_ALBUM_BY_SONG);
    }

    public static String getFindArtistAlbumTrackBySong(String song) {
        return getQueryStringWithSingleInput(song, FIND_ARTIST_ALBUM_TRACK_BY_SONG);
    }

    private static String getQueryStringWithSingleInput(String input, String searchString) {
        StringBuilder sb = new StringBuilder(searchString);
        sb.append(input + "'");
        return sb.toString();
    }
}
