public class WiredSpeaker implements AudioDevice {
    @Override
    public void output(String sound) {
        System.out.println("Playing via Wired Speaker: " + sound);
    }
}