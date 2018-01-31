public class StallingSensor {

    private static StallingSensor Instance = new StallingSensor();

    public static StallingSensor getInstance() {
        return Instance;
    }

    public Port port = new Port();

    private String manufacturer = "Salingrad";
    private String type ="Bester";
    private String id = "23622";
    private boolean isAlarm = false;

    public class Port implements IStallingSensor {

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

    public String innerVersion() {
        return "StallingSensor(id: " + id + ") by " + manufacturer + " with Type " + type;
    }

}
