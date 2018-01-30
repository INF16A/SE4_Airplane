public class FireDetector {

    private static FireDetector Instance = new FireDetector();

    public static FireDetector getInstance() {
        return Instance;
    }

    public Port port = new Port();

    private String manufacturer = "It's Lit";
    private String type = "Topmodell";
    private String id = "35982";
    private boolean isAlarm = false;

    public class Port implements IFireDetector {

        @Override
        public String version() {
            return innerVersion();
        }

        @Override
        public boolean scan(String air) {
            return air.contains("Smoke");
        }

        @Override
        public boolean alarm() {
            return isAlarm;
        }

    }

    public String innerVersion() {
        return "FireDetector(id: " + id + ") by " + manufacturer + " with Type " + type;
    }

}