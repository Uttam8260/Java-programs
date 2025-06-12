import java.util.*;

public class SpotifyDesignPatterns {

    // --- Core Song & Playlist ---
    static class Song {
        private final String title;
        private final String artist;

        public Song(String title, String artist) {
            this.title = title;
            this.artist = artist;
        }

        public String getTitle() { return title; }
        public String getArtist() { return artist; }

        @Override
        public String toString() {
            return title + " by " + artist;
        }
    }

    static class Playlist {
        private final String name;
        private final List<Song> songs = new ArrayList<>();

        public Playlist(String name) {
            this.name = name;
        }

        public void addSong(Song song) { songs.add(song); }
        public List<Song> getSongs() { return songs; }
        public String getName() { return name; }

        public void show() {
            System.out.println("Playlist: " + name);
            songs.forEach(System.out::println);
        }
    }

    // --- Audio Device (Strategy / Adapter Pattern) ---
    static interface AudioDevice {
        void output(String sound);
    }

    static class Headphones implements AudioDevice {
        @Override
        public void output(String sound) {
            System.out.println("🎧 Headphones Output: " + sound);
        }
    }

    // static class LegacySpeakerSystem {
    //     public void playLegacySound() {
    //         System.out.println("🔊 Legacy system playing sound.");
    //     }
    // }

    // static class LegacyAdapter implements AudioDevice {
    //     private final LegacySpeakerSystem legacy;

    //     public LegacyAdapter(LegacySpeakerSystem legacy) {
    //         this.legacy = legacy;
    //     }

    //     @Override
    //     public void output(String sound) {
    //         System.out.println("🎶 Adapted Output: " + sound);
    //         legacy.playLegacySound();
    //     }
    // }

    // --- Music Player Core ---
    static class MusicPlayer {
        private List<Song> songs = new ArrayList<>();
        private int current = 0;
        private boolean isPlaying = false;

        public void load(List<Song> songs) {
            this.songs = songs;
            current = 0;
        }

        public void play(AudioDevice device) {
            if (songs.isEmpty()) {
                System.out.println("No songs loaded.");
                return;
            }
            isPlaying = true;
            device.output("Playing: " + songs.get(current));
        }

        public void pause() {
            if (isPlaying) {
                System.out.println("⏸️ Music paused.");
                isPlaying = false;
            }
        }
    }

    // --- Decorator Pattern ---
    static class SongWithLyrics extends Song {
        private final Song base;
        private final String lyrics;

        public SongWithLyrics(Song song, String lyrics) {
            super(song.getTitle(), song.getArtist());
            this.base = song;
            this.lyrics = lyrics;
        }

        @Override
        public String toString() {
            return base.toString() + "\nLyrics: " + lyrics;
        }
    }

    // --- Command Pattern ---
    static interface Command {
        void execute();
    }

    static class PlayCommand implements Command {
        private final MusicPlayer player;
        private final AudioDevice device;

        public PlayCommand(MusicPlayer player, AudioDevice device) {
            this.player = player;
            this.device = device;
        }

        @Override
        public void execute() { player.play(device); }
    }

    static class PauseCommand implements Command {
        private final MusicPlayer player;

        public PauseCommand(MusicPlayer player) {
            this.player = player;
        }

        @Override
        public void execute() { player.pause(); }
    }

    // --- Observer Pattern ---
    interface Observer {
        void update(String msg);
    }

    static class UserObserver implements Observer {
        private final String name;

        public UserObserver(String name) { this.name = name; }

        @Override
        public void update(String msg) {
            System.out.println("🔔 " + name + " got notified: " + msg);
        }
    }

    static class NotificationService {
        private final List<Observer> observers = new ArrayList<>();

        public void subscribe(Observer o) { observers.add(o); }
        public void notifyAll(String msg) {
            for (Observer o : observers) {
                o.update(msg);
            }
        }
    }

    // --- Facade Pattern ---
    static class HomeMusicSystem {
        private final MusicPlayer player;
        private final AudioDevice device;

        public HomeMusicSystem(MusicPlayer player, AudioDevice device) {
            this.player = player;
            this.device = device;
        }

        public void playAll(List<Song> songs) {
            player.load(songs);
            player.play(device);
        }

        public void stop() {
            player.pause();
        }
    }

    public static void main(String[] args) {
    try {
        // Songs & Playlist
        Song s1 = new Song("Levitating", "Dua Lipa");
        Song s2 = new SongWithLyrics(new Song("Photograph", "Ed Sheeran"), "We keep this love in a photograph...");
        Playlist playlist = new Playlist("My Vibes");
        playlist.addSong(s1);
        playlist.addSong(s2);

        System.out.println("=== Showing Playlist ===");
        playlist.show();

        // Audio
        AudioDevice device = new Headphones();
        // Or: new LegacyAdapter(new LegacySpeakerSystem());

        // Music Player
        MusicPlayer player = new MusicPlayer();
        HomeMusicSystem homeSystem = new HomeMusicSystem(player, device);

        System.out.println("\n=== Starting Music via Facade ===");
        homeSystem.playAll(playlist.getSongs());
        Thread.sleep(2000);

        System.out.println("\n=== Executing Commands ===");
        Command playCmd = new PlayCommand(player, device);
        Command pauseCmd = new PauseCommand(player);
        playCmd.execute();
        Thread.sleep(2000);
        pauseCmd.execute();
        Thread.sleep(2000);

        // Observer
        System.out.println("\n=== Observer Pattern Demo ===");
        NotificationService notifyService = new NotificationService();
        Observer uttam = new UserObserver("Uttam");
        notifyService.subscribe(uttam);
        notifyService.notifyAll("🎵 New album dropped!");
    } catch (InterruptedException e) {
        //e.printStackTrace();
    }
}
}
