package com.willcampbell;

import com.willcampbell.model.Album;
import com.willcampbell.model.Artist;
import com.willcampbell.model.DataSource;
import com.willcampbell.model.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String artistName = "Metallica";
        String albumName = "Ride the Lightning";
        String songName = "For Whom the Bell Tolls";
        List<Artist> artists = new ArrayList<>();

        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Can't open datasource");
            return;
        }
//      TODO - queryAllArtists
        createHeader("queryAllArtists");
        artists = dataSource.queryAllArtists();
        if (artists == null) {
            System.out.println("No Artists");
            return;
        }

        for (Artist artist : artists) {
            System.out.println("ID: " + artist.getId() + " || Name: " + artist.getName());
        }

//      TODO - findAlbumsByArtist -- need to fix
        createHeader("findAlbumsByArtist");
        List<Album> albums = dataSource.findAlbumsByArtist(artistName);

        if (albums == null) {
            System.out.println("No Such Artist");
            return;
        }
        System.out.println("Artist: " + artistName);
        albums.stream().forEach(album -> {
            System.out.println("Album Name: " + album.getName() + " || ID: " + album.getId());
        });


//      TODO - findSongsByAlbum
        createHeader("findSongsByAlbum");
        List<Song> songs = dataSource.findSongsByAlbum(albumName);

        if (songs == null) {
            System.out.println("No Such Album");
            return;
        }
        System.out.println("Album: " + albumName);
        songs.stream().forEach(song -> {
            System.out.println("Title: " + song.getTitle() + " || Track: " + song.getTrack() + " || ID: " + song.getId());
        });

//      TODO - findArtistByAlbum || need to fix
        createHeader("findArtistByAlbum");
        artists = dataSource.findArtistByAlbum(albumName);

        if (artists == null) {
            System.out.println("No Such Artists");
            return;
        }
        System.out.println("Album: " + albumName);
        artists.stream().forEach(artist -> {
            System.out.println("Artist Name: " + artist.getName() + " || Artist ID: " + artist.getId());
        });

//      TODO - findAlbumBySong || need to fix
        createHeader("findAlbumBySong");
        albums = dataSource.findAlbumBySong(songName);

        if (albums == null) {
            System.out.println("No Albums");
            return;
        }
        System.out.println("Song Name: " + songName);
        albums.stream().forEach((album) -> {
            System.out.println("Album Name: " + album.getName() + " || Album ID: " + album.getId() + " || Artist ID: " + album.getArtist());
        });

//      TODO - findArtistAlbumTrackBySong
        createHeader("findArtistAlbumTrackBySong");
        List<Map<String, List<String>>> songList = dataSource.findArtistAlbumTrackBySong(songName);
        if (songList == null) {
            System.out.println("No Such Song");
            return;
        }
//        //TODO - As a for loop
//        System.out.println("for loop");
//        for (Map<String, List<String>> songInfo : songList) {
//            System.out.println("Song Name: " + songName + " Artist Name: " + songInfo.get(songName).get(0) +
//                    " Album Name: " + songInfo.get(songName).get(1) + " Track No.: " + songInfo.get(songName).get(2));
//        }
        //TODO - As a stream
        System.out.println("Song Name: " + songName);
        songList.stream().forEach((songInfo) -> {
            System.out.println("Artist Name: " + songInfo.get(songName).get(0) +
                    " || Album Name: " + songInfo.get(songName).get(1) + " || Track No.: " + songInfo.get(songName).get(2));
        });

        dataSource.close();
    }

/**    Private methods */
    private static void createHeader(String headerText) {
        System.out.println("\n=============================\n" +
                headerText +
                "\n=============================\n");
    }
}
