public class TCAS {

    private static TCAS Instance = new TCAS();
    public Port port = new Port();
    private String manufacturer = "ExampleManufacturer 1";
    private String type = "Tube101";
    private String id = "1";
    private boolean isOn = true;
    private boolean isConnected;
    private boolean isAlarm = false;
    private int altitude;

    public static TCAS getInstance() {
        return Instance;
    }

    public String innerVersion() {
        return "TCAS(id: " + id + ") by " + manufacturer + " type: " + type;
    }

    public class Port implements ITCAS {

        @Override
        public String version() {
            return innerVersion();
        }

        @Override
        public boolean on() {
            return isOn = true;
        }

        @Override
        public boolean connect(String frequency) {
            return isConnected = frequency.hashCode() % 10 == 0;
        }

        @Override
        public boolean scan(String environment) {
            return environment.contains("Sharknado");
        }

        @Override
        public boolean alarm() {
            return isAlarm;
        }

        @Override
        public int determineAltitude(String environment) {
            return altitude;
        }

        @Override
        public int setAltitude(int value) {
            altitude = value;
            return altitude;
        }

        @Override
        public boolean off() {
            return isOn = false;
        }
    }

}
