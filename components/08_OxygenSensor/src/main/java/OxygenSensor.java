public class OxygenSensor {

    private static OxygenSensor Instance = new OxygenSensor();
    public Port port = new Port();
    private String manufacturer = "OxyFoxy";
    private String type = "No.1";
    private String id = "56843";
    private boolean isAlarm = false;

    public static OxygenSensor getInstance() {
        return Instance;
    }

    public String innerVersion() {
        return "OxygenSensor(id: " + id + ") by " + manufacturer + " with Type " + type;
    }

    public class Port implements IOxygenSensor {

        public String version() {
            return innerVersion();
        }

        public int measure(String airFlow) {
            return airFlow.hashCode();
        }

        public boolean alarm() {
            return isAlarm;
        }

    }

}
