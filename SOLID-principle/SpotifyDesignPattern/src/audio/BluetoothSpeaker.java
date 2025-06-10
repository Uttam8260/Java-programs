public class BluetoothSpeaker implements AudioDevice {
    @Override
    public void output(String sound) {
        System.out.println("Playing via Bluetooth Speaker: " + sound);
    }
}