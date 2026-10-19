import java.util.*;

public class MediaPlayerQueueEngine {

    static class Song {
        private final String title;
        private final String artist;

        Song(String title, String artist) {
            this.title = title;
            this.artist = artist;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        // Two songs are considered duplicates if both title and artist match,
        // ignoring capitalization and surrounding whitespace.
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Song)) return false;
            Song other = (Song) obj;
            return title.trim().equalsIgnoreCase(other.title.trim())
                    && artist.trim().equalsIgnoreCase(other.artist.trim());
        }

        @Override
        public int hashCode() {
            return Objects.hash(title.trim().toLowerCase(Locale.ROOT),
                    artist.trim().toLowerCase(Locale.ROOT));
        }

        @Override
        public String toString() {
            return title + " — " + artist;
        }
    }

    private final LinkedList<Song> playlist = new LinkedList<>();
    private final LinkedList<Song> recentHistory = new LinkedList<>();

    public void addSong(Song song) {
        playlist.addLast(song);
        System.out.println("Added: " + song);
    }

    public void addSongAtPosition(int position, Song song) {
        if (position < 0 || position > playlist.size()) {
            throw new IndexOutOfBoundsException(
                    "Position must be between 0 and " + playlist.size());
        }
        playlist.add(position, song);
        System.out.println("Inserted at position " + position + ": " + song);
    }

    public void addPrioritySong(Song song) {
        playlist.addFirst(song);
        System.out.println("Priority song added to front: " + song);
    }

    public void removeDuplicateSongs() {
        HashSet<Song> seen = new HashSet<>();
        ListIterator<Song> iterator = playlist.listIterator();

        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (!seen.add(song)) {
                iterator.remove();
            }
        }
        System.out.println("Duplicate songs removed.");
    }

    public Song playNext() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return null;
        }

        Song song = playlist.removeFirst();
        recentHistory.addFirst(song);
        System.out.println("Now playing: " + song);
        return song;
    }

    public void displayRecentHistory(int limit) {
        System.out.println("\nRecent playback history:");
        if (recentHistory.isEmpty()) {
            System.out.println("(empty)");
            return;
        }

        int count = 0;
        for (Song song : recentHistory) {
            if (count++ >= limit) break;
            System.out.println(song);
        }
    }

    public void displayForward() {
        System.out.println("\nPlaylist (forward):");
        ListIterator<Song> iterator = playlist.listIterator();
        if (!iterator.hasNext()) {
            System.out.println("(empty)");
            return;
        }
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void displayBackward() {
        System.out.println("\nPlaylist (backward):");
        ListIterator<Song> iterator = playlist.listIterator(playlist.size());
        if (!iterator.hasPrevious()) {
            System.out.println("(empty)");
            return;
        }
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    public static void main(String[] args) {
        MediaPlayerQueueEngine player = new MediaPlayerQueueEngine();

        Song song1 = new Song("Blinding Lights", "The Weeknd");
        Song song2 = new Song("Levitating", "Dua Lipa");
        Song song3 = new Song("Perfect", "Ed Sheeran");

        player.addSong(song1);
        player.addSong(song2);
        player.addSong(song3);
        player.addSong(new Song("Levitating", "Dua Lipa")); // duplicate example
        player.addSongAtPosition(1, new Song("Yellow", "Coldplay"));
        player.addPrioritySong(new Song("Priority Track", "Demo Artist"));

        player.displayForward();
        player.removeDuplicateSongs();
        player.displayForward();
        player.displayBackward();

        player.playNext();
        player.playNext();
        player.displayRecentHistory(5);
        player.displayForward();
    }
}
