import java.util.*;

public class MusicPlaylist {
    private LinkedList<String> playlist = new LinkedList<>();
    private final int MAX_SIZE = 10;

    public void playSong(String song) {
        playlist.addFirst(song);
        if (playlist.size() > MAX_SIZE) {
            playlist.removeLast(); // remove oldest
        }
        System.out.println("Now playing: " + song);
    }

    public void searchSong(String song) {
        if (playlist.contains(song))
            System.out.println(song + " is in recently played list.");
        else
            System.out.println(song + " not found.");
    }

    public void displayHistory() {
        System.out.println("Recently Played Songs:");
        for (String s : playlist) System.out.println("- " + s);
    }

    public static void main(String[] args) {
        MusicPlaylist mp = new MusicPlaylist();
        mp.playSong("Song A");
        mp.playSong("Song B");
        mp.playSong("Song C");
        mp.searchSong("Song B");
        mp.displayHistory();
    }
}
