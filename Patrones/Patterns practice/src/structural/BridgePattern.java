package structural;

public class BridgePattern {
    interface Device {
        void turnOn();
        void turnOff();
    }

    static class TV implements Device {
        public void turnOn() { System.out.println("TV is ON"); }
        public void turnOff() { System.out.println("TV is OFF"); }
    }

    class Radio implements Device {
        public void turnOn() { System.out.println("Radio is ON"); }
        public void turnOff() { System.out.println("Radio is OFF"); }
    }

    static abstract class Remote {
        protected Device device;

        public Remote(Device device) { this.device = device; }

        abstract void togglePower();
    }

    static class BasicRemote extends Remote {
        public BasicRemote(Device device) { super(device); }

        public void togglePower() {
            System.out.println("Power button pressed.");
            device.turnOn();
        }
    }

    public class BridgeExample {
        public static void main(String[] args) {
            Device tv = new TV();
            Remote remote = new BasicRemote(tv);
            remote.togglePower();
        }
    }
}
