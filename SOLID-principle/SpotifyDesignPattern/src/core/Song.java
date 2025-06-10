
public class Song {
    private final String id;
    private final String title;
    private final String artist;
    private final int duration;

    public Song(String id, String title, String artist, int duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getId(){ return id;}
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getDuration() { return duration; }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + duration + "s)";
    }
}
