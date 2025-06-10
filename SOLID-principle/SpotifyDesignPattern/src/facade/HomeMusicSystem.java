import java.util.List;
import core.MusicPlayer;
import core.Song;
import audio.AudioDevice;

public class HomeMusicSystem {
    private final MusicPlayer player;
    private final AudioDevice audioDevice;

    public HomeMusicSystem(MusicPlayer player, AudioDevice device) {
        this.player = player;
        this.audioDevice = device;
    }

    public void startMusic(List<Song> playlist) {
        player.loadPlaylist(playlist);
        player.play(audioDevice);
    }

    public void stopMusic() {
        player.pause();
    }
}
