public class TurbulentAirFlowSensor {

    private static TurbulentAirFlowSensor Instance = new TurbulentAirFlowSensor();
    public Port port = new Port();
    private String manufacturer = "Turbulent Juice";
    private String type = "Juice";
    private String id = "9785643131";
    private boolean isAlarm = false;

    public static TurbulentAirFlowSensor getInstance() {
        return Instance;
    }

    public String innerVersion() {
        return "TurbulentAirFlowSensor(id: " + id + ") by " + manufacturer + " with Type " + type;
    }

    public class Port implements ITurbulentAirFlowSensor {

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

}
