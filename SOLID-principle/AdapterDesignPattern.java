public class AdapterDesignPattern{

// Target Interface
 static interface Charger {
    int get5Volt();
}

// Adaptee - an incompatible class
static class ElectricSocket {
    public int get220Volt() {
        return 220;
    }
}

// Adapter - converts 220V to 5V
static class SocketAdapter implements Charger {
    private final ElectricSocket socket;

    public SocketAdapter(ElectricSocket socket) {
        this.socket = socket;
    }

    @Override
    public int get5Volt() {
        int volts = socket.get220Volt();
        // Logic to convert 220V to 5V
        return convertVolt(volts);
    }

    private int convertVolt(int volts) {
        return volts / 44;
    }
}


 static class Mobile {
    public void chargePhone(Charger charger) {
        int volts = charger.get5Volt();
        if (volts == 5) {
            System.out.println("Charging phone with " + volts + "V");
        } else {
            System.out.println("Cannot charge! Incorrect voltage: " + volts + "V");
        }
    }
}
    public static void main(String[] args) {
        ElectricSocket socket = new ElectricSocket();
        Charger adapter = new SocketAdapter(socket);
        Mobile phone = new Mobile();
        phone.chargePhone(adapter);
    }
}
