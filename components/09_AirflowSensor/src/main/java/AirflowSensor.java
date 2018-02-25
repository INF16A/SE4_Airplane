public class AirflowSensor {

    private static AirflowSensor Instance = new AirflowSensor();
    public Port port = new Port();
    private String manufacutrer = "Dumbo";
    private String type = "Der Beschte";
    private int airPressure = 3;
    private boolean isAlarm = false;

    public static AirflowSensor getInstance() {
        return Instance;
    }

    public String innerVersion() {
        return "AirflowSensor by " + manufacutrer + " " + type;
    }

    public int innerMeasure(String airFlow) {
        return 3;
    }

    public boolean innerAlarm(int threshhold) {
        return isAlarm;
    }

    public class Port implements IAirflowSensor {

        @Override
        public String version() {
            return innerVersion();
        }

        @Override
        public int measure(String airFlow) {
            return innerMeasure(airFlow);
        }

        @Override
        public boolean alarm(int threshhold) {
            return innerAlarm(threshhold);
        }

    }

}
