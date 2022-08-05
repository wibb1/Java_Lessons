package com.willcampbell.model;

public class QueryStringBuilder {

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

    public enum SORT_ORDER {NONE, ASC, DESC}

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

    public static final String ARTISTS_SONG_VIEW = "artist_list";

    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " +
            ARTISTS_SONG_VIEW + " AS SELECT " + ARTISTS_TABLE + "." + NAME_ARTIST_COLUMN + ", " +
            ALBUMS_TABLE + "." + NAME_ALBUM_COLUMN + " AS " + ALBUM_SONG_COLUMN + ", " +
            SONGS_TABLE + "." + TRACK_SONG_COLUMN + ", " + SONGS_TABLE + "." + TITLE_SONG_COLUMN +
            " FROM " + SONGS_TABLE +
            " INNER JOIN " + ALBUMS_TABLE + " ON " + SONGS_TABLE +
            "." + ALBUM_SONG_COLUMN + " = " + ALBUMS_TABLE + "." + ID_ALBUM_COLUMN +
            " INNER JOIN " + ARTISTS_TABLE + " ON " + ALBUMS_TABLE + "." + ARTIST_ALBUM_COLUMN +
            "=" + ARTISTS_TABLE + "." + ID_ARTIST_COLUMN +
            " ORDER BY " +
            ARTISTS_TABLE + "." + NAME_ARTIST_COLUMN + ", " +
            ALBUMS_TABLE + "." + NAME_ALBUM_COLUMN + ", " +
            SONGS_TABLE + "." + TRACK_SONG_COLUMN;
    public static final String QUERY_VIEW_SONG_INFO = "SELECT " + NAME_ARTIST_COLUMN + ", " +
            ALBUM_SONG_COLUMN + ", " + TRACK_SONG_COLUMN + " FROM " + ARTISTS_SONG_VIEW +
            " WHERE " + TITLE_SONG_COLUMN + "='";

    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + NAME_ARTIST_COLUMN + ", " +
            ALBUM_SONG_COLUMN + ", " + TRACK_SONG_COLUMN + " FROM " + ARTISTS_SONG_VIEW +
            " WHERE " + TITLE_SONG_COLUMN + "=?";

    public static final String INSERT_ARTIST = "INSERT INTO " + ARTISTS_TABLE + "(" + NAME_ARTIST_COLUMN + ") VALUES(?)";
    public static final String INSERT_ALBUM = "INSERT INTO " + ALBUMS_TABLE + "(" + NAME_ALBUM_COLUMN + ", " + ARTIST_ALBUM_COLUMN + ") VALUES(?, ?)";
    public static final String INSERT_SONG = "INSERT INTO " + SONGS_TABLE + "(" + TRACK_SONG_COLUMN + ", " + TITLE_SONG_COLUMN + ", " + ALBUM_SONG_COLUMN +  ") VALUES(?, ?, ?)";
    public static final String QUERY_ARTISTS = "SELECT " + ID_ARTIST_COLUMN + " FROM " + ARTISTS_TABLE + " WHERE " + NAME_ARTIST_COLUMN + "=?";
    public static final String QUERY_ALBUM = "SELECT " + ID_ALBUM_COLUMN + " FROM " + ALBUMS_TABLE + " WHERE " + NAME_ALBUM_COLUMN + "=?";
    public static final String QUERY_SONG = "SELECT " + ID_SONG_COLUMN + " FROM " + SONGS_TABLE + " WHERE " + TITLE_SONG_COLUMN + "=?";
    /**
     * Methods
     */
    public static StringBuilder getFindAlbumsByArtist(String artist) {
        return getQueryStringWithSingleInput(artist, FIND_ALBUMS_BY_ARTIST);
    }

    public static StringBuilder getFindSongsByAlbum(String song) {
        return getQueryStringWithSingleInput(song, FIND_SONGS_BY_ALBUM);
    }

    public static StringBuilder getFindArtistByAlbum(String album) {
        return getQueryStringWithSingleInput(album, FIND_ARTIST_BY_ALBUM);
    }

    public static StringBuilder getFindAlbumBySong(String song) {
        return getQueryStringWithSingleInput(song, FIND_ALBUM_BY_SONG);
    }

    public static StringBuilder getFindArtistAlbumTrackBySong(String song) {
        return getQueryStringWithSingleInput(song, FIND_ARTIST_ALBUM_TRACK_BY_SONG);
    }

    public static StringBuilder getQuerySongInfoView(String artist) {
        return getQueryStringWithSingleInput(artist, QUERY_VIEW_SONG_INFO);
    }

    public static void addSortOrderBy(StringBuilder sb, SORT_ORDER sortOrder) {
        if (sortOrder != SORT_ORDER.NONE) {
            sb.append(" ORDER BY ");
            sb.append(NAME_ARTIST_COLUMN);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder == SORT_ORDER.DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }
    }

    private static StringBuilder getQueryStringWithSingleInput(String input, String searchString) {
        StringBuilder sb = new StringBuilder(searchString);
        sb.append(input);
        sb.append("'");
        return sb;
    }
}
