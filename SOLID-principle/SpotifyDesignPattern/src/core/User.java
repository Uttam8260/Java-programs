import java.util.*;

public class User {
    private final String name;
    private final List<Playlist> playlists = new ArrayList<>();
    public User(String name) { this.name = name; }
    public void addPlaylist(Playlist p) { playlists.add(p); }
    public List<Playlist> getPlaylists() { return playlists; }

    public String getName() {
        return name;
    }
}