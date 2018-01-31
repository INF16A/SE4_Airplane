public class RadarAltimeter {

    private static RadarAltimeter Instance = new RadarAltimeter();

    public static RadarAltimeter getInstance() {
        return Instance;
    }

    public Port port = new Port();

    private String manufacturer = "Die Manufaktur";
    private String type = "1Radar";
    private String id = "79846512";
    private boolean isOn = false;
    private int altitude = 10;

    public class Port implements IRadarAltimeter {

        @Override
        public String version() {
            return innerVersion();
        }

        @Override
        public boolean on() {
            isOn = true;
            return isOn;
        }

        @Override
        public void send(String radioWave) {
            System.out.println(radioWave);
        }

        @Override
        public int receive(String radioWave) {
            return radioWave.hashCode();
        }

        @Override
        public int measureAltitude() {
            return altitude;
        }

        @Override
        public boolean off() {
            isOn = false;
            return isOn;
        }
    }

    public String innerVersion() {
        return "RadarAltimeter (id: " + id + ") by " + manufacturer + " with Type " + type;
    }

}
