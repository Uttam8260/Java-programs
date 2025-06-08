public class Headphones implements AudioDevice {
    @Override
    public void output(String sound) {
        System.out.println("Playing via Headphones: " + sound);
    }
}
