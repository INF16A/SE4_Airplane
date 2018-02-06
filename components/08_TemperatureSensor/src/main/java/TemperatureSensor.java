public class TemperatureSensor {

    private static TemperatureSensor Instance = new TemperatureSensor();
    public Port port = new Port();
    private String manufacturer = "KelvinMeter";
    private String type = "Kevin";
    private String id = "32622";
    private int temperature = 22;
    private boolean isAlarm = false;

    public static TemperatureSensor getInstance() {
        return Instance;
    }

    public String innerVersion() {
        return "TemperatureSensor(id: " + id + ") by " + manufacturer + " with Type " + type;
    }

    public class Port implements ITemperatureSensor {

        public String version() {
            return innerVersion();
        }

        public int measure() {
            return temperature;
        }

        public boolean alarm(int threshold) {
            if (threshold < 75) return false;
            else return true;
        }

    }

}
