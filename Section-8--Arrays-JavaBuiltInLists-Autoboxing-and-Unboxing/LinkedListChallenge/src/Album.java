import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private ArrayList<Song> songs;
    private String name;
    private String artist;

    public Album(String albumTitle, String artist) {
        this.name = albumTitle;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String songTitle, double songDuration) {
        Song song = new Song(songTitle, songDuration);
        if (findSong(songTitle) == null) {
            this.songs.add(new Song(songTitle, songDuration));
            return true;
        }
        return false;
    }

    public Song findSong(String songTitle) {
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(songTitle)) {
                return checkedSong;
            }
        }
        return null;
    }

    public String getAlbumTitle() {
        return this.name;
    }

    public ArrayList<Song> getAlbumSongs() {
        return this.songs;
    }

    public void setAlbumSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public void printAlbum() {
        System.out.println("Album: " + this.name);
        ListIterator<Song> albumIterator = this.songs.listIterator();
        int i = 1;
        while (albumIterator.hasNext()) {
            System.out.println("\"" + i + "\": \"" + albumIterator.next().getTitle() + "\"");
            i++;
        }
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.size())) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("\"" + this.name + "\" doesn't have a track \"" + trackNumber + "\".");
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song \"" + title + "\" is not in \" " + this.name + "\".");
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
