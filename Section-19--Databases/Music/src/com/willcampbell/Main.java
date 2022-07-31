package com.willcampbell;

import com.willcampbell.model.*;

import java.util.List;
import java.util.Map;

import static com.willcampbell.model.QueryStringBuilder.SORT_ORDER.ASC;

public class Main {
    public static void main(String[] args) {

        String artistName = "Metallica";
        String albumName = "Ride the Lightning";
        String songName = "For Whom the Bell Tolls";

        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Can't open datasource");
            return;
        }
//      TODO - queryAllArtists
        createHeader("queryAllArtists");
        List<Artist> artists = dataSource.queryAllArtists(ASC);
        if (artists == null) {
            System.out.println("No Artists");
            return;
        }

        for (Artist artist : artists) {
            System.out.println("ID: " + artist.getId() + " || Name: " + artist.getName());
        }

//      TODO - findAlbumsByArtist
        createHeader("findAlbumsByArtist");
        List<Album> albums = dataSource.findAlbumsByArtist(artistName);

        if (albums == null) {
            System.out.println("No Such Artist");
            return;
        }
        System.out.println("Artist: " + artistName);
        albums.forEach(album -> System.out.println("Album Name: " + album.getName() + " || ID: " + album.getId()));


//      TODO - findSongsByAlbum
        createHeader("findSongsByAlbum");
        List<Song> songs = dataSource.findSongsByAlbum(albumName);

        if (songs == null) {
            System.out.println("No Such Album");
            return;
        }
        System.out.println("Album: " + albumName);
        songs.forEach(song -> System.out.println("Title: " + song.getTitle() + " || Track: " + song.getTrack() + " || ID: " + song.getId()));

//      TODO - findArtistByAlbum
        createHeader("findArtistByAlbum");
        artists = dataSource.findArtistByAlbum(albumName);

        if (artists == null) {
            System.out.println("No Such Artists");
            return;
        }
        System.out.println("Album: " + albumName);
        artists.forEach(artist -> System.out.println("Artist Name: " + artist.getName() + " || Artist ID: " + artist.getId()));

//      TODO - findAlbumBySong
        createHeader("findAlbumBySong");
        albums = dataSource.findAlbumBySong(songName);

        if (albums == null) {
            System.out.println("No Albums");
            return;
        }
        System.out.println("Song Name: " + songName);
        albums.forEach((album) -> System.out.println("Album Name: " + album.getName() + " || Album ID: " + album.getId() + " || Artist ID: " + album.getArtist()));

//      TODO - findArtistAlbumTrackBySong
        createHeader("findArtistAlbumTrackBySong");
        List<Map<String, List<String>>> songList = dataSource.findArtistAlbumTrackBySong(songName);
        if (songList == null) {
            System.out.println("No Such Song");
            return;
        }

        printSongListMap(songList, songName);


//      TODO - querySongMetaData

        dataSource.querySongMetaData();
        createHeader("querySongMetaData");
        System.out.format("%d songs in the database. ", dataSource.getCount(QueryStringBuilder.SONGS_TABLE));

        dataSource.createViewForSongArtists();

//      TODO - querySongInfoView
        createHeader("querySongInfoView");
        songList = dataSource.querySongInfoView(songName);
        if (songList == null) {
            System.out.println("No Such Song");
            return;
        }

        printSongListMap(songList, songName);










        dataSource.close();
    }



/**    Private methods */
    private static void createHeader(String headerText) {
        System.out.println("\n=============================\n" +
                headerText +
                "\n=============================\n");
    }

    private static void printSongListMap(List<Map<String, List<String>>> songList, String songName) {
        System.out.println("Song Name: " + songName);
        songList.forEach((songInfo) -> System.out.println("Artist Name: " + songInfo.get(songName).get(0) +
                " || Album Name: " + songInfo.get(songName).get(1) + " || Track No.: " + songInfo.get(songName).get(2)));
    }
}
