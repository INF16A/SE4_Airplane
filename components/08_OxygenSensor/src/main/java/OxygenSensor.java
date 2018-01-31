public class OxygenSensor {

    private static OxygenSensor Instance = new OxygenSensor();

    public static OxygenSensor getInstance() {
        return Instance;
    }

    public Port port = new Port();

    private String manufacturer = "OxyFoxy";
    private String type = "No.1";
    private String id = "56843";
    private boolean isAlarm = false;

    public class Port implements IOxygenSensor {

        @Override
        public String version() {
            return innerVersion();
        }

        @Override
        public int measure(String airFlow) {
            return airFlow.hashCode();
        }

        @Override
        public boolean alarm() {
            return isAlarm;
        }

    }

    public String innerVersion() {
        return "OxygenSensor(id: " + id + ") by " + manufacturer + " with Type " + type;
    }

}
