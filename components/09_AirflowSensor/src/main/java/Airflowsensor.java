public class Airflowsensor {

    private static Airflowsensor Instance = new Airflowsensor();

    public static Airflowsensor getInstance() {
        return Instance;
    }

    private Port port = new Port();

    private String manufacutrer = "Dumbo";
    private String type = "Der Beschte";
    private int airPressure = 3;
    private boolean isAlarm = false;

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

    public String innerVersion() {
        return "Airflowsensor by " + manufacutrer + " " + type;
    }

    public int innerMeasure(String airFlow) {
        return 3;
    }

    public boolean innerAlarm(int threshhold) {
        return isAlarm;
    }

}
